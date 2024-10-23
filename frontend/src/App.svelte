<script>
  import Router, { location } from 'svelte-spa-router';
  import { routes } from './routes';
  import Header from './components/Header.svelte';
  
  // Import the $location store from svelte-spa-router to track the current route
  import { onMount } from 'svelte';

  // This will hold the current path
  let currentPath = '';

  // Subscribe to $location to get the current path
  $: currentPath = $location;

</script>

<!-- Conditionally render the header based on the current route -->
<main class="bg-[#F7F9F9] min-h-screen flex flex-col">
  <!-- Show the header on all pages except login, signup, and forgot-password -->
  {#if currentPath !== '/login' && currentPath !== '/signup' && currentPath !== '/forgot-password' && currentPath!='/' && currentPath!='/reset-password'}
    <Header />
  {/if}

  <!-- The router will handle different pages -->
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
