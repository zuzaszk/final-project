<script>
  export let loginWithGoogle;
  export let loginWithFacebook;
</script>

<div class="flex flex-col space-y-4 w-full">
  <button on:click={loginWithGoogle} class="w-full py-3 bg-white text-gray-900 border border-gray-300 rounded-lg shadow-lg hover:bg-gray-100 transition-all duration-300 flex justify-center items-center">
    <img src="/google.png" class="w-5 h-5 mr-2" alt="Google Icon" />
    Login with Google
  </button>

  <button on:click={loginWithFacebook} class="w-full py-3 bg-blue-600 text-white rounded-lg shadow-lg hover:bg-blue-700 transition-all duration-300">
    Login with Facebook
  </button>
</div>
