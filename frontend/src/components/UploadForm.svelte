<script>
  import { onMount } from 'svelte';

  export let isEditMode = false;
  export let project = null;


  let projectName = 'Mock Project Name';
  let description = 'Mock project description';
  let shortDescription = 'Mock short description';
  let year = '2024';
  let language = 'EN';
  let sourceCodeFile = null;
  let reportFile = null;
  let posterFile = null;
  let testCaseFile = null;
  let posterPreviewUrl = '';

  function handleFileUpload(event, type) {
    const file = event.target.files[0];
    if (type === 'poster') {
      posterFile = file;
      posterPreviewUrl = file ? URL.createObjectURL(file) : '';
    } else if (type === 'sourceCode') {
      sourceCodeFile = file;
    } else if (type === 'report') {
      reportFile = file;
    } else if (type === 'testCase') {
      testCaseFile = file;
    }
  }

  function submitForm() {
    const formData = {
      projectName,
      description,
      shortDescription,
      year,
      language,
      sourceCodeFile: sourceCodeFile ? sourceCodeFile.name : null,
      reportFile: reportFile ? reportFile.name : null,
      posterFile: posterFile ? posterFile.name : null,
      testCaseFile: testCaseFile ? testCaseFile.name : null,
    };
    console.log("Form Data:", formData);
    alert("Mock submission successful!");
  }
</script>

<div class="min-h-screen bg-[#F7F9F9] pt-24 pb-12 flex justify-center items-center">
  <div class="container max-w-3xl bg-white p-10 md:p-12 rounded-lg shadow-md">
    <h2 class="text-3xl font-bold text-gray-800 mb-8 text-center">
      {isEditMode ? 'Edit Your Project' : 'Upload Your Final Project'}
    </h2>

 
    <h3 class="text-xl font-semibold text-gray-800 mb-4">Mandatory Information</h3>
    <div class="grid grid-cols-2 gap-6 mb-8">
      
      <div class="upload-box" on:click={() => document.getElementById('description').focus()}>
        <input id="description" type="text" bind:value={description} class="hidden" />
        <label class="upload-label"><span>📝</span> Description</label>
      </div>

      
      <div class="upload-box" on:click={() => document.getElementById('shortDescription').focus()}>
        <input id="shortDescription" type="text" bind:value={shortDescription} class="hidden" />
        <label class="upload-label"><span>🔠</span> Short Description</label>
      </div>

     
      <div class="upload-box" on:click={() => document.getElementById('sourceCode').click()}>
        <input id="sourceCode" type="file" accept=".zip,.rar" on:change={(e) => handleFileUpload(e, 'sourceCode')} class="hidden" />
        <label class="upload-label"><span>🛠️</span> Source Code</label>
      </div>

    
      <div class="upload-box" on:click={() => document.getElementById('report').click()}>
        <input id="report" type="file" accept=".pdf" on:change={(e) => handleFileUpload(e, 'report')} class="hidden" />
        <label class="upload-label"><span>📄</span> Report</label>
      </div>
    </div>


    <h3 class="text-xl font-semibold text-gray-800 mb-4">Optional Information</h3>
    <div class="grid grid-cols-2 gap-6 mb-8">
      <!-- Poster -->
      <div class="upload-box" on:click={() => document.getElementById('poster').click()}>
        <input id="poster" type="file" accept="image/*" on:change={(e) => handleFileUpload(e, 'poster')} class="hidden" />
        <label class="upload-label"><span>🖼️</span> Poster</label>
      </div>

      <!-- Test Case -->
      <div class="upload-box" on:click={() => document.getElementById('testCase').click()}>
        <input id="testCase" type="file" accept=".pdf,.zip" on:change={(e) => handleFileUpload(e, 'testCase')} class="hidden" />
        <label class="upload-label"><span>🎯</span> Test Case</label>
      </div>
    </div>

    <!-- Submit Button -->
    <div class="mt-8 text-center">
      <button
        on:click={submitForm}
        class="submit-button bg-[#E74C3C] text-white font-bold py-3 px-6 rounded-lg hover:bg-[#C0392B] transition-all duration-300"
      >
        Submit Project
      </button>
    </div>
  </div>
</div>

<style>
  .container {
    max-width: 800px;
  }
  
  .upload-box {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100px;
    border: 2px dashed #e0e0e0;
    border-radius: 8px;
    cursor: pointer;
    position: relative;
    transition: background-color 0.3s;
  }
  
  .upload-box:hover {
    background-color: #f5f5f5;
  }

  .upload-label {
    color: #333;
    font-size: 1rem;
    font-weight: 600;
    text-transform: uppercase;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 8px;
  }
  
  .upload-label span {
    font-size: 1.5rem; /* Icon size */
  }
  
  .submit-button {
    width: 100%;
  }
</style>
