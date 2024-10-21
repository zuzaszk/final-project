<script>
    import { onMount } from 'svelte';
    import { push } from 'svelte-spa-router';
  
    let token = '';
  
    onMount(() => {
      
      const urlParams = new URLSearchParams(window.location.hash.substring(1));
      token = urlParams.get('access_token'); 
  
     
      if (token) {
        console.log("Facebook token received:", token);  
  
        
        push('/dashboard');
      } else {
        console.error('Token not found or login failed');
      }
    });
  </script>
  
  <div>
    <p>Authenticating with Facebook...</p>
  </div>
  