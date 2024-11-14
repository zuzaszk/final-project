<script>
    import ModalTemplate from './ModalTemplate.svelte';
    import { currentProjectId } from '../../projectStore';
    import { get } from 'svelte/store';
    import { createEventDispatcher } from 'svelte';
  
    let showModal = true;
    const dispatch = createEventDispatcher();
  
    function onClose() {
      showModal = false;
      dispatch('close'); 
    }
  
    async function onUpload(event) {
      const file = event.detail.file;  
      const projectId = get(currentProjectId);  
      const elementTypeId = 3;  
  
      const formData = new FormData();
      formData.append('file', file);
      formData.append('projectId', projectId);
      formData.append('elementTypeId', elementTypeId);
  
      try {
        const response = await fetch(`http://192.168.0.102:8080/zpi/projectElements/uploadElement?projectId=${projectId}&elementTypeId=${elementTypeId}`, {
          method: 'POST',
          body: formData
        });
  
        if (response.ok) {
          console.log("File uploaded successfully for Source Code");
          dispatch('upload', { success: true });
          showModal = false;  
        } else {
          console.error("Failed to upload file for Source Code");
        }
      } catch (error) {
        console.error("Error uploading file:", error);
      }
    }
  </script>
  
  {#if showModal}
    <ModalTemplate 
      title="Upload Source Code" 
      description="Upload your source code (zip file)" 
      supportedFormats="zip" 
      softDeadline="2024-12-13" 
      hardDeadline="2025-01-13" 
      on:close={onClose} 
      on:upload={onUpload} 
    />
  {/if}
  