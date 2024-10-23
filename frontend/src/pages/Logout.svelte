<!-- <script>
  import { onMount } from 'svelte';
  import { push } from 'svelte-spa-router';


  onMount(async () => {
  
    localStorage.removeItem('authToken');

    
    try {
      const response = await fetch('http://localhost:8080/logout', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (response.ok) {
        console.log('Successfully logged out from the backend');
      } else {
        console.error('Failed to log out from the backend');
      }
    } catch (error) {
      console.error('Error during logout:', error);
    }

   
    push('/login');
  });
</script>

<p>Logging out...</p>

<style>
  p {
    text-align: center;
    margin-top: 50px;
    font-size: 18px;
    color: #2c3e50;
  }
</style> -->
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

<p>Logging out...</p>

<style>
  p {
    text-align: center;
    margin-top: 50px;
    font-size: 18px;
    color: #2c3e50;
  }
</style>
