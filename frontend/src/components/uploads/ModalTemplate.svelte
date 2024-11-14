<!-- <script>
    import { createEventDispatcher } from 'svelte';
  
    export let title = 'Upload File';
    export let description = '';
    export let supportedFormats = 'zip, rar, 7z, pdf, jpg, png';
    export let softDeadline = '';
    export let hardDeadline = '';
    
    const dispatch = createEventDispatcher();
    let selectedFile = null;
    let isDragging = false;

    function closeModal() {
      dispatch('close'); 
    }

    function handleFileChange(event) {
      selectedFile = event.target.files[0];
    }

    function handleDragOver(event) {
      event.preventDefault();
      isDragging = true;
    }

    function handleDragLeave() {
      isDragging = false;
    }

    function handleDrop(event) {
      event.preventDefault();
      isDragging = false;
      if (event.dataTransfer.files.length) {
        selectedFile = event.dataTransfer.files[0];
      }
    }

    function uploadFile() {
      if (selectedFile) {
        dispatch('upload', { file: selectedFile });
      } else {
        console.warn("No file selected for upload.");
      }
    }
</script>

<div class="overlay" on:click={closeModal}>
  <div class="modal-container" on:click|stopPropagation>
    <button class="close-button" on:click={closeModal}>✕</button>

    <h2 class="title">{title}</h2>

    <div class="upload-area" 
         class:is-dragging={isDragging}
         on:dragover={handleDragOver} 
         on:dragleave={handleDragLeave} 
         on:drop={handleDrop}>
      <p>{description}</p>
      <p class="formats">Supported formats: {supportedFormats}</p>
      <input type="file" accept=".zip, .rar, .7z, .pdf, .jpg, .png" on:change={handleFileChange} class="file-input"/>
    </div>

    <div class="file-input-container">
      {#if selectedFile}
        <p class="selected-file-name">{selectedFile.name}</p>
      {:else}
        <p>No file selected</p>
      {/if}
      <button on:click={uploadFile} class="upload-button">UPLOAD FILE</button>
    </div>

    <p class="deadlines">
      <strong>Soft Deadline:</strong> {softDeadline} <br />
      <strong>Hard Deadline:</strong> {hardDeadline}
    </p>
  </div>
</div>

<style>
  .overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    align-items: center;
    justify-content: center;
    z-index: 1000;
  }

  .modal-container {
    background: #ffffff;
    padding: 2rem;
    border-radius: 8px;
    max-width: 500px;
    width: 100%;
    text-align: center;
    position: relative;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
  }

  .close-button {
    position: absolute;
    top: 1rem;
    right: 1rem;
    background: none;
    border: none;
    font-size: 1.5rem;
    cursor: pointer;
    color: #E74C3C;
  }

  .title {
    font-size: 1.5rem;
    color: #2C3E50;
    margin-bottom: 1.5rem;
  }

  .upload-area {
    margin-bottom: 1rem;
    padding: 1.5rem;
    border: 2px dashed #B3B3B3;
    border-radius: 8px;
    text-align: center;
    cursor: pointer;
    color: #333;
    transition: background-color 0.3s ease;
  }

  .upload-area.is-dragging {
    background-color: #e9f5ff;
    border-color: #007bff;
  }

  .formats {
    font-size: 0.85rem;
    color: #999;
  }

  .file-input {
    margin-top: 1rem;
  }

  .file-input-container {
    margin-top: 1rem;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .selected-file-name {
    font-size: 0.9rem;
    color: #333;
    margin-top: 0.5rem;
  }

  .upload-button {
    margin-top: 1rem;
    background-color: #E74C3C;
    color: white;
    padding: 0.5rem 1rem;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-weight: bold;
  }
</style> -->

<script>
    import { createEventDispatcher } from 'svelte';
  
    export let title = 'Upload File';
    export let description = '';
    export let supportedFormats = 'zip, rar, 7z, pdf, jpg, png';
    export let softDeadline = '';
    export let hardDeadline = '';
  
    const dispatch = createEventDispatcher();
    let selectedFile = null;
    let isDragging = false;
    let previewUrl = ''; // URL for image preview
  
    function closeModal() {
      dispatch('close'); 
    }
  
    function handleFileChange(event) {
      selectedFile = event.target.files[0];
      if (selectedFile && selectedFile.type.startsWith('image/')) {
        previewUrl = URL.createObjectURL(selectedFile); // Generate preview URL
      } else {
        previewUrl = ''; // Clear preview if not an image
      }
    }
  
    function handleDragOver(event) {
      event.preventDefault();
      isDragging = true;
    }
  
    function handleDragLeave() {
      isDragging = false;
    }
  
    function handleDrop(event) {
      event.preventDefault();
      isDragging = false;
      if (event.dataTransfer.files.length) {
        selectedFile = event.dataTransfer.files[0];
        if (selectedFile && selectedFile.type.startsWith('image/')) {
          previewUrl = URL.createObjectURL(selectedFile);
        } else {
          previewUrl = '';
        }
      }
    }
  
    function uploadFile() {
      if (selectedFile) {
        dispatch('upload', { file: selectedFile });
        URL.revokeObjectURL(previewUrl); // Clean up the preview URL after upload
      } else {
        console.warn("No file selected for upload.");
      }
    }
  </script>
  
  <div class="overlay" on:click={closeModal}>
    <div class="modal-container" on:click|stopPropagation>
      <button class="close-button" on:click={closeModal}>✕</button>
  
      <h2 class="title">{title}</h2>
  
      <div class="upload-area" 
           class:is-dragging={isDragging}
           on:dragover={handleDragOver} 
           on:dragleave={handleDragLeave} 
           on:drop={handleDrop}>
        <p>{description}</p>
        <p class="formats">Supported formats: {supportedFormats}</p>
        <input type="file" accept=".zip, .rar, .7z, .pdf, .jpg, .png" on:change={handleFileChange} class="file-input"/>
      </div>
  
      <!-- Display Image Preview if Available -->
      {#if previewUrl}
        <img src={previewUrl} alt="Image preview" class="image-preview" />
      {/if}
  
      <div class="file-input-container">
        {#if selectedFile}
          <p class="selected-file-name">{selectedFile.name}</p>
        {:else}
          <p>No file selected</p>
        {/if}
        <button on:click={uploadFile} class="upload-button">UPLOAD FILE</button>
      </div>
  
      <p class="deadlines">
        <strong>Soft Deadline:</strong> {softDeadline} <br />
        <strong>Hard Deadline:</strong> {hardDeadline}
      </p>
    </div>
  </div>
  
  <style>
    .overlay {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.5);
      display: flex;
      align-items: center;
      justify-content: center;
      z-index: 1000;
    }
  
    .modal-container {
      background: #ffffff;
      padding: 2rem;
      border-radius: 8px;
      max-width: 500px;
      width: 100%;
      text-align: center;
      position: relative;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    }
  
    .close-button {
      position: absolute;
      top: 1rem;
      right: 1rem;
      background: none;
      border: none;
      font-size: 1.5rem;
      cursor: pointer;
      color: #E74C3C;
    }
  
    .title {
      font-size: 1.5rem;
      color: #2C3E50;
      margin-bottom: 1.5rem;
    }
  
    .upload-area {
      margin-bottom: 1rem;
      padding: 1.5rem;
      border: 2px dashed #B3B3B3;
      border-radius: 8px;
      text-align: center;
      cursor: pointer;
      color: #333;
      transition: background-color 0.3s ease;
    }
  
    .upload-area.is-dragging {
      background-color: #e9f5ff;
      border-color: #007bff;
    }
  
    .formats {
      font-size: 0.85rem;
      color: #999;
    }
  
    .file-input {
      margin-top: 1rem;
    }
  
    .file-input-container {
      margin-top: 1rem;
      display: flex;
      flex-direction: column;
      align-items: center;
    }
  
    .selected-file-name {
      font-size: 0.9rem;
      color: #333;
      margin-top: 0.5rem;
    }
  
    .upload-button {
      margin-top: 1rem;
      background-color: #E74C3C;
      color: white;
      padding: 0.5rem 1rem;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-weight: bold;
    }
  
    /* Image Preview Styling */
    .image-preview {
      margin-top: 1rem;
      max-width: 100%;
      max-height: 200px;
      border-radius: 8px;
      object-fit: cover;
    }
  </style>
  