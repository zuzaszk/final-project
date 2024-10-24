<script>
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
</style>
