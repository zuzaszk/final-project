<script>
    import ModalTemplate from './ModalTemplate.svelte';
    import { currentProjectId } from '../../projectStore';
    import { get } from 'svelte/store';
    import { createEventDispatcher, onMount } from 'svelte';

    let showModal = true;
    const dispatch = createEventDispatcher();

    let softDeadline = '';
    let hardDeadline = '';

    const projectId = get(currentProjectId);
    const elementTypeId = 4; 

    function onClose() {
        showModal = false;
        dispatch('close');
    }

    async function onUpload(event) {
        const file = event.detail.file;
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
                console.log("File uploaded successfully for Poster");
                dispatch('upload', { success: true });
                showModal = false;
            } else {
                console.error("Failed to upload file for Poster");
            }
        } catch (error) {
            console.error("Error uploading file:", error);
        }
    }

    onMount(async () => {
        try {
            const response = await fetch(`http://192.168.0.102:8080/zpi/deadlines/getDeadlineByProjectIdAndElementTypeId?projectId=${projectId}&elementTypeId=${elementTypeId}`);
            if (response.ok) {
                const data = await response.json();
                softDeadline = data.softDeadline;
                hardDeadline = data.hardDeadline;
            } else {
                console.error("Failed to fetch deadlines");
            }
        } catch (error) {
            console.error("Error fetching deadlines:", error);
        }
    });
</script>

{#if showModal}
    <ModalTemplate 
        title="Upload Poster" 
        description="Upload your poster (jpg, png)" 
        supportedFormats="jpg, png"
        softDeadline={softDeadline} 
        hardDeadline={hardDeadline} 
        on:close={onClose} 
        on:upload={onUpload} 
    />
{/if}
