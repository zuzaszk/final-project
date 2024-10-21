<script>
    import { onMount } from 'svelte';
    import { push } from 'svelte-spa-router';
  
    let newPassword = "";
    let confirmPassword = "";
    let token = "";
    let loading = false;
    let errorMessage = "";
    let successMessage = "";
  
    onMount(() => {
      const urlParams = new URLSearchParams(window.location.search);
      token = urlParams.get('token'); 
    });
  
    async function resetPassword() {
      if (newPassword !== confirmPassword) {
        errorMessage = "Passwords do not match.";
        return;
      }
  
      try {
        loading = true;
        const response = await fetch('https://api.example.com/reset-password', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ token, newPassword })
        });
  
        const data = await response.json();
  
        if (response.ok) {
          successMessage = "Password reset successfully. Redirecting to login...";
          setTimeout(() => {
            push('/');
          }, 3000); 
        } else {
          errorMessage = data.message || "Failed to reset password. Please try again.";
        }
      } catch (error) {
        errorMessage = "An error occurred. Please try again.";
      } finally {
        loading = false;
      }
    }
  </script>
  
  
  <div class="flex items-center justify-center w-screen min-h-screen bg-cover bg-center bg-no-repeat relative bg-[url('../pwr4.JPG')]">
    <div class="absolute inset-0 bg-gradient-to-r from-black via-transparent to-black opacity-50"></div>
  
    <div class="relative z-10 w-full max-w-lg p-10 bg-white bg-opacity-90 rounded-lg shadow-lg">
      <h2 class="text-3xl font-bold mb-8 text-gray-800 text-center">Reset Password</h2>
  
      {#if successMessage}
        <p class="text-green-500 mb-4">{successMessage}</p>
      {/if}
  
      {#if errorMessage}
        <p class="text-red-500 mb-4">{errorMessage}</p>
      {/if}
  
      <div class="flex flex-col space-y-4">
        <input
          type="password"
          placeholder="New Password"
          bind:value={newPassword}
          class="w-full p-4 rounded-lg border border-gray-300 text-gray-900 bg-white focus:outline-none focus:border-gray-500"
          required
        />
        <input
          type="password"
          placeholder="Confirm Password"
          bind:value={confirmPassword}
          class="w-full p-4 rounded-lg border border-gray-300 text-gray-900 bg-white focus:outline-none focus:border-gray-500"
          required
        />
  
        <button
          on:click={resetPassword}
          class="w-full py-4 bg-red-600 text-white font-bold rounded-lg shadow-lg hover:bg-red-700"
          disabled={loading}
        >
          {#if loading}
            <span>Resetting...</span>
          {:else}
            Reset Password
          {/if}
        </button>
      </div>
      
      <p class="mt-6 text-center text-gray-500">
        <a href="/" class="text-red-600 hover:underline">Back to Login</a>
      </p>
    </div>
  </div>
  