<script>
    import { onMount } from 'svelte';
    import { currentProjectId } from '../../projectStore';

    let projectId;
    let title = '';
    let edition = '';
    let acronym = '';
    let description = '';
    let language = 1;
    let keywords = '';
    let errorMessage = '';
    let successMessage = '';
    let teamMembers = [];

    
    $: currentProjectId.subscribe(value => {
        projectId = value;
    });


    onMount(fetchProjectDetails);

    async function fetchProjectDetails() {
        if (!projectId) {
            errorMessage = 'Project ID is missing';
            console.error(errorMessage);
            return;
        }

        try {
            const response = await fetch(`http://192.168.0.102:8080/zpi/project/basicInfo?projectId=${projectId}`);
            if (response.ok) {
                const data = await response.json();
                title = data.title || 'Untitled Project';
                edition = data.editions ? data.editions.year : 'No edition specified';
                acronym = data.acronym || '';
                description = data.description || '';
                language = data.language || 1;
                keywords = data.keywords || '';

                teamMembers = data.userRole
                    .filter(member => member.roles.roleId === 1) 
                    .map(student => ({
                        id: student.users.userId,
                        name: `${student.users.firstName} ${student.users.lastName}`
                    }));

                console.log("Fetched project data:", data);
                console.log("Team members (students):", teamMembers);
            } else {
                errorMessage = `Failed to load project data (status ${response.status})`;
                console.error(errorMessage);
            }
        } catch (error) {
            console.error('Error loading project data:', error);
            errorMessage = 'An error occurred while loading project data.';
        }
    }

    async function saveProject() {
    errorMessage = '';
    successMessage = '';

   
    const payload = {
        projectId,       
        acronym,
        description,
        language,
        keywords
    };

    console.log("Payload:", payload); 

    try {
        const response = await fetch('http://192.168.0.102:8080/zpi/project/saveBasicInfo', {
            method: 'PUT',  
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });

        if (response.ok) {
            successMessage = 'Project information saved successfully!';
            console.log(successMessage);
        } else {
            errorMessage = `Failed to save project information. Status: ${response.status}`;
            console.error(errorMessage);
        }
    } catch (error) {
        console.error('Error saving project:', error);
        errorMessage = 'An error occurred while saving project information.';
    }
}

</script>

<div class="container bg-white p-8 mt-20 rounded-lg shadow-md max-w-3xl mx-auto">
    <h1 class="text-3xl font-bold text-[#2C3E50] text-center mb-1">{title}</h1>
    <h2 class="text-lg text-gray-500 text-center mb-6">Edition: {edition}</h2>

    {#if errorMessage}
        <p class="text-red-600 text-center mb-4">{errorMessage}</p>
    {/if}
    {#if successMessage}
        <p class="text-green-600 text-center mb-4">{successMessage}</p>
    {/if}

    <div class="space-y-6">
        <div>
            <label class="block text-gray-700 font-semibold mb-2">Acronym</label>
            <input type="text" bind:value={acronym} placeholder="Enter project acronym" class="input-field" />
        </div>

        <div>
            <label class="block text-gray-700 font-semibold mb-2">Project Description</label>
            <textarea bind:value={description} placeholder="Enter project description" rows="4" class="input-field"></textarea>
        </div>

        <div>
            <label class="block text-gray-700 font-semibold mb-2">Technologies Used (Keywords)</label>
            <input type="text" bind:value={keywords} placeholder="Enter keywords (e.g., Java, Spring Boot)" class="input-field" />
        </div>

        <div class="flex space-x-6">
            <div class="flex-1">
                <label class="block text-gray-700 font-semibold mb-2">Language</label>
                <select bind:value={language} class="input-field">
                    <option value="1">English</option>
                    <option value="2">Polish</option>
                </select>
            </div>
        </div>
    </div>

    <!-- Display team members (students) -->
    <div class="mt-8">
        <h3 class="text-xl font-semibold text-[#2C3E50] mb-4">Team Members</h3>
        <ul>
            {#each teamMembers as member}
                <li class="text-gray-700 mb-2">- {member.name}</li>
            {/each}
        </ul>
    </div>

    <div class="text-center mt-8">
        <button on:click={saveProject} class="submit-button">
            Save Changes
        </button>
    </div>
</div>

<style>
    .input-field {
      width: 100%;
      padding: 0.75rem;
      border-radius: 0.375rem;
      border: 1px solid #d1d5db;
      font-size: 1rem;
      background-color: #ffffff; 
      color: #2C3E50; 
    }
    

    .input-field::placeholder {
      color: #7F8C8D; 
    }
    
    .submit-button {
      width: 100%;
      padding: 0.75rem;
      background-color: #E74C3C;
      color: #ffffff;
      border-radius: 0.375rem;
      font-weight: bold;
    }
  </style>
  
