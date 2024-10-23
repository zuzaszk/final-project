<script>
    export let project;  
  </script>
  
  <div class="bg-white p-6 rounded-lg shadow-md text-center">
    <h2 class="text-2xl font-bold text-[#2C3E50] mb-2">{project.title}</h2>
    <p class="text-[#34495E] mb-4">Acronym: {project.acronym}</p>
    <p class="text-[#7F8C8D] mb-4">{project.description}</p>
    <p class="text-[#7F8C8D]">Year: {project.year}</p>
    <p class="text-[#7F8C8D]">Language: {project.language}</p>
    <button class="bg-[#E74C3C] text-white p-2 rounded-lg hover:bg-[#C0392B]">View Details</button>
  </div>
  