<script>
  import SignupForm from '../components/SignupForm.svelte';
  import { push } from 'svelte-spa-router';

  let loading = false;
  let errorMessage = "";

  async function handleSignUp({ name, lastName, username, email, password }) {
    try {
      loading = true;
      
      const response = await fetch('https://localhost:8080/signup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, lastName, username, email, password })
      });

      const data = await response.json();

      if (response.ok) {
        push('/');  // Redirect to home after successful signup
      } else {
        errorMessage = data.message || "Signup failed. Please try again.";
      }
    } catch (error) {
      errorMessage = "An error occurred during signup. Please try again later.";
    } finally {
      loading = false;
    }
  }
</script>

<div class="flex items-center justify-center w-screen min-h-screen bg-cover bg-center bg-no-repeat relative bg-[url('../pwr4.JPG')]">
  <div class="absolute inset-0 bg-gradient-to-r from-black via-transparent to-black opacity-50"></div>

  <!-- Main container for the form with scale applied for 75% zoom-out effect -->
  <div class="relative z-10 w-full max-w-lg p-10 bg-white bg-opacity-90 rounded-lg shadow-lg transform scale-75 origin-center">
    <SignupForm on:signUp={handleSignUp} {loading} />

    {#if errorMessage}
      <p class="text-red-500 mt-2">{errorMessage}</p>
    {/if}
  </div>
</div>

