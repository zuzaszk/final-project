
<script>
    export let onSubmit; 
  </script>
  
  <div class="container mx-auto mt-10 bg-white p-8 rounded-lg shadow-lg text-center">
    <h2 class="text-2xl font-bold text-[#2C3E50] mb-6">Upload Your Final Project</h2>
  
    <div class="grid grid-cols-2 gap-6 mb-8">
      <button class="border border-dashed p-6 rounded-lg hover:border-[#E74C3C] flex flex-col items-center">
        <span class="text-[#E74C3C] font-semibold">Description</span>
      </button>
      <button class="border border-dashed p-6 rounded-lg hover:border-[#E74C3C] flex flex-col items-center">
        <span class="text-[#E74C3C] font-semibold">Short Description</span>
      </button>
      <button class="border border-dashed p-6 rounded-lg hover:border-[#2ECC71] flex flex-col items-center">
        <span class="text-[#2ECC71] font-semibold">Source Code</span>
      </button>
      <button class="border border-dashed p-6 rounded-lg hover:border-[#E74C3C] flex flex-col items-center">
        <span class="text-[#E74C3C] font-semibold">Report</span>
      </button>
      <button class="border border-dashed p-6 rounded-lg hover:border-[#2ECC71] flex flex-col items-center">
        <span class="text-[#2ECC71] font-semibold">Poster</span>
      </button>
      <button class="border border-dashed p-6 rounded-lg hover:border-[#2ECC71] flex flex-col items-center">
        <span class="text-[#2ECC71] font-semibold">Test Case</span>
      </button>
    </div>
  
    <button on:click={onSubmit} class="bg-[#E74C3C] text-white py-3 px-6 rounded-lg hover:bg-[#C0392B]">
      Submit Project
    </button>
  </div>
  
  <style>
    .container {
      max-width: 600px;
    }
  </style>
  