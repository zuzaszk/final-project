<!-- <script>
  export let project;
</script>

<div class="bg-white p-4 rounded-lg shadow-md text-center flex flex-col justify-between transform hover:scale-95 transition-transform duration-300 ease-in-out" style="min-height: 220px; width: 100%;"> 
  <div>
    <h2 class="text-lg font-bold text-[#2C3E50] mb-2">{project.title}</h2>
    <p class="text-sm text-[#34495E] mb-2">Acronym: {project.acronym}</p>
    <p class="text-xs text-[#7F8C8D] mb-4">{project.description}</p>
  </div>
  <button class="bg-[#E74C3C] text-white p-2 rounded-lg hover:bg-[#C0392B] text-sm mx-auto block" style="width: 140px;">View Details</button>
</div>

<style>
  div {
    width: 100%;
    max-width: 350px; 
    transition: transform 0.3s ease-in-out;
  }

  div:hover {
    transform: scale(1.05); 
  }
</style> -->

<script>
  export let project;
</script>

<div class="card-container bg-white p-4 rounded-lg shadow-md text-center flex flex-col justify-between transform hover:scale-95 transition-transform duration-300 ease-in-out"> 
  <div>
    <h2 class="title text-lg font-bold text-[#2C3E50] mb-2">{project.title}</h2>
    <p class="acronym text-sm text-[#34495E] mb-2">Acronym: {project.acronym}</p>
    <p class="description text-xs text-[#7F8C8D] mb-4">{project.description}</p>
  </div>
  <button class="view-button bg-[#E74C3C] text-white p-2 rounded-lg hover:bg-[#C0392B] text-sm mx-auto block">View Details</button>
</div>

<style>

  .card-container {
    min-height: 200px;
    width: 100%;
    max-width: 320px;
    transition: transform 0.3s ease-in-out;
    padding: 1rem;
  }

  .title {
    font-size: 1rem; 
  }

  .acronym {
    font-size: 0.875rem;
  }

  .description {
    font-size: 0.75rem;
  }


  .view-button {
    width: 120px; 
    font-size: 0.875rem;
    padding: 0.5rem;
  }


  .card-container:hover {
    transform: scale(1.03);
  }


  @media (max-width: 640px) {
    .card-container {
      padding: 0.75rem;
      max-width: 100%;
    }

    .title {
      font-size: 0.9rem;
    }

    .acronym, .description {
      font-size: 0.75rem;
    }

    .view-button {
      width: 100%; 
      padding: 0.5rem;
    }
  }
</style>
