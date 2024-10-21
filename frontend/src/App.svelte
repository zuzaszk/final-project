<script>
  import Router from 'svelte-spa-router'; 
  import { routes } from './routes'; 
</script>

<main>
  <Router {routes} />
</main>

<style>
  main {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
</style>
