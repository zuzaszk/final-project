<script>
  import { onMount } from 'svelte';

  let userName = '';

  
  onMount(() => {
    
    const urlParams = new URLSearchParams(window.location.hash.split('?')[1]);
    userName = urlParams.get('name') || 'User';
  });
</script>

<div class="message">
  <h1>Welcome to your Dashboard</h1>
  <p>You are logged in as <span>{userName}</span>.</p>
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
</style>
