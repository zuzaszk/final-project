<script>
  export let project;
</script>

<div class="bg-white p-4 rounded-lg shadow-md text-center flex flex-col justify-between" style="min-height: 250px;"> <!-- Ensured consistent height -->
  <div>
    <h2 class="text-xl font-bold text-[#2C3E50] mb-2">{project.title}</h2>
    <p class="text-sm text-[#34495E] mb-2">Acronym: {project.acronym}</p>
    <p class="text-sm text-[#7F8C8D] mb-4">{project.description}</p>
  </div>
  <button class="bg-[#E74C3C] text-white p-2 rounded-lg hover:bg-[#C0392B] text-sm mx-auto block" style="width: 160px;">View Details</button>

</div>
