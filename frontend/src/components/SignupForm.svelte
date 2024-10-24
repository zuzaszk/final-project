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
  
  <div class="relative z-10 w-full max-w-sm p-5 bg-white bg-opacity-90 rounded-lg shadow-lg mx-auto">
    <h2 class="text-xl font-bold mb-4 text-gray-800 text-center">Create an Account</h2>
    <div class="flex flex-col space-y-3">
      <input type="text" placeholder="First Name" bind:value={name} class="w-full p-2 rounded-lg border text-sm bg-white text-black" />
<input type="text" placeholder="Last Name" bind:value={lastName} class="w-full p-2 rounded-lg border text-sm bg-white text-black" />
<input type="text" placeholder="Username" bind:value={username} class="w-full p-2 rounded-lg border text-sm bg-white text-black" />
<input type="email" placeholder="Email" bind:value={email} class="w-full p-2 rounded-lg border text-sm bg-white text-black" />
<input type="password" placeholder="Password" bind:value={password} class="w-full p-2 rounded-lg border text-sm bg-white text-black" />

      <button on:click={submit} class="w-full py-2 bg-red-600 text-white font-bold rounded-lg text-sm" disabled={loading}>
        {#if loading}
          <span>Signing Up...</span>
        {:else}
          Sign Up
        {/if}
      </button>
    </div>
    <p class="mt-4 text-center text-gray-500 text-xs">
      Already have an account? <a href="/" class="text-red-600 hover:underline">Log In</a>
    </p>
  </div>
  
  <style>
    @media (max-width: 768px) {
      div {
        padding: 1rem;
      }
  
      input, button {
        font-size: 0.75rem;
      }
  
      h2 {
        font-size: 1.5rem;
      }
    }
  </style>
  