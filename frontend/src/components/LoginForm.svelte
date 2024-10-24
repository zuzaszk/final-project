<script>
    export let loginWithEmail;
    export let email;
    export let password;
    export let loading = false; 
  </script>
  
  
  <form on:submit|preventDefault={loginWithEmail} class="mt-4 w-full max-w-sm mx-auto">
    <input
      type="email"
      placeholder="Email"
      bind:value={email}
      class="w-full mb-2 p-2 rounded-lg border bg-gray-800 text-white placeholder-white text-sm"
      required
    />
    <input
      type="password"
      placeholder="Password"
      bind:value={password}
      class="w-full mb-2 p-2 rounded-lg border bg-gray-800 text-white placeholder-white text-sm"
      required
    />
    <button
      type="submit"
      class="w-full py-2 bg-gray-600 text-white rounded-lg shadow-md hover:bg-gray-700 transition-all duration-300 text-sm"
      disabled={loading}
    >
      {#if loading}
        <span>Loading...</span>
      {:else}
        Login with Email
      {/if}
    </button>
  </form>
  
  <style>
    @media (max-width: 768px) {
      form {
        padding: 0.5rem;
      }
  
      input, button {
        font-size: 0.75rem; /* Smaller font for compact view */
      }
    }
  </style>
  