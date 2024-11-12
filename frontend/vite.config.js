import { defineConfig } from 'vite';
import { svelte } from '@sveltejs/vite-plugin-svelte';

export default defineConfig({
  plugins: [svelte()],
  resolve: {
    alias: {
      '@': '/src',  // This creates an alias for the src folder
    },
  },
  server: {
    host: '0.0.0.0',  // Allows access from other devices on the network
    port: 5173,       // Change this if needed
  },
});
