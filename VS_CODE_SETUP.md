# Visual Studio Code Setup Guide

This guide will help you set up VS Code to run both the frontend (HTML) and backend (Spring Boot) of this project.

## Prerequisites

1. **Install Visual Studio Code**: [Download VS Code](https://code.visualstudio.com/)
2. **Java Development Kit (JDK 17+)**: Required for Spring Boot
3. **MySQL Database**: Should be running on localhost:3306

## Step 1: Install Recommended Extensions

When you open the project in VS Code, you'll be prompted to install recommended extensions. Click "Install All" or manually install:

- **Extension Pack for Java** (by Microsoft)
- **Spring Boot Extension Pack** (by VMware)
- **Live Server** (by Ritwick Dey) - For running HTML files

### Manual Installation:
1. Press `Ctrl+Shift+X` to open Extensions
2. Search and install:
   - `Extension Pack for Java`
   - `Spring Boot Dashboard`
   - `Live Server`

## Step 2: Running the Backend (Spring Boot)

### Option A: Using VS Code Debugger (Recommended)
1. Press `F5` or go to Run → Start Debugging
2. Select "Launch Spring Boot Application"
3. Wait for the application to start (check the Debug Console)
4. Backend will run on `http://localhost:8085`

### Option B: Using Terminal
1. Open integrated terminal: `Ctrl+`` (backtick)
2. Run: `.\mvnw.cmd spring-boot:run`
3. Backend will start on `http://localhost:8085`

### Option C: Using Task
1. Press `Ctrl+Shift+P`
2. Type "Run Task"
3. Select "Maven: Spring Boot Run"

## Step 3: Running the Frontend (HTML Files)

The HTML files are now in the `/frontend` directory and should be run using VS Code Live Server.

### Using Live Server Extension (Required)
1. **Install "Live Server" extension** (if not already installed)
   - Press `Ctrl+Shift+X` to open Extensions
   - Search for "Live Server" by Ritwick Dey
   - Click Install

2. **Start Live Server**
   - Navigate to the `frontend` folder in VS Code
   - Right-click on `index.html`
   - Select "Open with Live Server"
   - Or click the "Go Live" button in VS Code status bar

3. **Frontend will open at**: `http://127.0.0.1:5500` or `http://localhost:5500`

**Important**: Make sure the Spring Boot backend is running on `http://localhost:8085` before using the frontend!

### Quick Start
1. Start backend: Press `F5` in VS Code (or run `.\mvnw.cmd spring-boot:run`)
2. Start frontend: Right-click `frontend/index.html` → "Open with Live Server"
3. Use the application in your browser

## Step 4: Configuration Files Created

The following VS Code configuration files have been set up:

- **`.vscode/launch.json`**: Debug configurations for Spring Boot
- **`.vscode/tasks.json`**: Maven build tasks
- **`.vscode/settings.json`**: Java and HTML editor settings
- **`.vscode/extensions.json`**: Recommended extensions list

## Quick Start Commands

### Terminal Commands:
```powershell
# Clean and compile
.\mvnw.cmd clean compile

# Run Spring Boot
.\mvnw.cmd spring-boot:run

# Package application
.\mvnw.cmd package
```

## Troubleshooting

### Backend won't start:
1. Check if MySQL is running
2. Verify database credentials in `src/main/resources/application.properties`
3. Check if port 8085 is available
4. Rebuild: `.\mvnw.cmd clean compile`

### Frontend can't connect to backend:
1. Ensure backend is running on `http://localhost:8085`
2. Check browser console for CORS errors
3. Backend already has `@CrossOrigin(origins = "*")` configured

### Java not detected:
1. Install JDK 17 or higher
2. Set `JAVA_HOME` environment variable
3. Restart VS Code

## Recommended Workflow

1. **Start Backend**: Press `F5` (Debug) or use terminal to run Spring Boot
2. **Open Frontend**: Navigate to `http://localhost:8085/index.html` in browser
3. **Development**: Edit HTML files in `src/main/resources/static/`
4. **Hot Reload**: Spring Boot will reload HTML files automatically on changes (no restart needed)

## Project Structure

```
BootProject2/
├── .vscode/              # VS Code configuration
│   ├── launch.json      # Debug configurations
│   ├── tasks.json       # Build tasks
│   └── settings.json    # Editor settings
├── src/
│   └── main/
│       ├── java/        # Backend Java code
│       └── resources/
│           └── static/  # Frontend HTML files
└── pom.xml              # Maven configuration
```

Enjoy coding! 🚀

