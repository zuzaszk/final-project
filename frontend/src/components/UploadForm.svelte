<script>
  let projectName = '';
  let description = '';
  let year = '';
  let language = '';
  let posterFile = null;
  let projectFile = null;

  function handlePosterUpload(event) {
    posterFile = event.target.files[0];
  }

  function handleProjectFileUpload(event) {
    projectFile = event.target.files[0];
  }

  function submitForm() {
    console.log({ projectName, description, year, language, posterFile, projectFile });
  }
</script>

<div class="max-w-5xl mx-auto bg-white p-8 md:p-10 rounded-lg shadow-md"> 
  <h2 class="text-2xl md:text-3xl font-bold text-gray-800 mb-6 text-center">Upload Your Final Project</h2>

  <div class="mb-6">
    <label for="projectName" class="block text-lg text-gray-800 mb-2">Project Name</label>
    <input
      id="projectName"
      type="text"
      bind:value={projectName}
      class="w-full p-3 border border-gray-300 rounded-lg bg-white text-gray-800" 
      placeholder="Enter your project name"
    />
  </div>

  <div class="mb-6">
    <label for="description" class="block text-lg text-gray-800 mb-2">Project Description</label>
    <textarea
      id="description"
      bind:value={description}
      rows="5"
      class="w-full p-3 border border-gray-300 rounded-lg bg-white text-gray-800" 
      placeholder="Describe your project"
    ></textarea>
  </div>

  <div class="mb-6 grid grid-cols-1 md:grid-cols-2 gap-6">
    <div>
      <label for="year" class="block text-lg text-gray-800 mb-2">Year</label>
      <select
        id="year"
        bind:value={year}
        class="w-full p-3 border border-gray-300 rounded-lg bg-white text-gray-800" 
      >
        <option value="">Select Year</option>
        <option value="2025">2025</option>
        <option value="2024">2024</option>
        <option value="2023">2023</option>
        <option value="2022">2022</option>
      </select>
    </div>

    <div>
      <label for="language" class="block text-lg text-gray-800 mb-2">Language</label>
      <select
        id="language"
        bind:value={language}
        class="w-full p-3 border border-gray-300 rounded-lg bg-white text-gray-800"
      >
        <option value="">Select Language</option>
        <option value="EN">English</option>
        <option value="PL">Polish</option>
      </select>
    </div>
  </div>

  <div class="mb-6 bg-[#ECF0F1] p-6 rounded-lg border-2 border-dashed border-gray-400 text-center cursor-pointer">
    <label for="poster" class="block text-lg text-gray-600">Click to Upload Project Poster</label>
    <input
      id="poster"
      type="file"
      accept="image/*"
      on:change={handlePosterUpload}
      class="hidden"
    />
  </div>

  <div class="mb-6">
    <label for="projectFile" class="block text-lg text-gray-800 mb-2">Upload Project Files</label>
    <input
      id="projectFile"
      type="file"
      accept=".pdf,.zip"
      on:change={handleProjectFileUpload}
      class="w-full p-3 border border-gray-300 rounded-lg bg-white text-gray-800"  
    />
  </div>

  <button
    on:click={submitForm}
    class="w-full bg-[#E74C3C] text-white font-bold py-3 px-4 rounded-lg hover:bg-[#C0392B] transition-all duration-300"
  >
    Submit Project
  </button>
</div>

<style>
  .container {
    padding-top: 100px; 
  }

  /* Additional responsiveness tweaks */
  @media (max-width: 768px) {
    /* Ensure form fields take full width on smaller screens */
    .form-container {
      padding: 0 1rem;
    }
  }
</style>
