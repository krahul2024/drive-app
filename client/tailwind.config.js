/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      minWidth: {
        'max': 'max-content', 
      },
      colors: {
        'secondary' : '#0c0f18', 
        'primary' : '#030712'
        },
    },
  },
  plugins: [],
}