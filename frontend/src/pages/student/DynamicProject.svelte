<!-- <script>
    export let onSubmit;

    import LogoModal from '../../components/uploads/LogoModal.svelte';
    import SourceCodeModal from '../../components/uploads/SourceCodeModal.svelte';
    import PremiseModal from '../../components/uploads/PremiseModal.svelte';
    import PosterModal from '../../components/uploads/PosterModal.svelte';
    import ThesisModal from '../../components/uploads/ThesisModal.svelte';
    import RoadmapModal from '../../components/uploads/RoadmapModal.svelte';
    import AbstractModal from '../../components/uploads/AbstractModal.svelte';

    let isLogoUploaded = false;
    let isSourceCodeUploaded = false;
    let isPremiseUploaded = false;
    let isPosterUploaded = false;
    let isThesisUploaded = false;
    let isRoadmapUploaded = false;
    let isAbstractUploaded = false;

    let showLogoModal = false;
    let showSourceCodeModal = false;
    let showPremiseModal = false;
    let showPosterModal = false;
    let showThesisModal = false;
    let showRoadmapModal = false;
    let showAbstractModal = false;

    function toggleUploadStatus(type) {
      if (type === 'logo') isLogoUploaded = !isLogoUploaded;
      else if (type === 'sourceCode') isSourceCodeUploaded = !isSourceCodeUploaded;
      else if (type === 'premise') isPremiseUploaded = !isPremiseUploaded;
      else if (type === 'poster') isPosterUploaded = !isPosterUploaded;
      else if (type === 'thesis') isThesisUploaded = !isThesisUploaded;
      else if (type === 'roadmap') isRoadmapUploaded = !isRoadmapUploaded;
      else if (type === 'abstract') isAbstractUploaded = !isAbstractUploaded;
    }

    function closeAllModals() {
        showLogoModal = showSourceCodeModal = showPremiseModal = showPosterModal = showThesisModal = showRoadmapModal = showAbstractModal = false;
    }
</script>

<div class="container mx-auto mt-28 bg-white p-12 rounded-lg shadow-lg text-center transform scale-85">
  <h2 class="title text-2xl font-bold text-[#2C3E50] mb-10">Upload Your Final Project</h2>

  <div class="grid grid-cols-2 gap-4 mb-12">
    <button on:click={() => showLogoModal = true} class="upload-item {isLogoUploaded ? 'status-added' : ''}">
      <img src="../../icons/logo2.png" alt="Logo Icon" class="icon" />
      <span class="{isLogoUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Logo</span>
    </button>

    <button on:click={() => showSourceCodeModal = true} class="upload-item {isSourceCodeUploaded ? 'status-added' : ''}">
      <img src="../../icons/sourceCode.png" alt="Source Code Icon" class="icon" />
      <span class="{isSourceCodeUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Source Code</span>
    </button>

    <button on:click={() => showPremiseModal = true} class="upload-item {isPremiseUploaded ? 'status-added' : ''}">
      <img src="../../icons/premise.png" alt="Premise Icon" class="icon" />
      <span class="{isPremiseUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Premise</span>
    </button>

    <button on:click={() => showPosterModal = true} class="upload-item {isPosterUploaded ? 'status-added' : ''}">
      <img src="../../icons/poster.png" alt="Poster Icon" class="icon" />
      <span class="{isPosterUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Poster</span>
    </button>

    <button on:click={() => showThesisModal = true} class="upload-item {isThesisUploaded ? 'status-added' : ''}">
      <img src="../../icons/thesis.png" alt="Thesis Icon" class="icon" />
      <span class="{isThesisUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Thesis</span>
    </button>

    <button on:click={() => showRoadmapModal = true} class="upload-item {isRoadmapUploaded ? 'status-added' : ''}">
      <img src="../../icons/roadmap.png" alt="Roadmap Icon" class="icon" />
      <span class="{isRoadmapUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Roadmap</span>
    </button>

    <button on:click={() => showAbstractModal = true} class="upload-item {isAbstractUploaded ? 'status-added' : ''}">
      <img src="../../icons/abstract.png" alt="Abstract Icon" class="icon" />
      <span class="{isAbstractUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Abstract</span>
    </button>
  </div>

  <button on:click={onSubmit} class="submit-button bg-[#E74C3C] text-white py-3 px-6 rounded-lg hover:bg-[#C0392B]">
    Submit Project
  </button>


  {#if showLogoModal}
    <LogoModal onClose={closeAllModals} onUpload={() => toggleUploadStatus('logo')} />
  {/if}
  {#if showSourceCodeModal}
    <SourceCodeModal onClose={closeAllModals} onUpload={() => toggleUploadStatus('sourceCode')} />
  {/if}
  {#if showPremiseModal}
    <PremiseModal onClose={closeAllModals} onUpload={() => toggleUploadStatus('premise')} />
  {/if}
  {#if showPosterModal}
    <PosterModal onClose={closeAllModals} onUpload={() => toggleUploadStatus('poster')} />
  {/if}
  {#if showThesisModal}
    <ThesisModal onClose={closeAllModals} onUpload={() => toggleUploadStatus('thesis')} />
  {/if}
  {#if showRoadmapModal}
    <RoadmapModal onClose={closeAllModals} onUpload={() => toggleUploadStatus('roadmap')} />
  {/if}
  {#if showAbstractModal}
    <AbstractModal onClose={closeAllModals} onUpload={() => toggleUploadStatus('abstract')} />
  {/if}
</div>

<style>
  .container {
      max-width: 75%; 
      transform: scale(0.85); 
      height: 650px;
      margin-top: 3rem; 
      padding-top: 1rem;
  }

  .title {
      padding-top: 2rem;
  }

  .upload-item {
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
      height: 80px; 
      border: 2px dashed #e74c3c;
      border-radius: 8px;
      cursor: pointer;
      transition: all 0.3s;
      padding: 8px;
  }

  .status-added {
      border-color: #2ECC71;
  }

  .icon {
      width: 20px;
      height: 20px;
      margin-bottom: 4px;
  }

  .submit-button {
      width: 100%;
      font-weight: bold;
      margin-top: 20px;
  }
</style>
 -->

 <script>
    export let onSubmit;

    import LogoModal from '../../components/uploads/LogoModal.svelte';
    import SourceCodeModal from '../../components/uploads/SourceCodeModal.svelte';
    import PremiseModal from '../../components/uploads/PremiseModal.svelte';
    import PosterModal from '../../components/uploads/PosterModal.svelte';
    import ThesisModal from '../../components/uploads/ThesisModal.svelte';
    import RoadmapModal from '../../components/uploads/RoadmapModal.svelte';
    import AbstractModal from '../../components/uploads/AbstractModal.svelte';

    let isLogoUploaded = false;
    let isSourceCodeUploaded = false;
    let isPremiseUploaded = false;
    let isPosterUploaded = false;
    let isThesisUploaded = false;
    let isRoadmapUploaded = false;
    let isAbstractUploaded = false;

    let showLogoModal = false;
    let showSourceCodeModal = false;
    let showPremiseModal = false;
    let showPosterModal = false;
    let showThesisModal = false;
    let showRoadmapModal = false;
    let showAbstractModal = false;

    function toggleUploadStatus(type) {
        if (type === 'logo') isLogoUploaded = !isLogoUploaded;
        else if (type === 'sourceCode') isSourceCodeUploaded = !isSourceCodeUploaded;
        else if (type === 'premise') isPremiseUploaded = !isPremiseUploaded;
        else if (type === 'poster') isPosterUploaded = !isPosterUploaded;
        else if (type === 'thesis') isThesisUploaded = !isThesisUploaded;
        else if (type === 'roadmap') isRoadmapUploaded = !isRoadmapUploaded;
        else if (type === 'abstract') isAbstractUploaded = !isAbstractUploaded;
    }

    function closeAllModals() {
        showLogoModal = showSourceCodeModal = showPremiseModal = showPosterModal = showThesisModal = showRoadmapModal = showAbstractModal = false;
    }
</script>

<div class="page-container">
  <div class="container mx-auto bg-white p-8 rounded-lg shadow-lg text-center">
    <h2 class="title text-2xl font-bold text-[#2C3E50] mb-8">Upload Your Final Project</h2>

    <div class="upload-grid">
      <!-- Logo Button -->
      <button on:click={() => showLogoModal = true} class="upload-item {isLogoUploaded ? 'status-added' : ''}">
        <img src="../../icons/logo2.png" alt="Logo Icon" class="icon" />
        <span class="{isLogoUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Logo</span>
      </button>

      <!-- Source Code Button -->
      <button on:click={() => showSourceCodeModal = true} class="upload-item {isSourceCodeUploaded ? 'status-added' : ''}">
        <img src="../../icons/sourceCode.png" alt="Source Code Icon" class="icon" />
        <span class="{isSourceCodeUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Source Code</span>
      </button>

      <!-- Premise Button -->
      <button on:click={() => showPremiseModal = true} class="upload-item {isPremiseUploaded ? 'status-added' : ''}">
        <img src="../../icons/premise.png" alt="Premise Icon" class="icon" />
        <span class="{isPremiseUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Premise</span>
      </button>

      <!-- Poster Button -->
      <button on:click={() => showPosterModal = true} class="upload-item {isPosterUploaded ? 'status-added' : ''}">
        <img src="../../icons/poster.png" alt="Poster Icon" class="icon" />
        <span class="{isPosterUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Poster</span>
      </button>

      <!-- Thesis Button -->
      <button on:click={() => showThesisModal = true} class="upload-item {isThesisUploaded ? 'status-added' : ''}">
        <img src="../../icons/thesis.png" alt="Thesis Icon" class="icon" />
        <span class="{isThesisUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Thesis</span>
      </button>

      <!-- Roadmap Button -->
      <button on:click={() => showRoadmapModal = true} class="upload-item {isRoadmapUploaded ? 'status-added' : ''}">
        <img src="../../icons/roadmap.png" alt="Roadmap Icon" class="icon" />
        <span class="{isRoadmapUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Roadmap</span>
      </button>

      <!-- Abstract Button -->
      <button on:click={() => showAbstractModal = true} class="upload-item {isAbstractUploaded ? 'status-added' : ''}">
        <img src="../../icons/abstract.png" alt="Abstract Icon" class="icon" />
        <span class="{isAbstractUploaded ? 'text-[#2ECC71]' : 'text-[#E74C3C]'} font-semibold">Abstract</span>
      </button>
    </div>

    <!-- Submit Button -->
    <button on:click={onSubmit} class="submit-button bg-[#E74C3C] text-white py-3 px-6 rounded-lg hover:bg-[#C0392B]">
      Submit Project
    </button>

    <!-- Modals for Each Item -->
    {#if showLogoModal}
      <LogoModal 
        on:close={() => showLogoModal = false} 
        on:upload={() => { 
          toggleUploadStatus('logo'); 
          showLogoModal = false;
        }} 
      />
    {/if}

    {#if showSourceCodeModal}
      <SourceCodeModal 
        on:close={() => showSourceCodeModal = false} 
        on:upload={() => { 
          toggleUploadStatus('sourceCode'); 
          showSourceCodeModal = false;
        }} 
      />
    {/if}

    {#if showPremiseModal}
      <PremiseModal 
        on:close={() => showPremiseModal = false} 
        on:upload={() => { 
          toggleUploadStatus('premise'); 
          showPremiseModal = false;
        }} 
      />
    {/if}

    {#if showPosterModal}
      <PosterModal 
        on:close={() => showPosterModal = false} 
        on:upload={() => { 
          toggleUploadStatus('poster'); 
          showPosterModal = false;
        }} 
      />
    {/if}

    {#if showThesisModal}
      <ThesisModal 
        on:close={() => showThesisModal = false} 
        on:upload={() => { 
          toggleUploadStatus('thesis'); 
          showThesisModal = false;
        }} 
      />
    {/if}

    {#if showRoadmapModal}
      <RoadmapModal 
        on:close={() => showRoadmapModal = false} 
        on:upload={() => { 
          toggleUploadStatus('roadmap'); 
          showRoadmapModal = false;
        }} 
      />
    {/if}

    {#if showAbstractModal}
      <AbstractModal 
        on:close={() => showAbstractModal = false} 
        on:upload={() => { 
          toggleUploadStatus('abstract'); 
          showAbstractModal = false;
        }} 
      />
    {/if}
  </div>
</div>

<style>
  .page-container {
      display: flex;
      flex-direction: column;
      justify-content: center;
      min-height: 100vh;
      padding-bottom: 2rem;
  }

  .container {
      max-width: 90%; 
      padding: 1.5rem;
      margin: auto;
      transform: scale(0.9);  
  }

  .upload-grid {
      display: grid;
      gap: 1rem;
      grid-template-columns: 1fr 1fr;
  }

  .upload-item {
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
      height: 100px; 
      border: 2px dashed #e74c3c;
      border-radius: 8px;
      cursor: pointer;
      transition: all 0.3s;
      padding: 8px;
  }

  .status-added {
      border-color: #2ECC71;
  }

  .icon {
      width: 24px;
      height: 24px;
      margin-bottom: 4px;
  }

  .submit-button {
      width: 100%;
      font-weight: bold;
      margin-top: 16px;
  }

  @media (min-width: 768px) {
    .container {
      max-width: 60%;
      padding: 2rem;
    }

    .upload-grid {
      grid-template-columns: 1fr 1fr 1fr;
    }
  }
</style>

 