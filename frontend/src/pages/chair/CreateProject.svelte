<!-- <script>
    import { onMount } from 'svelte';
    import { push } from 'svelte-spa-router';
  
    let projectName = ''; 
    let selectedEdition = ''; 
    let editions = []; 
    let errorMessage = ''; 
    let isSubmitting = false; 
  

    onMount(async () => {
      try {
        const response = await fetch('http://192.168.0.102:8080/zpi/editions/listAll');
        if (response.ok) {
          editions = await response.json();
          console.log("Editions data fetched:", editions); 
        } else {
          errorMessage = 'Failed to load editions.';
        }
      } catch (error) {
        console.error('Error fetching editions:', error);
        errorMessage = 'An error occurred while loading editions.';
      }
    });

    async function createProject() {
      console.log('Attempting to create project...'); 
      console.log('Project Name:', projectName); 
      console.log('Selected Edition:', selectedEdition); 
  
    
      if (!projectName || !selectedEdition) {
        errorMessage = 'Please enter a project name and select an edition.';
        return;
      }
  
      isSubmitting = true;
      errorMessage = '';
  
      try {
        const response = await fetch(
          `http://192.168.0.102:8080/zpi/project/create?title=${encodeURIComponent(projectName)}&editionId=${selectedEdition}`,
          {
            method: 'POST',
          }
        );
  
        if (response.ok) {
          console.log('Project created successfully!'); 
          push('/dashboard'); 
        } else {
          errorMessage = 'Failed to create project. Please try again.';
        }
      } catch (error) {
        console.error('Error creating project:', error);
        errorMessage = 'An error occurred during project creation.';
      } finally {
        isSubmitting = false;
      }
    }
  </script>
  

  <div class="container mx-auto pt-32 px-4 sm:px-0 flex justify-center items-center min-h-screen">
    <div class="bg-white p-8 rounded-lg shadow-lg max-w-lg w-full sm:w-3/4 lg:w-1/2">
      <h2 class="text-2xl font-bold text-[#2C3E50] mb-6 text-center">Create a New Project</h2>
  
      {#if errorMessage}
        <p class="text-red-600 mb-4 text-center">{errorMessage}</p>
      {/if}
  
      <div class="space-y-4">
     
        <input
          type="text"
          placeholder="Project Name"
          bind:value={projectName}
          class="w-full p-3 rounded-lg border border-gray-300 text-gray-800 bg-white focus:outline-none focus:border-[#2C3E50]"
        />
  
     
        <select
          bind:value={selectedEdition}
          class="w-full p-3 rounded-lg border border-gray-300 text-gray-800 bg-white focus:outline-none focus:border-[#2C3E50]"
        >
          <option value="" disabled selected>Select Edition</option>
          {#each editions as edition}
            <option value={edition.editionId}>{edition.name}</option>
          {/each}
        </select>
  
 
        <button
          on:click={createProject}
          class="w-full p-3 rounded-lg bg-[#E74C3C] text-white font-semibold hover:bg-[#C0392B] transition duration-300"
          disabled={isSubmitting}
        >
          {#if isSubmitting}
            Creating Project...
          {:else}
            Create Project
          {/if}
        </button>
      </div>
    </div>
  </div>
  
  <style>
   
    .container {
      max-width: 100%;
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
   -->

   
   <script>
    import { onMount } from 'svelte';
    import { push } from 'svelte-spa-router';
    import { currentProjectId } from '../../projectStore'; // Import from projectStore.js
  
    let projectName = '';
    let selectedEdition = '';
    let editions = [];
    let errorMessage = '';
    let isSubmitting = false;
  
    // Fetch list of editions on mount
    onMount(async () => {
      try {
        const response = await fetch('http://192.168.0.102:8080/zpi/editions/listAll');
        if (response.ok) {
          editions = await response.json();
        } else {
          errorMessage = 'Failed to load editions.';
        }
      } catch (error) {
        console.error('Error fetching editions:', error);
        errorMessage = 'An error occurred while loading editions.';
      }
    });
  
    async function createProject() {
  if (!projectName || !selectedEdition) {
    errorMessage = 'Please enter a project name and select an edition.';
    return;
  }

  isSubmitting = true;
  errorMessage = '';

  try {
    const response = await fetch(
      `http://192.168.0.102:8080/zpi/project/create?title=${encodeURIComponent(projectName)}&editionId=${selectedEdition}`,
      { method: 'POST' }
    );

    if (response.ok) {
      const contentType = response.headers.get('content-type');
      
      if (contentType && contentType.includes('application/json')) {
        // Parse JSON response
        const data = await response.json();
        currentProjectId.set(data.projectId); // Save projectId in the store
        push('/my-projects/constant'); // Redirect after creation
      } else if (contentType && contentType.includes('text/plain')) {
        // Handle plain text response
        const text = await response.text();
        console.log('Plain text response:', text);
        if (text.includes("Project created successfully")) {
          // Mock projectId setting for testing
          currentProjectId.set(25); // Set a mock project ID or adjust as needed
          push('/my-projects/constant'); // Redirect after creation
        } else {
          errorMessage = 'Unexpected response from server: ' + text;
        }
      } else {
        errorMessage = 'Unexpected content type from server.';
      }
    } else {
      errorMessage = 'Failed to create project. Please try again.';
    }
  } catch (error) {
    console.error('Error creating project:', error);
    errorMessage = 'An error occurred during project creation.';
  } finally {
    isSubmitting = false;
  }
}


  </script>
  
  <!-- UI layout for CreateProject -->
  <div class="container mx-auto pt-32 px-4 sm:px-0 flex justify-center items-center min-h-screen">
    <div class="bg-white p-8 rounded-lg shadow-lg max-w-lg w-full sm:w-3/4 lg:w-1/2">
      <h2 class="text-2xl font-bold text-[#2C3E50] mb-6 text-center">Create a New Project</h2>
  
      {#if errorMessage}
        <p class="text-red-600 mb-4 text-center">{errorMessage}</p>
      {/if}
  
      <div class="space-y-4">
        <input
          type="text"
          placeholder="Project Name"
          bind:value={projectName}
          class="w-full p-3 rounded-lg border border-gray-300 text-gray-800 bg-white focus:outline-none focus:border-[#2C3E50]"
        />
  
        <select
          bind:value={selectedEdition}
          class="w-full p-3 rounded-lg border border-gray-300 text-gray-800 bg-white focus:outline-none focus:border-[#2C3E50]"
        >
          <option value="" disabled selected>Select Edition</option>
          {#each editions as edition}
            <option value={edition.editionId}>{edition.name}</option>
          {/each}
        </select>
  
        <button
          on:click={createProject}
          class="w-full p-3 rounded-lg bg-[#E74C3C] text-white font-semibold hover:bg-[#C0392B] transition duration-300"
          disabled={isSubmitting}
        >
          {#if isSubmitting}
            Creating Project...
          {:else}
            Create Project
          {/if}
        </button>
      </div>
    </div>
  </div>
  
  <style>
    .container {
      max-width: 100%;
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
  