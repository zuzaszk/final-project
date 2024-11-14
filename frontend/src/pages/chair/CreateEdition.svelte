<script>
    import { onMount } from 'svelte';
    import { push } from 'svelte-spa-router';
  
    let editionName = '';  
    let year = '';         
    let semester = '';     
    let isActive = false;  
    let errorMessage = ''; 
    let isSubmitting = false; 
  
    async function createEdition() {
      console.log('Attempting to create edition...'); 
      console.log('Edition Name:', editionName); 
      console.log('Year:', year); 
      console.log('Semester:', semester); 
      console.log('Is Active:', isActive); 
  
      
      if (!editionName || !year || !semester) {
        errorMessage = 'Please fill in all the fields.';
        return;
      }
  
      isSubmitting = true;
      errorMessage = '';
  
      try {
        const response = await fetch(
          `http://192.168.0.102:8080/zpi/edition/create`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
              name: editionName,
              year: parseInt(year),
              semester: parseInt(semester),
              isActive: isActive
            })
          }
        );
  
        if (response.ok) {
          console.log('Edition created successfully!'); 
          push('/dashboard'); 
        } else {
          errorMessage = 'Failed to create edition. Please try again.';
        }
      } catch (error) {
        console.error('Error creating edition:', error);
        errorMessage = 'An error occurred during edition creation.';
      } finally {
        isSubmitting = false;
      }
    }
  </script>
  
  <div class="container mx-auto pt-32 px-4 sm:px-0 flex justify-center items-center min-h-screen">
    <div class="bg-white p-8 rounded-lg shadow-lg max-w-lg w-full sm:w-3/4 lg:w-1/2">
      <h2 class="text-2xl font-bold text-[#2C3E50] mb-6 text-center">Create a New Edition</h2>
  
      {#if errorMessage}
        <p class="text-red-600 mb-4 text-center">{errorMessage}</p>
      {/if}
  
      <div class="space-y-4">
        <!-- Edition Name Input -->
        <input
          type="text"
          placeholder="Edition Name"
          bind:value={editionName}
          class="w-full p-3 rounded-lg border border-gray-300 text-gray-800 bg-white focus:outline-none focus:border-[#2C3E50]"
        />
  
        <!-- Year Input -->
        <input
          type="number"
          placeholder="Year"
          bind:value={year}
          class="w-full p-3 rounded-lg border border-gray-300 text-gray-800 bg-white focus:outline-none focus:border-[#2C3E50]"
        />
  
        <!-- Semester Dropdown -->
        <select
          bind:value={semester}
          class="w-full p-3 rounded-lg border border-gray-300 text-gray-800 bg-white focus:outline-none focus:border-[#2C3E50]"
        >
          <option value="" disabled selected>Select Semester</option>
          <option value="1">Fall</option>
          <option value="2">Spring</option>
        </select>
  
        <!-- Active Checkbox -->
        <label class="flex items-center space-x-3">
          <input
            type="checkbox"
            bind:checked={isActive}
            class="rounded text-[#E74C3C] focus:ring-[#E74C3C]"
          />
          <span class="text-gray-800">Is Active</span>
        </label>
  
        <!-- Create Edition Button -->
        <button
          on:click={createEdition}
          class="w-full p-3 rounded-lg bg-[#E74C3C] text-white font-semibold hover:bg-[#C0392B] transition duration-300"
          disabled={isSubmitting}
        >
          {#if isSubmitting}
            Creating Edition...
          {:else}
            Create Edition
          {/if}
        </button>
      </div>
    </div>
  </div>
  
  <style>
    .container{
        transform: scale(0.9);  
    }
    .bg-white {
      background-color: #ffffff;
    }
  
    .rounded-lg {
      border-radius: 0.5rem;
    }
  
    .shadow-lg {
      box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
    }
  
    .text-gray-800 {
      color: #4A4A4A;
    }
  
    .text-red-600 {
      color: #E74C3C;
    }
  
    .border-gray-300 {
      border-color: #d1d5db;
    }
  
    @media (max-width: 640px) {
      .container {
        padding: 2rem;
      }
    }
  </style>
  