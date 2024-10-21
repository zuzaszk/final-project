<script>
    import { onMount } from 'svelte';
    import { push } from 'svelte-spa-router';
  
    let token = '';
  
    onMount(() => {
      const urlParams = new URLSearchParams(window.location.hash.slice(1));
      token = urlParams.get('access_token');
  
      if (token) {
        console.log("Google token received:", token);  
  
       
        fetch('/api/validate-google', {
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
            console.error('Google login failed');
          }
        });
      } else {
        console.error('Token not found or login failed');
      }
    });
  </script>
  
  <div>
    <p>Authenticating with Google...</p>
  </div>
  