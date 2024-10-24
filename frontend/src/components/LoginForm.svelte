<script>
    export let loginWithEmail;
    export let email;
    export let password;
    export let loading = false; 
  </script>
  
  
<form on:submit|preventDefault={loginWithEmail} class="mt-6 w-full">
    <input
      type="email"
      placeholder="Email"
      bind:value={email}
      class="w-full mb-3 p-3 rounded-lg border bg-gray-800 text-white placeholder-white"
      required
    />
    <input
      type="password"
      placeholder="Password"
      bind:value={password}
      class="w-full mb-3 p-3 rounded-lg border bg-gray-800 text-white placeholder-white"
      required
    />
    <button
      type="submit"
      class="w-full py-3 bg-gray-600 text-white rounded-lg shadow-lg hover:bg-gray-700 transition-all duration-300 flex justify-center items-center"
      disabled={loading}
    >
      {#if loading}
        <span>Loading...</span> 
      {:else}
        Login with Email
      {/if}
    </button>
  </form>