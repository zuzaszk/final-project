<script>
  export let onClose;
  export let onAdded;
  let sourceCodeFile = null;

  function handleFileChange(event) {
    sourceCodeFile = event.target.files[0];
  }

  function submitSourceCode() {
    if (sourceCodeFile) {
      onAdded();
      onClose();
    }
  }
</script>

<div class="modal">
  <div class="modal-content">
    <h3>Upload Source Code</h3>
    <input type="file" accept=".zip,.rar" on:change={handleFileChange} />
    <button on:click={submitSourceCode}>Upload</button>
    <button on:click={onClose}>Cancel</button>
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
  }
  textarea {
    width: 100%;
    height: 100px;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #e0e0e0;
    border-radius: 5px;
  }
  button {
    margin: 5px;
  }
</style>