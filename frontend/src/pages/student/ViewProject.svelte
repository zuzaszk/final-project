<script>
    export let project = {};
    export let onEdit;
  </script>
  
  <div class="container mx-auto mt-10 bg-white p-8 rounded-lg shadow-lg">
    <h1 class="text-3xl font-bold mb-4">{project.title} ({project.edition})</h1>
  
    <h2 class="text-xl font-semibold mb-2">Project Description</h2>
    <p class="text-gray-700">{project.description}</p>
  
    <h3 class="text-xl font-semibold mt-6">Technologies Used</h3>
    <p class="text-gray-700">{project.technologies}</p>
  
    <div class="flex space-x-4 mt-6">
      <div>
        <h3 class="text-lg font-semibold">Language</h3>
        <p class="text-gray-700">{project.language}</p>
      </div>
      <div>
        <h3 class="text-lg font-semibold">Year</h3>
        <p class="text-gray-700">{project.year}</p>
      </div>
    </div>
  
    <h3 class="text-xl font-semibold mt-6">Team Members</h3>
    <div class="bg-gray-100 p-4 rounded-lg grid grid-cols-2 gap-4">
      {#each project.members as member}
        <div class="bg-white p-3 border-l-4 border-red-600 rounded-lg">{member.name}</div>
      {/each}
    </div>
  
    <button on:click={onEdit} class="mt-6 bg-blue-500 text-white p-3 rounded-lg">Edit Project</button>
  </div>
  
  <style>
    .container { max-width: 800px; }
  </style>
  