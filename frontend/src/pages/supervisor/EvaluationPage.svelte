<script>
    import { onMount } from 'svelte';
    import { loc } from 'svelte-spa-router';
  
    let projectId = null;
    let project = {};
    let members = [];
    let selectedRating = 0;  // Holds the star rating selected
    let evaluationComment = '';
    let submitting = false;
    let loading = true;
    let error = '';
    let posterUrl = '';  // Stores the URL for the project poster
  
    const userId = 8;  // Set dynamically based on logged-in user
    const roleId = 3;  // Set dynamically if required
  
    function getLanguageName(languageCode) {
      return languageCode === 1 ? 'English' : languageCode === 2 ? 'Polish' : 'Unknown';
    }
  
    // Extract projectId from the URL
    $: loc.subscribe(($loc) => {
      const pathParts = $loc.location.split('/');
      projectId = pathParts[pathParts.length - 1];
    });
  
    // Fetch project details and team members
    async function fetchProjectDetails() {
      if (!projectId) {
        error = 'Project ID is missing';
        loading = false;
        return;
      }
  
      try {
        const response = await fetch(`http://192.168.0.102:8080/zpi/project/basicInfo?projectId=${projectId}`);
        if (response.ok) {
          const data = await response.json();
          project = data;
          members = project.userRole?.filter(member => member.roles?.roleName === 'student') || [];
          // Fetch the poster with a hardcoded element ID or use a dynamic ID
          fetchPoster(12);  // Replace with the actual element ID if available
        } else {
          error = 'Failed to load project details.';
        }
      } catch (err) {
        error = `Error fetching project details: ${err.message}`;
      } finally {
        loading = false;
      }
    }
  
    // Fetch poster image
    async function fetchPoster(projectElementId) {
      try {
        const response = await fetch(`http://192.168.0.102:8080/zpi/projectElements/retrieve?projectElementId=${projectElementId}`);
        if (response.ok) {
          posterUrl = response.url;
        } else {
          console.error('Failed to fetch poster image.');
        }
      } catch (err) {
        console.error(`Error fetching poster image: ${err.message}`);
      }
    }
  
    // Submit an evaluation
    async function submitEvaluation() {
      if (!evaluationComment.trim()) {
        alert("Please provide a comment for your evaluation.");
        return;
      }
      submitting = true;
      try {
        const response = await fetch(`http://192.168.0.102:8080/zpi/evaluations/add`, {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            projectId: projectId,
            userId: userId,
            roleId: roleId,
            score: selectedRating,
            comment: evaluationComment,
            isPublic: 1  // Assuming evaluations are public
          })
        });
  
        if (response.ok) {
          alert("Evaluation submitted successfully.");
          evaluationComment = '';  // Clear input
          selectedRating = 0;
          await fetchProjectDetails();  // Refresh project details to fetch updated evaluations
        } else {
          console.error('Failed to submit evaluation');
        }
      } catch (err) {
        console.error(`Error submitting evaluation: ${err.message}`);
      } finally {
        submitting = false;
      }
    }
  
    onMount(fetchProjectDetails);
  </script>
  
  <!-- Loading or Error Display -->
  {#if loading}
    <div class="text-center text-xl text-[#2C3E50]">Loading project details...</div>
  {:else if error}
    <div class="text-center text-xl text-red-600">{error}</div>
  {:else}
    <!-- Project Details Display -->
    <div class="zoom-container container mx-auto p-6 bg-white rounded-lg shadow-lg mt-20 max-w-6xl h-[650px] overflow-hidden">
      <div class="h-full overflow-y-auto p-4">
        <div class="flex flex-col lg:flex-row justify-between">
          <!-- Project Information -->
          <div class="lg:w-2/3">
            <h1 class="text-4xl font-bold text-[#2C3E50] mb-4">{project.title} ({project.acronym || "N/A"})</h1>
            <h2 class="text-xl font-bold text-[#2C3E50] mb-2">Project Description</h2>
            <p class="text-lg text-[#7F8C8D] mb-6">{project.description || "No description available."}</p>
  
            <h3 class="text-lg font-bold text-[#2C3E50] mb-2">Technologies Used:</h3>
            <p class="text-[#7F8C8D] font-medium mb-6">{project.keywords || "Not specified"}</p>
  
            <!-- Language and Year Information -->
            <div class="flex space-x-10 mb-6">
              <div>
                <h3 class="text-lg font-bold text-[#2C3E50]">Language:</h3>
                <p class="text-[#7F8C8D]">{getLanguageName(project.language)}</p>
              </div>
              <div>
                <h3 class="text-lg font-bold text-[#2C3E50]">Year:</h3>
                <p class="text-[#7F8C8D]">{project.year || "Not specified"}</p>
              </div>
            </div>
  
            <!-- Team Members Section -->
            <div class="bg-[#ECF0F1] p-4 rounded-lg mb-6">
              <h3 class="text-lg font-bold text-[#2C3E50] mb-4">Team Members</h3>
              <div class="grid grid-cols-2 gap-4">
                {#each members as member}
                  <div class="bg-white p-3 border-l-4 border-[#E74C3C] rounded-lg text-[#2C3E50] font-semibold">
                    {member.users.firstName} {member.users.lastName}
                  </div>
                {/each}
              </div>
            </div>
          </div>
  
          <!-- Project Poster -->
          <div class="lg:w-1/3 lg:pl-6 flex justify-center lg:justify-end">
            {#if posterUrl}
              <img src={posterUrl} alt="Project Poster" class="rounded-lg shadow-lg w-full lg:w-auto h-auto max-h-[600px]" />
            {/if}
          </div>
        </div>
  
        <!-- Evaluation Section -->
        <div class="bg-[#F5F5F5] p-6 rounded-lg shadow-inner mt-10">
          <h2 class="text-2xl font-bold text-[#2C3E50] mb-4">Provide Your Evaluation</h2>
  
          <div class="flex items-center mb-6">
            <p class="mr-4 font-semibold text-[#2C3E50]">Score:</p>
            {#each [1, 2, 3, 4, 5] as star}
              <span on:click={() => selectedRating = star} class="cursor-pointer mx-1">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="{star <= selectedRating ? '#F59E0B' : '#D1D5DB'}" class="w-8 h-8">
                  <path d="M12 17.75l-5.45 3.6 1.95-6.22-5.5-4h6.78L12 4.5l1.72 6.64h6.78l-5.5 4 1.95 6.22z"/>
                </svg>
              </span>
            {/each}
          </div>
  
          <textarea
            bind:value={evaluationComment}
            rows="4"
            placeholder="Write your feedback here..."
            class="w-full p-4 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-[#E74C3C] text-[#2C3E50] placeholder-gray-400 bg-white resize-none mb-4"
          ></textarea>
  
          <button
            on:click={submitEvaluation}
            class="bg-[#E74C3C] text-white py-2 px-6 rounded-md font-semibold hover:bg-[#C0392B] transition duration-200"
            disabled={submitting}
          >
            {submitting ? 'Submitting...' : 'Submit Evaluation'}
          </button>
        </div>
      </div>
    </div>
  {/if}
  
  <style>
    .zoom-container {
      transform: scale(0.85);
      transform-origin: center;
    }
  
    .container {
      max-width: 1200px;
      height: 700px;
    }
  
    @media (max-width: 768px) {
      .container {
        padding: 1rem;
      }
  
      h1 {
        font-size: 1.75rem;
      }
  
      h2, h3 {
        font-size: 1.25rem;
      }
  
      p, span {
        font-size: 0.875rem;
      }
    }
  </style>
  