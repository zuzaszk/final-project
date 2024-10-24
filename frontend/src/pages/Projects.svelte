<script>
  import { onMount } from 'svelte';
  import { push } from 'svelte-spa-router'; 
  import SearchBar from '../components/SearchBar.svelte';
  import ProjectCard from '../components/ProjectCard.svelte';

  let year = '';
  let language = '';
  let title = '';
  let filteredProjects = [];
  let currentPage = 1;
  let totalPages = 1;
  let error = '';


  async function fetchProjects() {
    try {
      const queryParams = [];
      if (year) queryParams.push(`year=${year}`);
      if (language) queryParams.push(`language=${language}`);
      if (title.trim()) queryParams.push(`title=${encodeURIComponent(title)}`);
      
      const queryString = queryParams.length ? `?${queryParams.join('&')}` : '';

      const response = await fetch(`http://192.168.0.102:8080/zpi/project/listAll${queryString}`);
      if (response.ok) {
        const data = await response.json();
        filteredProjects = data;
        totalPages = Math.ceil(filteredProjects.length / 8);
      } else {
        error = 'Failed to fetch projects.';
      }
    } catch (err) {
      error = 'Error fetching projects: ' + err.message;
    }
  }


  function goToProjectDetails(projectId) {
    if (!projectId) {
      console.error("Project ID is undefined");
      return;
    }
    console.log("Navigating to project with ID:", projectId);
    push(`/projects/${projectId}`);  
  }
  onMount(() => {
    fetchProjects(); 
  });
</script>


<div class="bg-[#F7F9F9] min-h-screen pt-24 flex flex-col justify-between">
  <div class="container mx-auto py-10 flex-grow">
    <SearchBar bind:year bind:language bind:title handleSearch={fetchProjects} />

    {#if error}
      <div class="text-red-600">{error}</div>
    {/if}

  
    <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6 mt-10">
  {#each filteredProjects as project}
    <div on:click={() => goToProjectDetails(project.projectId)} class="cursor-pointer">
      <ProjectCard {project} />
    </div>
  {/each}
    </div>
  </div>


  <div class="mt-auto mb-10">
    <div class="flex justify-center">
      {#if currentPage > 1}
        <button class="pagination-btn" on:click={() => currentPage--}>Previous</button>
      {/if}

      {#each Array(totalPages).fill(0).map((_, index) => index + 1) as page}
        <button
          class="pagination-btn {page === currentPage ? 'bg-[#E74C3C] text-white' : ''}"
          on:click={() => currentPage = page}
        >
          {page}
        </button>
      {/each}

      {#if currentPage < totalPages}
        <button class="pagination-btn" on:click={() => currentPage++}>Next</button>
      {/if}
    </div>
  </div>
</div>


<style>
  .container {
    max-width: 1400px;
    padding: 0 15px;
  }

  .pagination-btn {
    padding: 8px 12px;
    margin: 0 4px;
    border: 1px solid #BDC3C7;
    border-radius: 5px;
    background-color: white;
    color: black;
    cursor: pointer;
    transition: background-color 0.3s ease, color 0.3s ease;
  }

  .pagination-btn:hover {
    background-color: #E74C3C;
    color: white;
    border: none;
  }
</style>
