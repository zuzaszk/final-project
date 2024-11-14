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
<!-- 
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
</style> -->
<!-- 
<script>
  export let role = ''; 
  let showCreateDropdown = false; 
  let showMyProjectsDropdown = false;
  let showMobileMenu = false;

  function toggleDropdown(dropdown) {
    if (dropdown === 'create') {
      showCreateDropdown = !showCreateDropdown;
      showMyProjectsDropdown = false;
    } else if (dropdown === 'myProjects') {
      showMyProjectsDropdown = !showMyProjectsDropdown;
      showCreateDropdown = false;
    }
  }

  function toggleMobileMenu() {
    showMobileMenu = !showMobileMenu;
  }
</script>

<header class="bg-[#2c3e50] py-3 w-full fixed top-0 z-10 shadow-md">
  <div class="container max-w-screen-lg mx-auto flex items-center justify-between px-6">
    <img src="/logo.jpg" alt="Logo" class="h-10" />

    
    <nav class="hidden md:flex ml-auto space-x-4 items-center relative">
      <a href="#/dashboard" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Dashboard</a>
      <a href="#/projects" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Projects</a>

      {#if role === 'chair' || role === 'supervisor'}
        <a href="#/invitations" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Invitations</a>
      {/if}

 
      {#if role === 'chair'}
        <div 
          class="relative inline-block text-left"
          on:click={() => toggleDropdown('create')}
        >
          <a class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded cursor-pointer">
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
          on:click={() => toggleDropdown('myProjects')}
        >
          <a class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded cursor-pointer">
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


    <button class="md:hidden text-white" on:click={toggleMobileMenu}>
      ☰
    </button>
  </div>


  {#if showMobileMenu}
    <div class="bg-[#2c3e50] md:hidden">
      <nav class="flex flex-col space-y-2 p-4">
        <a href="#/dashboard" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Dashboard</a>
        <a href="#/projects" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Projects</a>
        
        {#if role === 'chair' || role === 'supervisor'}
          <a href="#/invitations" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Invitations</a>
        {/if}
        
        {#if role === 'chair'}
          <a href="#/create-project" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Create Project</a>
          <a href="#/create-edition" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Create Edition</a>
        {/if}

        {#if role === 'student'}
          <a href="#/my-projects/constant" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">My Projects (Constant)</a>
          <a href="#/my-projects/dynamic" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">My Projects (Dynamic)</a>
          <a href="#/my-projects/view" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">View Project</a>
        {/if}

        <a href="#/settings" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Settings</a>
        <a href="#/logout" class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded">Logout</a>
      </nav>
    </div>
  {/if}
</header>

<style>
  header {
    width: 100%;
    top: 0;
  }

  .container {
    max-width: 1200px;
  }
</style> -->



<!-- 
<script>
  export let role = ''; 
  let showCreateDropdown = false; 
  let showMyProjectsDropdown = false;
  let showMobileMenu = false;

  function toggleDropdown(dropdown) {
    if (dropdown === 'create') {
      showCreateDropdown = !showCreateDropdown;
      showMyProjectsDropdown = false;
    } else if (dropdown === 'myProjects') {
      showMyProjectsDropdown = !showMyProjectsDropdown;
      showCreateDropdown = false;
    }
  }

  function toggleMobileMenu() {
    showMobileMenu = !showMobileMenu;
  }
</script>

<header class="bg-[#2c3e50] py-3 w-full fixed top-0 z-10 shadow-md">
  <div class="container flex items-center justify-between w-full px-6">
    <img src="/logo.jpg" alt="Logo" class="logo h-10" />

    <nav class="nav hidden md:flex ml-auto space-x-4 items-center">
      <a href="#/dashboard" class="nav-link">Dashboard</a>
      <a href="#/projects" class="nav-link">Projects</a>

      {#if role === 'chair' || role === 'supervisor'}
        <a href="#/invitations" class="nav-link">Invitations</a>
      {/if}

      {#if role === 'chair'}
        <div 
          class="relative inline-block text-left"
          on:click={() => toggleDropdown('create')}
        >
          <a class="nav-link cursor-pointer">
            Create ▼
          </a>
          {#if showCreateDropdown}
            <div class="dropdown">
              <a href="#/create-project" class="dropdown-item">Projects</a>
              <a href="#/create-edition" class="dropdown-item">Edition</a>
            </div>
          {/if}
        </div>
      {/if}

      {#if role === 'student'}
        <div 
          class="relative inline-block text-left"
          on:click={() => toggleDropdown('myProjects')}
        >
          <a class="nav-link cursor-pointer">
            My Projects ▼
          </a>
          {#if showMyProjectsDropdown}
            <div class="dropdown">
              <a href="#/my-projects/constant" class="dropdown-item">Constant</a>
              <a href="#/my-projects/dynamic" class="dropdown-item">Dynamic</a>
              <a href="#/my-projects/view" class="dropdown-item">View Project</a>
            </div>
          {/if}
        </div>
      {/if}

      <a href="#/settings" class="nav-link">Settings</a>
      <a href="#/logout" class="nav-link">Logout</a>
    </nav>

    <button class="mobile-menu-btn md:hidden text-white" on:click={toggleMobileMenu}>
      ☰
    </button>
  </div>

  {#if showMobileMenu}
    <div class="bg-[#2c3e50] md:hidden">
      <nav class="flex flex-col space-y-2 p-4">
        <a href="#/dashboard" class="nav-link">Dashboard</a>
        <a href="#/projects" class="nav-link">Projects</a>
        
        {#if role === 'chair' || role === 'supervisor'}
          <a href="#/invitations" class="nav-link">Invitations</a>
        {/if}
        
        {#if role === 'chair'}
          <a href="#/create-project" class="nav-link">Create Project</a>
          <a href="#/create-edition" class="nav-link">Create Edition</a>
        {/if}

        {#if role === 'student'}
          <a href="#/my-projects/constant" class="nav-link">My Projects (Constant)</a>
          <a href="#/my-projects/dynamic" class="nav-link">My Projects (Dynamic)</a>
          <a href="#/my-projects/view" class="nav-link">View Project</a>
        {/if}

        <a href="#/settings" class="nav-link">Settings</a>
        <a href="#/logout" class="nav-link">Logout</a>
      </nav>
    </div>
  {/if}
</header>

<style>
  header {
    width: 100%;
    top: 0;
  }

  .container {
    max-width: 100%; /* Stretch to full width */
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .logo {
    margin-right: auto;
  }

  .nav-link {
    color: white;
    padding: 0.5rem 1rem;
    border-radius: 0.25rem;
    transition: background 0.3s;
  }

  .nav-link:hover {
    background-color: #E74C3C;
  }

  .dropdown {
    position: absolute;
    top: 100%;
    left: 0;
    margin-top: 0.5rem;
    background-color: white;
    border: 1px solid #ccc;
    border-radius: 0.25rem;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
  }

  .dropdown-item {
    display: block;
    padding: 0.5rem 1rem;
    color: #333;
    transition: background 0.2s;
  }

  .dropdown-item:hover {
    background-color: #f1f1f1;
  }

  .mobile-menu-btn {
    margin-left: auto;
  }
</style> -->


<script>
  export let role = '';
  let showCreateDropdown = false;
  let showMyProjectsDropdown = false;
  let showMobileMenu = false;

  function toggleDropdown(dropdown) {
    if (dropdown === 'create') {
      showCreateDropdown = !showCreateDropdown;
      showMyProjectsDropdown = false;
    } else if (dropdown === 'myProjects') {
      showMyProjectsDropdown = !showMyProjectsDropdown;
      showCreateDropdown = false;
    }
  }

  function toggleMobileMenu() {
    showMobileMenu = !showMobileMenu;
  }
</script>

<header class="bg-[#2c3e50] py-3 w-full fixed top-0 z-10 shadow-md">
  <div class="container flex items-center justify-between w-full px-6">
    <img src="/logo.jpg" alt="Logo" class="logo h-10" />

    <!-- Desktop Navigation -->
    <nav class="nav hidden md:flex ml-auto space-x-4 items-center">
      <a href="#/dashboard" class="nav-link">Dashboard</a>
      <a href="#/projects" class="nav-link">Projects</a>

      {#if role === 'chair' || role === 'supervisor'}
        <a href="#/invitations" class="nav-link">Invitations</a>
      {/if}

      <!-- Chair-specific Create Dropdown -->
      {#if role === 'chair'}
        <div class="relative inline-block text-left" on:click={() => toggleDropdown('create')}>
          <a class="nav-link cursor-pointer">Create ▼</a>
          {#if showCreateDropdown}
            <div class="dropdown">
              <a href="#/create-project" class="dropdown-item">Project</a>
              <a href="#/create-edition" class="dropdown-item">Edition</a>
            </div>
          {/if}
        </div>
      {/if}

      <!-- Student My Projects Dropdown -->
      {#if role === 'student'}
        <div class="relative inline-block text-left" on:click={() => toggleDropdown('myProjects')}>
          <a class="nav-link cursor-pointer">My Projects ▼</a>
          {#if showMyProjectsDropdown}
            <div class="dropdown">
              <a href="#/my-projects/constant" class="dropdown-item">Constant</a>
              <a href="#/my-projects/dynamic" class="dropdown-item">Dynamic</a>
              <a href="#/my-projects/view" class="dropdown-item">View Project</a>
            </div>
          {/if}
        </div>
      {/if}

      <!-- Supervisor-specific My Projects and Evaluations links -->
      {#if role === 'supervisor'}
        <a href="#/my-projects" class="nav-link">My Projects</a>
        <a href="#/evaluations" class="nav-link">Evaluations</a>
      {/if}

      <a href="#/settings" class="nav-link">Settings</a>
      <a href="#/logout" class="nav-link">Logout</a>
    </nav>

    <!-- Mobile Menu Button -->
    <button class="mobile-menu-btn md:hidden text-white" on:click={toggleMobileMenu}>
      ☰
    </button>
  </div>

  <!-- Mobile Navigation -->
  {#if showMobileMenu}
    <div class="bg-[#2c3e50] md:hidden">
      <nav class="flex flex-col space-y-2 p-4">
        <a href="#/dashboard" class="nav-link">Dashboard</a>
        <a href="#/projects" class="nav-link">Projects</a>
        
        {#if role === 'chair' || role === 'supervisor'}
          <a href="#/invitations" class="nav-link">Invitations</a>
        {/if}
        
        {#if role === 'chair'}
          <a href="#/create-project" class="nav-link">Create Project</a>
          <a href="#/create-edition" class="nav-link">Create Edition</a>
        {/if}

        {#if role === 'student'}
          <a href="#/my-projects/constant" class="nav-link">My Projects (Constant)</a>
          <a href="#/my-projects/dynamic" class="nav-link">My Projects (Dynamic)</a>
          <a href="#/my-projects/view" class="nav-link">View Project</a>
        {/if}

        {#if role === 'supervisor'}
          <a href="#/my-projects" class="nav-link">My Projects</a>
          <a href="#/evaluations" class="nav-link">Evaluations</a>
        {/if}

        <a href="#/settings" class="nav-link">Settings</a>
        <a href="#/logout" class="nav-link">Logout</a>
      </nav>
    </div>
  {/if}
</header>

<style>
  header {
    width: 100%;
    top: 0;
  }

  .container {
    max-width: 100%;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .logo {
    margin-right: auto;
  }

  .nav-link {
    color: white;
    padding: 0.5rem 0.5rem;
    border-radius: 0.25rem;
    transition: background 0.3s;
  }

  .nav-link:hover {
    background-color: #E74C3C;
  }

  .dropdown {
    position: absolute;
    top: 100%;
    left: 0;
    margin-top: 0.5rem;
    background-color: white;
    border: 1px solid #ccc;
    border-radius: 0.25rem;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
  }

  .dropdown-item {
    display: block;
    padding: 0.5rem 1rem;
    color: #333;
    transition: background 0.2s;
  }

  .dropdown-item:hover {
    background-color: #f1f1f1;
  }

  .mobile-menu-btn {
    margin-left: auto;
  }
</style>
