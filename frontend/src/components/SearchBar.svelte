<!-- <script>
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
</style> -->
<script>
  export let year;
  export let language;
  export let title;
  export let handleSearch;
</script>

<div class="search-bar flex items-center space-x-2 mb-6"> 
  <div class="dropdown-container">
    <select bind:value={year} class="dropdown">
      <option value="">Select Year</option>
      <option value="2025">2025</option>
      <option value="2024">2024</option>
      <option value="2023">2023</option>
      <option value="2022">2022</option>
    </select>

    <select bind:value={language} class="dropdown">
      <option value="">Select Language</option>
      <option value="EN">English</option>
      <option value="PL">Polish</option>
    </select>
  </div>

  <input
    bind:value={title}
    type="text"
    class="search-input"
    placeholder="Search by project name..."
  />

  <button on:click={handleSearch} class="search-button">
    Search
  </button>
</div>

<style>
  /* Styling for dropdowns and input fields */
  .dropdown, .search-input {
    padding: 0.5rem;
    border: 1px solid #BDC3C7;
    border-radius: 8px;
    font-size: 0.875rem;
    color: #000;
    background-color: transparent;
  }

  .search-button {
    background-color: #E74C3C;
    color: #fff;
    padding: 0.5rem 1.25rem;
    border-radius: 8px;
    font-size: 0.875rem;
    cursor: pointer;
    transition: background-color 0.3s;
  }

  .search-button:hover {
    background-color: #C0392B;
  }

  /* Container for dropdowns on small screens */
  .dropdown-container {
    display: flex;
    gap: 0.5rem;
  }

  /* Responsive adjustments */
  @media (max-width: 768px) {
    /* Stack elements on very small screens */
    .search-bar {
      flex-direction: column;
      gap: 0.5rem;
    }

    .dropdown-container {
      display: flex;
      flex-direction: row;
      gap: 0.5rem;
    }

    .dropdown, .search-input, .search-button {
      width: 90%; /* Full width on mobile */
    }
  }
</style>
