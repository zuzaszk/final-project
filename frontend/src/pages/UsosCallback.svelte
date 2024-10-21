<script>
    import { onMount } from 'svelte';
    import { push } from 'svelte-spa-router';
  
    let token = '';
    let errorMessage = '';
  
    onMount(() => {
      
      const urlParams = new URLSearchParams(window.location.search);
      token = urlParams.get('ticket'); 
  
      if (token) {
        
        fetch('/api/validate-usos', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ token })
        })
        .then(response => response.json())
        .then(data => {
          if (data.success) {
            
            push('/dashboard');
          } else {
            
            errorMessage = 'USOS login failed. Please try again.';
          }
        })
        .catch(err => {
          console.error('Error validating USOS token:', err);
          errorMessage = 'An error occurred during the login process.';
        });
      } else {
        errorMessage = 'No token provided. Please try again.';
      }
    });
  </script>
  
  <div>
    <p>Authenticating with USOS...</p>
    {#if errorMessage}
      <p class="text-red-500">{errorMessage}</p>
    {/if}
  </div>
  
