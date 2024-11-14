<script>
    import { onMount } from 'svelte';
    import { push } from 'svelte-spa-router';
  
    let evaluations = []; 
    let editions = []; 
    let selectedEditionId = ''; 
    let errorMessage = '';
    const userId = 5; 
    const roleId = 2; 
  
    
    async function fetchEvaluations() {
      try {
        const url = `http://192.168.0.102:8080/zpi/evaluations/evaluateList?userId=${userId}&roleId=${roleId}` +
                    (selectedEditionId ? `&editionId=${selectedEditionId}` : '');
        const response = await fetch(url);
        if (response.ok) {
          const data = await response.json();
          
          evaluations = data.map(project => ({
            id: project.projectId,
            title: project.title,
            teamMembers: [],
            status: project.status === 1 ? 'pending' : 'completed'
          }));
        } else {
          errorMessage = 'Failed to load assigned projects for evaluation.';
        }
      } catch (error) {
        console.error('Error fetching evaluations:', error);
        errorMessage = 'An error occurred while loading projects.';
      }
    }
  

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
  
    
    function goToEvaluationPage(projectId) {
      push(`/evaluations/${projectId}`);
    }
  </script>
  
  <div class="container mx-auto py-16 px-6 zoom-out-75">
    <h1 class="text-2xl font-semibold text-center mb-8 text-[#2C3E50]">
      Assigned Projects for Evaluation
    </h1>
  

    <div class="flex justify-center mb-8">
      <select bind:value={selectedEditionId} on:change={fetchEvaluations} class="bg-white border border-gray-300 rounded-md px-4 py-2 text-gray-700">
        <option value="" disabled selected>Select Edition</option>
        {#each editions as edition}
          <option value={edition.editionId}>{edition.name || `Edition ${edition.year} - Semester ${edition.semester}`}</option>
        {/each}
      </select>
    </div>
  
    <!-- Error Message Display -->
    {#if errorMessage}
      <div class="text-center text-red-500 mb-4">{errorMessage}</div>
    {/if}
  
    <!-- Project Cards -->
    <div class="grid grid-cols-1 md:grid-cols-2 gap-8">
      {#each evaluations as evaluation}
        <div class="bg-white p-6 rounded-lg shadow-md">
          <div class="flex justify-between items-center mb-4">
            <h2 class="text-lg font-semibold text-[#2C3E50]">{evaluation.title}</h2>
            {#if evaluation.status === 'pending'}
              <span class="bg-red-500 text-white text-sm font-semibold px-2 py-1 rounded">Pending Evaluation</span>
            {:else}
              <span class="bg-green-500 text-white text-sm font-semibold px-2 py-1 rounded">Completed</span>
            {/if}
          </div>
          <p class="text-gray-600 mb-4">
            <strong>Team Members:</strong> {evaluation.teamMembers.length > 0 ? evaluation.teamMembers.join(", ") : "No team members available"}
          </p>
          {#if evaluation.status === 'pending'}
            <button on:click={() => goToEvaluationPage(evaluation.id)} class="bg-[#E74C3C] text-white py-2 px-4 rounded-md hover:bg-red-600 font-semibold">
              Evaluate
            </button>
          {:else}
            <button class="bg-gray-300 text-gray-600 py-2 px-4 rounded-md font-semibold" disabled>Evaluated</button>
          {/if}
        </div>
      {/each}
    </div>
  </div>
  
  <style>
    .container {
      max-width: 1200px;
      padding-top: 100px;
      transform: scale(0.85); /* Scale down to 75% */
      transform-origin: center top;
    }
    
    .zoom-out-75 {
      margin-top: 50px; /* Push content down */
    }
  </style>
  