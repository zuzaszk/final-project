<script>
  import Router, { location } from 'svelte-spa-router';
  import { routes } from './routes';
  import Header from './components/Header.svelte';
  
  
  import { onMount } from 'svelte';


  let currentPath = '';
  let role = 'student';

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
