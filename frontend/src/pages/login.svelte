<script>
  import { push } from 'svelte-spa-router';
  import LoginForm from '../components/LoginForm.svelte';
  import SocialLogin from '../components/SocialLogin.svelte';
  import UsosLogin from '../components/UsosLogin.svelte';

  let email = "";
  let password = "";
  let errorMessage = "";
  let loading = false;

  async function loginWithEmail() {
    try {
      loading = true;
      
      const response = await fetch('https://localhost:8080/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
      });

      const data = await response.json();

      if (response.ok) {
        
        push('/dashboard');
      } else {
        errorMessage = data.message || "Login failed. Please try again.";
      }
    } catch (error) {
      errorMessage = "An error occurred during login. Please try again later.";
    } finally {
      loading = false;
    }
  }

  function loginWithGoogle() {
    
    window.location.href = 'https://accounts.google.com/o/oauth2/v2/auth?client_id=<GOOGLE_CLIENT_ID>&redirect_uri=http://localhost:5173/google-callback&response_type=token&scope=email profile';
  }

  function loginWithFacebook() {
    
    window.location.href = 'https://www.facebook.com/v11.0/dialog/oauth?client_id=<FACEBOOK_CLIENT_ID>&redirect_uri=http://localhost:5173/facebook-callback&response_type=token&scope=email';
  }

  function handleUsosLogin() {
   
    window.location.href = 'https://login.pwr.edu.pl/auth/realms/pwr.edu.pl/protocol/cas/login?service=https%3A%2F%2Fweb.usos.pwr.edu.pl%2Fkontroler.php%3F_action%3Dlogowaniecas%2Findex&locale=en';
  }

  function redirectToSignup() {
    push('/signup');
  }

  function redirectToForgotPassword() {
    push('/forgot-password');
  }
</script>


<div class="scaleContainer flex items-center justify-center w-screen min-h-screen bg-cover bg-center bg-no-repeat relative bg-[url('../pwr4.JPG')]">
  <div class="absolute inset-0 bg-gradient-to-r from-black via-transparent to-black opacity-50"></div>

  <!-- Begin scaling here -->
  <div class="relative z-10 flex flex-col sm:flex-row w-full max-w-4xl h-auto bg-white shadow-2xl rounded-2xl overflow-hidden border border-gray-200 transform scale-75 origin-center">
    <UsosLogin {handleUsosLogin} />

    <div class="w-full sm:w-1/2 bg-gradient-to-br from-gray-800 to-gray-900 text-white p-12 flex flex-col justify-center items-center">
      <h2 class="text-3xl font-bold mb-6">Login as Guest</h2>
      <p class="text-lg mb-6">View team projects as a spectator</p>

      <SocialLogin {loginWithGoogle} {loginWithFacebook} />

      <LoginForm {loginWithEmail} bind:email bind:password {loading} />

      {#if errorMessage}
        <p class="text-red-500 mt-2">{errorMessage}</p>
      {/if}

      <div class="flex justify-between mt-4 w-full text-sm text-gray-400">
        <a on:click={redirectToForgotPassword} class="hover:underline cursor-pointer">Forgot Password?</a>
        <a on:click={redirectToSignup} class="hover:underline cursor-pointer">Sign Up</a>
      </div>
    </div>
  </div>
</div>


<style>
  .scaleContainer {
    display: flex;
    justify-content: center;
    align-items: center;
  }


  .scaleContainer .transform {
    transform: scale(0.75); 
    transform-origin: center; 
  }
</style>
