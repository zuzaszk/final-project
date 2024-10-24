<script>
  export let name = "";
  export let lastName = "";
  export let username = "";
  export let email = "";
  export let password = "";
  export let loading = false;
  
  function submit() {
    const formData = { name, lastName, username, email, password };
    dispatch('signUp', formData);
  }

  import { createEventDispatcher } from 'svelte';
  const dispatch = createEventDispatcher();
</script>

<div>
  <h2 class="text-3xl font-bold mb-8 text-gray-800 text-center">Create an Account</h2>

  <div class="flex flex-col space-y-4">
    <input type="text" placeholder="First Name" bind:value={name} class="w-full p-4 rounded-lg border border-gray-300 text-gray-900 bg-white" />
    <input type="text" placeholder="Last Name" bind:value={lastName} class="w-full p-4 rounded-lg border border-gray-300 text-gray-900 bg-white" />
    <input type="text" placeholder="Username" bind:value={username} class="w-full p-4 rounded-lg border border-gray-300 text-gray-900 bg-white" />
    <input type="email" placeholder="Email" bind:value={email} class="w-full p-4 rounded-lg border border-gray-300 text-gray-900 bg-white" />
    <input type="password" placeholder="Password" bind:value={password} class="w-full p-4 rounded-lg border border-gray-300 text-gray-900 bg-white" />

    <button on:click={submit} class="w-full py-4 bg-red-600 text-white font-bold rounded-lg shadow-lg hover:bg-red-700" disabled={loading}>
      {#if loading}
        <span>Signing Up...</span>
      {:else}
        Sign Up
      {/if}
    </button>
  </div>

  <p class="mt-6 text-center text-gray-500">
    Already have an account? <a href="/" class="text-red-600 hover:underline">Log In</a>
  </p>
</div>
