<script>
    export let paddingTop = "80px"; 
  </script>
  
  <div class="page-wrapper" style="padding-top: {paddingTop}; padding-bottom: 40px;">
    <slot></slot>
  </div>
  
  <style>
    .page-wrapper {
      max-width: 100%;
      padding: 0 1rem;
      background-color: #FFFFFF;
      border-radius: 8px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }
  </style>
  