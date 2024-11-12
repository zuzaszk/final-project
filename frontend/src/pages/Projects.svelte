<!-- <script>
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

    
    let languageId;
    if (language === 'EN') languageId = 1;
    else if (language === 'PL') languageId = 2;

    if (languageId) queryParams.push(`language=${languageId}`);
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
    console.error(error); 
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
    padding: 6px 12px;
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
</style> -->
<!-- <script>
  import { onMount } from 'svelte';
  import { push } from 'svelte-spa-router'; 
  import SearchBar from '../components/SearchBar.svelte';
  import ProjectCard from '../components/ProjectCard.svelte';

  let year = '';
  let language = '';
  let title = '';
  let allProjects = []; // Store all projects initially
  let displayedProjects = []; // Only the projects for the current page
  let currentPage = 1;
  let totalPages = 1;
  let error = '';

  async function fetchProjects() {
    try {
      const queryParams = [];
      if (year) queryParams.push(`year=${year}`);

      let languageId;
      if (language === 'EN') languageId = 1;
      else if (language === 'PL') languageId = 2;

      if (languageId) queryParams.push(`language=${languageId}`);
      if (title.trim()) queryParams.push(`title=${encodeURIComponent(title)}`);

      const queryString = queryParams.length ? `?${queryParams.join('&')}` : '';

      const response = await fetch(`http://192.168.0.102:8080/zpi/project/listAll${queryString}`);
      if (response.ok) {
        allProjects = await response.json();
        totalPages = Math.ceil(allProjects.length / 8);
        updateDisplayedProjects();
      } else {
        error = 'Failed to fetch projects.';
      }
    } catch (err) {
      error = 'Error fetching projects: ' + err.message;
      console.error(error); 
    }
  }

  function updateDisplayedProjects() {
    const startIndex = (currentPage - 1) * 8;
    displayedProjects = allProjects.slice(startIndex, startIndex + 8);
  }

  function goToProjectDetails(projectId) {
    if (!projectId) {
      console.error("Project ID is undefined");
      return;
    }
    console.log("Navigating to project with ID:", projectId);
    push(`/projects/${projectId}`);  
  }

  function changePage(page) {
    currentPage = page;
    updateDisplayedProjects();
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
      {#each displayedProjects as project}
        <div on:click={() => goToProjectDetails(project.projectId)} class="cursor-pointer">
          <ProjectCard {project} />
        </div>
      {/each}
    </div>
  </div>

  <div class="mt-auto mb-10">
    <div class="flex justify-center">
      {#if currentPage > 1}
        <button class="pagination-btn" on:click={() => changePage(currentPage - 1)}>Previous</button>
      {/if}

      {#each Array(totalPages).fill(0).map((_, index) => index + 1) as page}
        <button
          class="pagination-btn {page === currentPage ? 'bg-[#E74C3C] text-white' : ''}"
          on:click={() => changePage(page)}
        >
          {page}
        </button>
      {/each}

      {#if currentPage < totalPages}
        <button class="pagination-btn" on:click={() => changePage(currentPage + 1)}>Next</button>
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
    padding: 6px 12px;
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
</style> -->

<script>
  import { onMount } from 'svelte';
  import { push } from 'svelte-spa-router';
  import SearchBar from '../components/SearchBar.svelte';
  import ProjectCard from '../components/ProjectCard.svelte';

  let year = '';
  let language = '';
  let title = '';
  let allProjects = [];
  let displayedProjects = [];
  let currentPage = 1;
  let totalPages = 1;
  let error = '';
  let viewMode = 'grid';

  async function fetchProjects() {
    try {
      const queryParams = [];
      if (year) queryParams.push(`year=${year}`);
      let languageId;
      if (language === 'EN') languageId = 1;
      else if (language === 'PL') languageId = 2;

      if (languageId) queryParams.push(`language=${languageId}`);
      if (title.trim()) queryParams.push(`title=${encodeURIComponent(title)}`);

      const queryString = queryParams.length ? `?${queryParams.join('&')}` : '';
      const response = await fetch(`http://192.168.0.102:8080/zpi/project/listAll${queryString}`);
      if (response.ok) {
        allProjects = await response.json();
        totalPages = Math.ceil(allProjects.length / 8);
        updateDisplayedProjects();
      } else {
        error = 'Failed to fetch projects.';
      }
    } catch (err) {
      error = 'Error fetching projects: ' + err.message;
      console.error(error);
    }
  }

  function updateDisplayedProjects() {
    const startIndex = (currentPage - 1) * 8;
    displayedProjects = allProjects.slice(startIndex, startIndex + 8);
  }

  function goToProjectDetails(projectId) {
    if (!projectId) {
      console.error("Project ID is undefined");
      return;
    }
    push(`/projects/${projectId}`);
  }

  function changePage(page) {
    currentPage = page;
    updateDisplayedProjects();
  }

  function toggleViewMode(mode) {
    viewMode = mode;
  }

  onMount(() => {
    fetchProjects();
  });
</script>

<div class="bg-[#F7F9F9] min-h-screen pt-24 flex flex-col justify-between">
  <div class="container mx-auto py-10 flex-grow">
    <div class="flex justify-between items-center mb-6">
      <SearchBar bind:year bind:language bind:title handleSearch={fetchProjects} />
      <div class="view-toggle">
        
        <button
          class="view-btn {viewMode === 'grid' ? 'active' : ''}"
          on:click={() => toggleViewMode('grid')}
          aria-label="Grid view"
        >
          <svg xmlns="http://www.w3.org/2000/svg" class="icon" viewBox="0 0 24 24">
            <rect x="3" y="3" width="7" height="7" />
            <rect x="14" y="3" width="7" height="7" />
            <rect x="3" y="14" width="7" height="7" />
            <rect x="14" y="14" width="7" height="7" />
          </svg>
        </button>
       
        <button
          class="view-btn {viewMode === 'list' ? 'active' : ''}"
          on:click={() => toggleViewMode('list')}
          aria-label="List view"
        >
          <svg xmlns="http://www.w3.org/2000/svg" class="icon" viewBox="0 0 24 24">
            <rect x="4" y="4" width="16" height="3" />
            <rect x="4" y="10" width="16" height="3" />
            <rect x="4" y="16" width="16" height="3" />
          </svg>
        </button>
      </div>
    </div>

    {#if error}
      <div class="text-red-600">{error}</div>
    {/if}

    {#if viewMode === 'grid'}
      <!-- Grid view -->
      <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6 mt-10">
        {#each displayedProjects as project}
          <div on:click={() => goToProjectDetails(project.projectId)} class="cursor-pointer">
            <ProjectCard {project} />
          </div>
        {/each}
      </div>
    {:else}
     
      <div class="list-view mt-10">
        {#each displayedProjects as project}
          <div
            on:click={() => goToProjectDetails(project.projectId)}
            class="list-item cursor-pointer text-[#2C3E50] font-semibold text-lg p-4 border-b border-gray-300 hover:bg-gray-100"
          >
            {project.title}
          </div>
        {/each}
      </div>
    {/if}
  </div>

  <div class="mt-auto mb-10">
    <div class="flex justify-center">
      {#if currentPage > 1}
        <button class="pagination-btn" on:click={() => changePage(currentPage - 1)}>Previous</button>
      {/if}

      {#each Array(totalPages).fill(0).map((_, index) => index + 1) as page}
        <button
          class="pagination-btn {page === currentPage ? 'bg-[#E74C3C] text-white' : ''}"
          on:click={() => changePage(page)}
        >
          {page}
        </button>
      {/each}

      {#if currentPage < totalPages}
        <button class="pagination-btn" on:click={() => changePage(currentPage + 1)}>Next</button>
      {/if}
    </div>
  </div>
</div>

<style>
  .container {
    max-width: 1400px;
    padding: 0 15px;
  }

  .view-toggle {
    display: flex;
    gap: 8px;
  }

  .view-btn {
    padding: 6px;
    border-radius: 8px;
    background-color: transparent;
    border: 1px solid #ccc; 
    cursor: pointer;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
    color: #000; 
  }

  .view-btn.active {
    background-color: #007bff;
    border-color: #007bff;
    color: #ffffff;
    box-shadow: 0 2px 6px rgba(0, 123, 255, 0.3);
  }

  .view-btn.active {
    background-color: #2C3E50; 
    border-color: #2C3E50;
    color: #fff;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
  }


  .icon {
    width: 18px;
    height: 18px;
    fill: currentColor;
  }

  .pagination-btn {
    padding: 6px 12px;
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

  .list-view .list-item {
    transition: background-color 0.3s;
  }

  .list-view .list-item:hover {
    background-color: #f7f9f9;
  }

  @media (max-width: 768px) {
    .container {
      padding: 1rem;
    }
  }
</style>
