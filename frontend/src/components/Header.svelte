<!-- <script>
  import { onMount } from 'svelte';
  import { createEventDispatcher } from 'svelte';
  export let role = ''; 

  let showCreateDropdown = false;  
  const dispatch = createEventDispatcher();

  function toggleCreateDropdown() {
    showCreateDropdown = !showCreateDropdown;
  }
</script>

<header class="bg-[#2c3e50] py-3 w-full fixed top-0 z-10 shadow-md">
  <div class="container mx-auto flex justify-between items-center px-6">
    <img src="/logo.jpg" alt="Logo" class="h-10" />

    <nav class="ml-auto space-x-4 relative">
      <a href="#/dashboard" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Dashboard</a>
      <a href="#/projects" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Projects</a>
      <a href="#/invitations" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Invitations</a>

      {#if role === 'chair'}
        <div class="relative inline-block text-left">
          <button on:click={toggleCreateDropdown} class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">
            Create ▼
          </button>
          {#if showCreateDropdown}
            <div class="absolute mt-2 w-40 bg-white rounded shadow-lg z-20">
              <a href="#/create-project" class="block px-4 py-2 text-gray-700 hover:bg-gray-100">Projects</a>
              <a href="#/create-edition" class="block px-4 py-2 text-gray-700 hover:bg-gray-100">Edition</a>
            </div>
          {/if}
        </div>
      {:else if role === 'supervisor'}
        <a href="#/my-projects" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">My Projects</a>
      {:else if role === 'student'}
        <a href="#/my-projects" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">My Projects</a>
      {/if}

    
      <a href="#/settings" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Settings</a>
      <a href="#/logout" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Logout</a>
    </nav>
  </div>
</header>

<style>
  header {
    width: 100%;
    top: 0;
  }
</style> -->

<script>
  export let role = ''; 
  let showCreateDropdown = false; 
  let showMyProjectsDropdown = false; 


  function openMyProjectsDropdown() {
    showMyProjectsDropdown = true;
  }

  function closeMyProjectsDropdown() {
    setTimeout(() => {
      showMyProjectsDropdown = false;
    }, 500); 
  }

  
  function openCreateDropdown() {
    showCreateDropdown = true;
  }

  function closeCreateDropdown() {
    setTimeout(() => {
      showCreateDropdown = false;
    }, 500); 
  }
</script>

<header class="bg-[#2c3e50] py-3 w-full fixed top-0 z-10 shadow-md">
  <div class="container mx-auto flex justify-between items-center px-6">
    <img src="/logo.jpg" alt="Logo" class="h-10" />

    <nav class="ml-auto space-x-4 relative">
      <a href="#/dashboard" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Dashboard</a>
      <a href="#/projects" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Projects</a>

     
      {#if role === 'chair' || role === 'supervisor'}
        <a href="#/invitations" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Invitations</a>
      {/if}

      
      {#if role === 'chair'}
        <div 
          class="relative inline-block text-left" 
          on:mouseenter={openCreateDropdown} 
          on:mouseleave={closeCreateDropdown}
        >
          <a href="#/create" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">
            Create ▼
          </a>
          {#if showCreateDropdown}
            <div class="absolute mt-2 w-40 bg-white rounded shadow-lg z-20 border border-gray-200">
              <a href="#/create-project" class="block px-4 py-2 text-gray-700 hover:bg-gray-100">Projects</a>
              <a href="#/create-edition" class="block px-4 py-2 text-gray-700 hover:bg-gray-100">Edition</a>
            </div>
          {/if}
        </div>
      {/if}

     
      
{#if role === 'student'}
<div 
  class="relative inline-block text-left" 
  on:mouseenter={openMyProjectsDropdown} 
  on:mouseleave={closeMyProjectsDropdown}
>
  <a href="#/my-projects" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">
    My Projects ▼
  </a>
  {#if showMyProjectsDropdown}
    <div class="absolute mt-2 w-40 bg-white rounded shadow-lg z-20 border border-gray-200">
      <a href="#/my-projects/constant" class="block px-4 py-2 text-gray-700 hover:bg-gray-100">Constant</a>
      <a href="#/my-projects/dynamic" class="block px-4 py-2 text-gray-700 hover:bg-gray-100">Dynamic</a>
      <a href="#/my-projects/view" class="block px-4 py-2 text-gray-700 hover:bg-gray-100">View Project</a>
    </div>
  {/if}
</div>
{/if}


      <a href="#/settings" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Settings</a>
      <a href="#/logout" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Logout</a>
    </nav>
  </div>
</header>

<style>
  header {
    width: 100%;
    top: 0;
  }

  .container {
    max-width: 1200px;
  }

  
  .group-hover\:block {
    display: block;
    transition: opacity 0.2s ease-in-out;
  }
</style>
