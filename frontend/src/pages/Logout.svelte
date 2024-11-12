<!-- <script>
  import { onMount } from 'svelte';
  import { push } from 'svelte-spa-router';

  let loading = false;
  let errorMessage = '';


  async function logout() {
    try {
      loading = true;


      const response = await fetch('http://localhost:8080/logout', {
        method: 'POST',
        credentials: 'include', 
      });

    
      if (response.ok) {
       
        push('/');
      } else {
        errorMessage = 'Logout failed. Please try again.';
      }
    } catch (error) {
      errorMessage = 'An error occurred during logout. Please try again later.';
    } finally {
      loading = false;
    }
  }

  
  onMount(logout);
</script>

<div class="logout-container">
  {#if loading}
    <p>Logging you out...</p>
  {:else if errorMessage}
    <p class="error">{errorMessage}</p>
    <button on:click={logout}>Try Again</button>
  {/if}
</div>

<style>
  .logout-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    text-align: center;
  }

  .error {
    color: red;
    margin-bottom: 1em;
  }

  button {
    padding: 10px 20px;
    font-size: 1em;
    color: #fff;
    background-color: #e63946;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  button:hover {
    background-color: #d62828;
  }
</style>
 -->




<script>
  import { onMount } from 'svelte';
  import { push } from 'svelte-spa-router';

  onMount(() => {
    localStorage.removeItem('authToken');
    
    setTimeout(() => {
      push('/');
    }, 1000); 
  });
</script>


<div class="logout-container">
  <p>Logging out...</p>
</div>

<style>
  
  .logout-container {
    display: flex;
    justify-content: center;
    align-items: flex-end; 
    min-height: 100vh; 
  }


  p {
    font-size: 18px;
    color: #2c3e50;
    margin-bottom: 300px; 
  }
</style>
