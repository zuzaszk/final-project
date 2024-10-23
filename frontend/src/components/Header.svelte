<script>

</script>

<header class="bg-[#2c3e50] py-4 w-full fixed top-0">
  <div class="container flex justify-between items-center px-4">
    
    <div class="flex items-center">
      <img src="/logo.jpg" alt="Logo" class="h-10" />
    </div>

    
<nav class="ml-auto space-x-6">
  <a href="#/dashboard" class="text-white font-semibold hover:bg-[#E74C3C] hover:text-white px-4 py-2 rounded transition-all duration-300">Dashboard</a>
  <a href="#/projects" class="text-white font-semibold hover:bg-[#E74C3C] hover:text-white px-4 py-2 rounded transition-all duration-300">Projects</a>
  <a href="#/upload" class="text-white font-semibold hover:bg-[#E74C3C] hover:text-white px-4 py-2 rounded transition-all duration-300">Upload</a>
  <a href="#/settings" class="text-white font-semibold hover:bg-[#E74C3C] hover:text-white px-4 py-2 rounded transition-all duration-300">Settings</a>
  <a href="#/logout" class="text-white font-semibold hover:bg-[#E74C3C] hover:text-white px-4 py-2 rounded transition-all duration-300">Logout</a>
</nav>

  </div>
</header>

<style>
  header {
    position: fixed;
    top: 0;
    width: 100%;
    z-index: 10;
  }

  .container {
    width: 100%; 
    max-width: 1600px; 
    margin: 0 auto;
  }

  img {
    height: 40px;
    width: auto;
  }

  nav a {
    transition: background-color 0.3s ease, color 0.3s ease; 
    color: white;
  }

  nav a:hover {
    background-color: #E74C3C;
    color: white;
  }
</style>
