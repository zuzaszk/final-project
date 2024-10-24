<script>
    import Header from '../components/Header.svelte';
    import UploadForm from '../components/UploadForm.svelte';
  </script>
  
  
  <div class="min-h-screen bg-[#F7F9F9]">
    <Header />
  
    <div class="max-w-5xl mx-auto pt-24 px-6 scaleContainer"> 
      <UploadForm />
    </div>
  </div>
  
  
  <style>
    .container {
      padding-top: 100px; 
    }

    .scaleContainer {
    transform: scale(0.75); 
    transform-origin: center; 
    margin-top: -90px;
  }
  </style>
  