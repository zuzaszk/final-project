<script>
    export let currentPage = 1;
    export let totalPages = 1;
  
    function changePage(pageNumber) {
      dispatch('pageChange', pageNumber);  // Emit the pageChange event
    }
  
    import { createEventDispatcher } from 'svelte';
    const dispatch = createEventDispatcher();
  </script>
  
  <div class="flex justify-center space-x-4 mt-8">
    {#if currentPage > 1}
      <button class="pagination-btn" on:click={() => changePage(currentPage - 1)}>Previous</button>
    {/if}
  
    {#each Array(totalPages).fill(0).map((_, index) => index + 1) as page}
      <button
        class="pagination-btn {page === currentPage ? 'bg-[#E74C3C] text-white' : ''}"
        on:click={() => changePage(page)}
      >
        {page}
      </button>
    {/each}
  
    {#if currentPage < totalPages}
      <button class="pagination-btn" on:click={() => changePage(currentPage + 1)}>Next</button>
    {/if}
  </div>
  
  <style>
    .pagination-btn {
      padding: 10px 15px;
      border: 1px solid #BDC3C7;
      border-radius: 5px;
      background-color: white;
      color: black; 
      cursor: pointer;
      transition: background-color 0.3s ease, color 0.3s ease;
    }
  
    .pagination-btn:hover {
      background-color: #E74C3C;
      color: white;
      border: none;
    }
  </style>
  