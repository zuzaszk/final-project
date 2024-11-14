<script>
  import Router, { location } from 'svelte-spa-router';
  import { routes } from './routes';
  import Header from './components/Header.svelte';
  
  
  import { onMount } from 'svelte';


  let currentPath = '';
  let role = 'supervisor';

  $: currentPath = $location;

  

</script>

<main class="bg-[#F7F9F9] min-h-screen flex flex-col">
  
  {#if currentPath !== '/login' && currentPath !== '/signup' && currentPath !== '/forgot-password' && currentPath!='/' && currentPath!='/reset-password'}
    <Header {role} />
  {/if}


  <Router {routes} />
</main>

<style>
  main {
    min-height: 100vh;
    width: 100%;
    display: flex;
    flex-direction: column;
  }
</style>


<!-- 

 <script>
  import Router, { location } from 'svelte-spa-router';
  import { routes } from './routes';
  import Header from './components/Header.svelte';

  let currentPath = '';
  let role = 'student';

  $: currentPath = $location;
</script>

<main class="bg-[#F7F9F9] min-h-screen flex flex-col items-center">
  <div class="container max-w-screen-lg mx-auto px-4">
      {#if currentPath !== '/login' && currentPath !== '/signup' && currentPath !== '/forgot-password' && currentPath != '/' && currentPath != '/reset-password'}
          <Header {role} />
      {/if}
      <Router {routes} />
  </div>
</main>

<style>
  main {
      min-height: 100vh;
      width: 100%;
      display: flex;
      flex-direction: column;
  }
</style> -->

<!-- 
<script>
  import Router, { location } from 'svelte-spa-router';
  import { routes } from './routes';
  import Header from './components/Header.svelte';

  import { onMount } from 'svelte';

  let currentPath = '';
  let role = 'student';

  $: currentPath = $location;
</script>

<main class="bg-[#F7F9F9] min-h-screen flex flex-col items-center">
  {#if currentPath !== '/login' && currentPath !== '/signup' && currentPath !== '/forgot-password' && currentPath !== '/' && currentPath !== '/reset-password'}
    <Header {role} />
  {/if}

  <div class="container max-w-screen-lg mx-auto flex-1 w-full px-4 py-6">
    <Router {routes} />
  </div>
</main>

<style>
  main {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .container {
    width: 100%;
    max-width: 1024px; /* Adjust max-width as needed */
    padding: 1rem;
    background-color: #ffffff; /* Optional: Set a background color for content */
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1); /* Optional: Adds a shadow for a card effect */
    border-radius: 8px; /* Optional: Rounds the corners of the container */
  }
</style> -->
