<script>
  import { onMount } from 'svelte';
  import { loc } from 'svelte-spa-router'; 

  let projectId = null;
  let project = {}; 
  let members = []; 
  let evaluations = []; 
  let newComment = '';
  let submitting = false; 
  let userId = 1; 
  let loading = true;
  let error = '';

  
  function getLanguageName(languageCode) {
    if (languageCode === 1) return 'English';
    if (languageCode === 2) return 'Polish';
    return 'Unknown'; 
  }

  $: loc.subscribe(($loc) => {
    const pathParts = $loc.location.split('/');
    projectId = pathParts[pathParts.length - 1]; 
  });

  async function fetchProjectDetails() {
    if (!projectId) {
      error = 'Project ID is missing';
      return;
    }

    try {
      const response = await fetch(`http://192.168.0.102:8080/zpi/project/detail/${projectId}`);
      if (response.ok) {
        const data = await response.json();
        project = data.project || {}; 
        members = data.members?.filter(member => member.role.roleName === 'student') || []; 
        evaluations = data.evaluations || [];
      } else {
        error = 'Failed to load project details.';
      }
    } catch (err) {
      error = 'Error fetching project details: ' + err.message;
    } finally {
      loading = false;
    }
  }

  async function submitComment() {
  if (!newComment.trim()) return;

  submitting = true;
  try {
    const url = `http://192.168.0.102:8080/zpi/evaluation/add?projectId=${projectId}&userId=${userId}&comment=${encodeURIComponent(newComment)}`;

    const response = await fetch(url, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' }
    });

    if (response.ok) {
      const contentType = response.headers.get('content-type');
      

      if (contentType && contentType.includes('text/plain')) {
        const result = await response.text(); 
        console.log('Response:', result); 
        if (result.includes('Comment added successfully')) {
          
          newComment = '';

          
          await fetchProjectDetails(); 
        } else {
          console.error('Unexpected response:', result);
        }
      } else {
        console.error('Unexpected response type:', contentType);
      }
    } else {
      console.error('Failed to submit comment: Network issue or error response');
    }
  } catch (err) {
    console.error('Error submitting comment:', err.message);
  } finally {
    submitting = false;
  }
}



  onMount(() => {
    fetchProjectDetails();
  });
</script>

{#if loading}
  <div class="text-center text-xl text-[#2C3E50]">Loading project details...</div>
{:else if error}
  <div class="text-center text-xl text-red-600">{error}</div>
{:else}

  
  <div class="zoom-container container mx-auto p-6 bg-white rounded-lg shadow-lg mt-20 max-w-6xl h-[650px] overflow-hidden">
    <div class="h-full overflow-y-auto p-4">
      <div class="flex flex-col lg:flex-row justify-between">
        <div class="lg:w-2/3">
          <h1 class="text-4xl font-bold text-[#2C3E50] mb-4">{project.title} ({project.acronym})</h1>

          <!-- Project Description -->
          <h2 class="text-xl font-bold text-[#2C3E50] mb-2">Project Description</h2>
          <p class="text-lg text-[#7F8C8D] mb-6">{project.description}</p>

          <!-- Technologies Used -->
          <h3 class="text-lg font-bold text-[#2C3E50] mb-2">Technologies Used:</h3>
          <p class="text-[#7F8C8D] font-medium mb-6">{project.technology}</p>

          <!-- Language and Year -->
          <div class="flex space-x-10 mb-6">
            <div>
              <h3 class="text-lg font-bold text-[#2C3E50]">Language:</h3>
              <p class="text-[#7F8C8D]">{getLanguageName(project.language)}</p> <!-- Display language -->
            </div>
            <div>
              <h3 class="text-lg font-bold text-[#2C3E50]">Year:</h3>
              <p class="text-[#7F8C8D]">{project.year}</p>
            </div>
          </div>

          <!-- Team Members (Filtered to only show students) -->
          <div class="bg-[#ECF0F1] p-4 rounded-lg mb-6">
            <h3 class="text-lg font-bold text-[#2C3E50] mb-4">Team Members</h3>
            <div class="grid grid-cols-2 gap-4">
              {#each members as member}
                <div class="bg-white p-3 border-l-4 border-[#E74C3C] rounded-lg text-[#2C3E50] font-semibold">
                  {member.firstName} {member.lastName}
                </div>
              {/each}
            </div>
          </div>
        </div>

        <!-- Project Poster -->
        <div class="lg:w-1/3 lg:pl-6 flex justify-center lg:justify-end">
          {#if project.posterUrl}
            <img src={project.posterUrl} alt="Project Poster" class="rounded-lg shadow-lg w-full lg:w-auto h-auto max-h-[600px]" />
          {/if}
        </div>
      </div>

      <!-- Comments Section -->
      <div class="mt-10">
        <h2 class="text-2xl font-bold text-[#2C3E50] mb-4">Comments</h2>

        {#if evaluations.length > 0}
          {#each evaluations as evaluation}
            <div class="bg-[#ECF0F1] p-4 rounded-lg mb-4">
              <strong class="text-[#34495E] font-bold text-lg">Comment:</strong> 
              <p class="text-[#7F8C8D] font-medium">{evaluation.comment}</p>
            </div>
          {/each}
        {:else}
          <p>No comments available.</p>
        {/if}

        <!-- Leave a Comment -->
        <div class="mt-6">
          <h3 class="text-xl font-bold text-[#2C3E50] mb-4">Leave a Comment</h3>
          <textarea
            bind:value={newComment}
            placeholder="Write your comment here..."
            class="w-full h-24 p-3 border border-gray-300 rounded-lg mb-4 bg-white text-gray-800 font-semibold"
          ></textarea>
          <button on:click={submitComment} class="bg-[#E74C3C] text-white font-semibold py-3 px-6 rounded-lg hover:bg-[#C0392B]" disabled={submitting}>
            {submitting ? 'Submitting...' : 'Submit Comment'}
          </button>
        </div>
      </div>
    </div>
  </div>
{/if}


<style>
  .zoom-container {
    transform: scale(0.9);  
    transform-origin: center; 
  }

  .container {
    max-width: 1200px;
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
