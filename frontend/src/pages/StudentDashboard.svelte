<script>
  import { onMount } from 'svelte';

  let userName = 'User';
  let errorMessage = '';


  async function fetchUserInfo() {
    try {
      const response = await fetch('http://localhost:8080/user', {
        credentials: 'include' 
      });

      if (response.ok) {
        const user = await response.json();
        userName = user.name || user.firstName || 'User'; 
      } else {
        errorMessage = 'Failed to load user information.';
      }
    } catch (error) {
      errorMessage = 'An error occurred while fetching user information.';
    }
  }

  
  onMount(fetchUserInfo);
</script>

<div class="message">
  <h1>Welcome to your Dashboard</h1>
  {#if errorMessage}
    <p class="error">{errorMessage}</p>
  {:else}
    <p>You are logged in as <span>{userName}</span>.</p>
  {/if}
  <a href="/logout">Logout</a>
</div>

<style>
  .message {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
  }
  .error {
    color: red;
    margin-top: 1em;
  }
</style>
