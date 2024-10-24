<script>
  export let year;
  export let language;
  export let title;
  export let handleSearch;
</script>

<div class="flex items-center space-x-2 mb-6"> 
  <select bind:value={year} class="w-40 p-2 border border-gray-300 rounded-lg text-sm text-black">
    <option value="">Select Year</option>
    <option value="2025">2025</option>
    <option value="2024">2024</option>
    <option value="2023">2023</option>
    <option value="2022">2022</option>
  </select>

  <select bind:value={language} class="w-40 p-2 border border-gray-300 rounded-lg text-sm text-black">
    <option value="">Select Language</option>
    <option value="EN">English</option>
    <option value="PL">Polish</option>
  </select>

  <input
    bind:value={title}
    type="text"
    class="w-full lg:w-80 p-2 border border-gray-300 rounded-lg text-sm text-black"
    placeholder="Search by project name..."
  />

  <button on:click={handleSearch} class="bg-[#E74C3C] text-white p-2 px-10 rounded-lg hover:bg-[#C0392B] text-sm">
    Search
  </button>
</div>

<style>
  select, input {
    background: transparent;
    border: 1px solid #BDC3C7;
  }
</style>
