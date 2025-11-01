# Quick Start Guide

## Fastest Way to Run the Application

### Step 1: Start the Backend

**Option A: Using VS Code (Easiest)**
- Press `F5` in VS Code
- Select "Launch Spring Boot Application"
- Wait for "Started BootProject2Application" message

**Option B: Using Batch File**
- Double-click `start-backend.bat`

**Option C: Using Command Line**
```powershell
.\mvnw.cmd spring-boot:run
```

### Step 2: Start Frontend with Live Server

1. **Install Live Server Extension** (if not installed):
   - Press `Ctrl+Shift+X` in VS Code
   - Search "Live Server" → Install

2. **Start Frontend**:
   - Navigate to `frontend` folder
   - Right-click `index.html` → "Open with Live Server"
   - Browser will open at `http://127.0.0.1:5500`

That's it! 🎉

**Note**: Frontend runs on port 5500, backend API on port 8085

## What Happens:

1. ✅ Backend starts on port 8085
2. ✅ MySQL connection is established
3. ✅ Database table `students` is created automatically
4. ✅ HTML files are served from `src/main/resources/static/`
5. ✅ API endpoints are ready at `/cse/cse/*`

## Troubleshooting:

- **Port 8085 in use?** Change `server.port` in `application.properties`
- **MySQL connection error?** Check credentials in `application.properties`
- **Class not found?** Run `.\mvnw.cmd clean compile` first

## VS Code Features:

- **F5**: Start debugging
- **Ctrl+Shift+P**: "Run Task" → Select Maven commands
- **Java Extension Pack**: Provides IntelliSense and debugging
- **Live Reload**: HTML changes appear immediately (just refresh browser)

