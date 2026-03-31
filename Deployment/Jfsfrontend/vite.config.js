// vite.config.js
import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [
    react({
      // Treat .js files as JSX
      include: "**/*.{js,jsx,ts,tsx}"
    })
  ]
});