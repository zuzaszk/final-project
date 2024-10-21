<script>
    export let handleUsosLogin;
  </script>
  
  <div class="w-full sm:w-1/2 p-12 bg-gray-100 text-center flex flex-col justify-center items-center">
    <img src="/logo.jpg" alt="PWR Logo" class="mx-auto mb-6 w-24 h-24" />
    <h2 class="text-3xl font-bold text-indigo-900 mb-6">Login with USOS</h2>
    <p class="text-gray-600 text-lg mb-6">For PWR students and staff</p>
    <button on:click={handleUsosLogin} class="w-full py-3 bg-red-600 text-white text-lg rounded-lg shadow-lg hover:bg-red-700 hover:scale-105 transform transition-all duration-300">
      USOS/AD Users
    </button>
    <p class="mt-4 text-sm text-gray-500">Politechnika Wrocławska | 2024</p>
  </div>
  