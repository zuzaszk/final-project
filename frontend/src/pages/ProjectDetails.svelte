<script>
    import { onMount } from 'svelte';
    import { params } from 'svelte-spa-router'; 
  
    let projectId = params.id; 
    let project = null; 
    let loading = true; 
    let error = ''; 
    let newComment = ''; 
    let submitting = false; 
    
    
    async function fetchProjectDetails() {
      try {
        const response = await fetch(`http://localhost:8080/zpi/project/listDetails?id=${projectId}`);
        if (response.ok) {
          const data = await response.json();
          project = data;
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
      if (newComment.trim()) {
        submitting = true;
        try {
          const response = await fetch('http://localhost:8080/zpi/project/addComment', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
              projectId: projectId,
              author: 'Anonymous', 
              comment: newComment
            })
          });
  
          if (response.ok) {
            const result = await response.json();
            if (result.success) {
             
              project.comments.push({ author: 'Anonymous', text: newComment });
              newComment = ''; 
            } else {
              console.error('Failed to submit comment:', result.message);
            }
          } else {
            console.error('Failed to submit comment: Network issue');
          }
        } catch (err) {
          console.error('Error submitting comment:', err.message);
        } finally {
          submitting = false;
        }
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
    <div class="container mx-auto p-10 bg-white rounded-lg shadow-lg mt-32 max-w-7xl h-[80vh] overflow-y-auto">
      <h1 class="text-5xl font-bold text-[#2C3E50] mb-6 -mt-10">{project.title} ({project.acronym})</h1>
  
      <div class="grid grid-cols-1 lg:grid-cols-3 gap-10">
        <div class="lg:col-span-2 space-y-6">
          <h2 class="text-3xl font-bold text-[#2C3E50] mb-2">Project Description</h2>
          <p class="text-[#7F8C8D] font-semibold text-lg">{project.description}</p>
  
          <h3 class="text-2xl font-bold text-[#2C3E50] mb-2">Technologies Used:</h3>
          <p class="text-[#7F8C8D] font-semibold text-lg">{project.technologies.join(', ')}</p>
  
          <div class="flex space-x-10">
            <div>
              <h3 class="text-xl font-bold text-[#2C3E50]">Language:</h3>
              <p class="text-[#7F8C8D] font-semibold">{project.language}</p>
            </div>
            <div>
              <h3 class="text-xl font-bold text-[#2C3E50]">Year:</h3>
              <p class="text-[#7F8C8D] font-semibold">{project.year}</p>
            </div>
          </div>
  
          <div class="bg-[#ECF0F1] p-6 rounded-lg">
            <h2 class="text-2xl font-bold text-[#2C3E50] mb-4">Team Members</h2>
            <div class="grid grid-cols-2 gap-4">
              {#each project.teamMembers as member}
                <div class="bg-white p-3 border-l-4 border-[#E74C3C] rounded-lg text-[#2C3E50] font-semibold">
                  {member}
                </div>
              {/each}
            </div>
          </div>
        </div>
  
        <div class="flex justify-center lg:justify-end items-start -mt-20">
          <img src={project.posterUrl} alt="Project Poster" class="rounded-lg shadow-lg w-full lg:w-auto h-auto max-h-[600px]" />
        </div>
      </div>
  
      <div class="mt-10">
        <h2 class="text-3xl font-bold text-[#2C3E50] mb-6">Comments</h2>
  
        {#each project.comments as comment}
          <div class="bg-[#ECF0F1] p-4 rounded-lg mb-4">
            <strong class="text-[#34495E] font-bold text-lg">{comment.author}:</strong>
            <span class="text-[#7F8C8D] font-bold ml-2 text-base">{comment.text}</span>
          </div>
        {/each}
  
        <div class="mt-6">
          <h3 class="text-2xl font-bold text-[#2C3E50] mb-4">Leave a Comment</h3>
          <textarea
            bind:value={newComment}
            placeholder="Write your comment here..."
            class="w-full h-28 p-3 border border-gray-300 rounded-lg mb-4 bg-white text-gray-800 font-semibold"
          ></textarea>
          <button on:click={submitComment} class="bg-[#E74C3C] text-white font-semibold py-2 px-6 rounded-lg hover:bg-[#C0392B]" disabled={submitting}>
            {submitting ? 'Submitting...' : 'Submit Comment'}
          </button>
        </div>
      </div>
    </div>
  {/if}
  