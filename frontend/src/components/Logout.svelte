<script>
    import { logout } from '../utils/auth';
  </script>
  
  <button on:click={logout} class="py-2 px-4 bg-red-600 text-white rounded-lg shadow-lg">
    Logout
  </button>
  