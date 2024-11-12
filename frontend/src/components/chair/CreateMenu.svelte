<script>
    import { createEventDispatcher } from 'svelte';
    const dispatch = createEventDispatcher();
  
    let showDropdown = false;
  
    function toggleDropdown() {
      showDropdown = !showDropdown;
    }
  </script>
  
  <div class="relative">
    <button on:click={toggleDropdown} class="text-white hover:bg-[#E74C3C] px-3 py-2 rounded flex items-center">
      Create
      <span class="ml-1">▼</span>
    </button>
  
    {#if showDropdown}
      <div class="absolute bg-white shadow-lg rounded-lg mt-2 w-40">
        <a href="#/create-project" class="block px-4 py-2 text-gray-700 hover:bg-gray-200">Project</a>
        <a href="#/create-edition" class="block px-4 py-2 text-gray-700 hover:bg-gray-200">Edition</a>
      </div>
    {/if}
  </div>
  
  <style>
    .relative { position: relative; }
    .absolute { position: absolute; }
  </style>
  