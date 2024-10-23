<script>
    let year = '';
    let language = '';
    let projectName = '';
  
    
    function searchProjects() {
      dispatch('search', { year, language, projectName });
    }
  
    
    import { createEventDispatcher } from 'svelte';
    const dispatch = createEventDispatcher();
  </script>
  
  
  <div class="flex items-center justify-between space-x-4 p-4 bg-white shadow-md rounded-lg">
   
    <div class="relative w-1/4">
      <select bind:value={year} class="w-full p-3 border border-gray-300 rounded-lg bg-[#F8F9F9] text-gray-700 appearance-none">
        <option value="">Select Year</option>
        <option value="2025">2025</option>
        <option value="2024">2024</option>
        <option value="2023">2023</option>
        <option value="2022">2022</option>
      </select>
      
      <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center pr-3 text-gray-400">
        ⌄
      </div>
    </div>
  
    
    <div class="relative w-1/4">
      <select bind:value={language} class="w-full p-3 border border-gray-300 rounded-lg bg-[#F8F9F9] text-gray-700 appearance-none">
        <option value="">Select Language</option>
        <option value="EN">English</option>
        <option value="PL">Polish</option>
      </select>
      
      <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center pr-3 text-gray-400">
        ⌄
      </div>
    </div>
  
   
    <input
      type="text"
      bind:value={projectName}
      class="w-1/2 p-3 border border-gray-300 rounded-lg bg-[#F8F9F9] text-gray-700"
      placeholder="Search by project name..."
    />
  
    
    <button on:click={searchProjects} class="bg-[#E74C3C] text-white p-3 rounded-lg hover:bg-[#C0392B]">
      Search
    </button>
  </div>
  