# Frontend Directory

This directory contains the HTML frontend files that are served independently from the Spring Boot backend.

## Running the Frontend

### Using VS Code Live Server (Recommended)

1. **Install Live Server Extension** in VS Code (if not already installed)
   - Press `Ctrl+Shift+X` to open Extensions
   - Search for "Live Server" by Ritwick Dey
   - Click Install

2. **Start Live Server**
   - Right-click on `index.html` in this folder
   - Select "Open with Live Server"
   - Or click the "Go Live" button in VS Code status bar

3. **Frontend will open at**: `http://127.0.0.1:5500` or `http://localhost:5500`

## Backend Connection

The frontend connects to the Spring Boot backend API running on:
- **Backend URL**: `http://localhost:8085`
- **API Base Path**: `/cse/cse`

## Before Running Frontend

**Make sure the Spring Boot backend is running!**

1. Start the backend (from project root):
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```
   Or press `F5` in VS Code to debug

2. Backend should be running on: `http://localhost:8085`

3. Then start the frontend using Live Server

## Files

- `index.html` - Main page with navigation
- `view.html` - View and Add student records
- `update.html` - Update student information
- `delete.html` - Delete student records

## Note

All API calls in the HTML files are configured to point to `http://localhost:8085/cse/cse/...`

If you need to change the backend URL, update the `fetch()` calls in each HTML file.

