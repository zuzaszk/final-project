<script>
  import SignupForm from '../components/SignupForm.svelte';
  let loading = false;
  let errorMessage = "";

  async function handleSignUp({ name, lastName, username, email, password }) {
    try {
      loading = true;
      
      const response = await fetch('https://api.example.com/signup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, lastName, username, email, password })
      });

      const data = await response.json();

      if (response.ok) {
        
        push('/');
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

  <div class="relative z-10 w-full max-w-lg p-10 bg-white bg-opacity-90 rounded-lg shadow-lg">
    <SignupForm on:signUp={handleSignUp} {loading} />

    {#if errorMessage}
      <p class="text-red-500 mt-2">{errorMessage}</p>
    {/if}
  </div>
</div>
