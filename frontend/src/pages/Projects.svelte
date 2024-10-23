<script>
    import { onMount } from 'svelte';
    import SearchBar from '../components/SearchBar.svelte';
    import ProjectCard from '../components/ProjectCard.svelte';
    import Pagination from '../components/Pagination.svelte';
    import { push } from 'svelte-spa-router';
  
    let projects = [];  
    let filteredProjects = [];  
    let currentPage = 1;
    let totalPages = 1;
    let year = '';
    let language = '';
    let projectName = '';
  
    
    async function fetchProjects() {
      try {
        const response = await fetch('http://localhost:8080/zpi/project/listAll');
        if (response.ok) {
          const data = await response.json();
          projects = data;  
          filteredProjects = projects; 
          totalPages = Math.ceil(filteredProjects.length / 10);  
        } else {
          console.error('Failed to fetch projects');
        }
      } catch (error) {
        console.error('Error fetching projects:', error);
      }
    }
  
    
    function handleSearch(year, language, projectName) {
      
      filteredProjects = projects.filter(project => {
        return (!year || project.year === parseInt(year)) &&
               (!language || project.language.toLowerCase() === language.toLowerCase()) &&
               (!projectName || project.title.toLowerCase().includes(projectName.toLowerCase()));
      });
  
     
      totalPages = Math.ceil(filteredProjects.length / 10);
      currentPage = 1;  
    }
  
    onMount(() => {
      fetchProjects();  
    });
  
    
    function handlePageChange(pageNumber) {
      currentPage = pageNumber; 
    }
  
    
    function goToProjectDetails(id) {
      push(`/projects/${id}`);
    }
  </script>
  
  <div class="bg-[#F7F9F9] min-h-screen pt-24 flex flex-col justify-between"> 
    <div class="container mx-auto py-10">
      
      
      <SearchBar on:search={handleSearch} />
    
      
      <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 2xl:grid-cols-5 gap-8 mt-8">
       
        {#each filteredProjects.slice((currentPage - 1) * 10, currentPage * 10) as project}  
          <div on:click={() => goToProjectDetails(project.id)} class="cursor-pointer">
            <ProjectCard {project} />
          </div>
        {/each}
      </div>
    </div>
  
    
    <div class="mt-auto mb-10">
      <Pagination {currentPage} {totalPages} on:pageChange={handlePageChange} />
    </div>
  </div>
  
  <style>
    .container {
      max-width: 1600px;
      padding: 0 20px;
    }
  </style>
  