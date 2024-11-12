<script>
  import { onMount } from 'svelte';
  import DescriptionModal from '../components/uploads/DescriptionModal.svelte';
  import SourceCodeModal from '../components/uploads/SourceCodeModal.svelte';
  import ReportModal from '../components/uploads/ReportModal.svelte';
  import PosterModal from '../components/uploads/PosterModal.svelte';
  import TestCaseModal from '../components/uploads/TestCaseModal.svelte';


  let showDescriptionModal = false;
  let showSourceCodeModal = false;
  let showReportModal = false;
  let showPosterModal = false;
  let showTestCaseModal = false;


  let isDescriptionAdded = true;
  let isSourceCodeAdded = false;
  let isReportAdded = false;
  let isPosterAdded = false;
  let isTestCaseAdded = false;


  function openModal(modal) {
    closeModal(); 
    if (modal === 'description') showDescriptionModal = true;
    else if (modal === 'sourceCode') showSourceCodeModal = true;
    else if (modal === 'report') showReportModal = true;
    else if (modal === 'poster') showPosterModal = true;
    else if (modal === 'testCase') showTestCaseModal = true;
  }


  function closeModal() {
    showDescriptionModal = showSourceCodeModal = showReportModal = showPosterModal = showTestCaseModal = false;
  }

  function markAsAdded(field) {
    if (field === 'description') isDescriptionAdded = true;
    else if (field === 'sourceCode') isSourceCodeAdded = true;
    else if (field === 'report') isReportAdded = true;
    else if (field === 'poster') isPosterAdded = true;
    else if (field === 'testCase') isTestCaseAdded = true;
  }
</script>

<div class="upload-container min-h-screen bg-[#F7F9F9] pt-24 pb-12 flex justify-center items-center">
  <div class="container max-w-4xl bg-white p-10 md:p-12 rounded-lg shadow-md">
    <h2 class="text-3xl font-bold text-gray-800 mb-8 text-center">Upload Your Final Project</h2>

    <h3 class="text-xl font-semibold text-gray-800 mb-4">Mandatory Information</h3>
    <div class="grid grid-cols-1 md:grid-cols-2 gap-6 mb-8">
      <button on:click={() => openModal('description')} class="upload-button {isDescriptionAdded ? 'status-added' : ''}">
        <span class="icon">📝</span> Description
      </button>
      <button on:click={() => openModal('sourceCode')} class="upload-button {isSourceCodeAdded ? 'status-added' : ''}">
        <span class="icon">💻</span> Source Code
      </button>
      <button on:click={() => openModal('report')} class="upload-button {isReportAdded ? 'status-added' : ''}">
        <span class="icon">📄</span> Report
      </button>
    </div>

    
    <h3 class="text-xl font-semibold text-gray-800 mb-4">Optional Information</h3>
    <div class="grid grid-cols-1 md:grid-cols-2 gap-6 mb-8">
      <button on:click={() => openModal('poster')} class="upload-button {isPosterAdded ? 'status-added' : ''}">
        <span class="icon">🖼️</span> Poster
      </button>
      <button on:click={() => openModal('testCase')} class="upload-button {isTestCaseAdded ? 'status-added' : ''}">
        <span class="icon">🧪</span> Test Case
      </button>
    </div>

    
    <div class="text-center mt-8">
      <button class="submit-button bg-[#E74C3C] text-white font-bold py-3 px-6 rounded-lg hover:bg-[#C0392B]">
        Submit Project
      </button>
    </div>
  </div>

  <!-- Modals -->
  {#if showDescriptionModal}
    <DescriptionModal on:close={closeModal} on:added={() => markAsAdded('description')} />
  {/if}
  {#if showSourceCodeModal}
    <SourceCodeModal on:close={closeModal} on:added={() => markAsAdded('sourceCode')} />
  {/if}
  {#if showReportModal}
    <ReportModal on:close={closeModal} on:added={() => markAsAdded('report')} />
  {/if}
  {#if showPosterModal}
    <PosterModal on:close={closeModal} on:added={() => markAsAdded('poster')} />
  {/if}
  {#if showTestCaseModal}
    <TestCaseModal on:close={closeModal} on:added={() => markAsAdded('testCase')} />
  {/if}
</div>

<style>
  .upload-container .upload-button {
    
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100px;
    border: 2px dashed #e74c3c;
    border-radius: 8px;
    cursor: pointer;
    font-weight: 600;
    color: #e74c3c;
    transition: all 0.3s;
  }

  .upload-button .icon {
    margin-right: 10px;
  }

  
  .status-added {
    border-color: #28a745;
    color: #28a745;
  }

  .submit-button {
    width: 100%;
  }

  .container {
    transform: scale(0.85);  
    max-width: 1100px;
    /* max-height: 2000vh; */
  }
</style>
