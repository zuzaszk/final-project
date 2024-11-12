<script>
  export let onClose;
  export let onAdded;
  let description = '';

  

  function submitDescription() {
    if (description) {
      onAdded(); 
      onClose();
    }
  }
</script>

<div class="modal">
  <div class="modal-content">
    <button class="close-button" on:click={onClose}>×</button>
    <h3 class="modal-title">Enter Project Description</h3>
    <textarea bind:value={description} placeholder="Write your project description here..."></textarea>
    <div class="modal-actions">
      <button class="save-button" on:click={submitDescription}>Save</button>
      <button class="cancel-button" on:click={onClose}>Cancel</button>
    </div>
  </div>
</div>

<style>
  .modal {
    position: fixed;
    top: 0; left: 0;
    width: 100%; height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .modal-content {
    background: white;
    padding: 20px;
    border-radius: 8px;
    width: 400px;
    max-width: 90%;
    position: relative;
  }
  .modal-title {
    font-size: 1.25rem;
    margin-bottom: 1rem;
  }
  textarea {
    width: 100%;
    height: 100px;
    padding: 10px;
    border: 1px solid #e0e0e0;
    border-radius: 5px;
    margin-bottom: 15px;
  }
  .modal-actions {
    display: flex;
    justify-content: space-between;
  }
  .save-button {
    background: #28a745;
    color: white;
    padding: 8px 16px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  .cancel-button {
    background: #e74c3c;
    color: white;
    padding: 8px 16px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  .close-button {
    position: absolute;
    top: 8px;
    right: 8px;
    background: transparent;
    border: none;
    font-size: 1.5rem;
    cursor: pointer;
  }
</style>
