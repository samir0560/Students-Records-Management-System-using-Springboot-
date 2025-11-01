# ✅ Frontend-Backend Separation Complete!

## What Was Changed

1. ✅ **HTML files moved** from `src/main/resources/static/` to `/frontend` directory
2. ✅ **Spring Boot configured** to only serve the REST API (no static HTML files)
3. ✅ **VS Code configured** for Live Server to serve frontend from `/frontend` directory
4. ✅ **API URLs verified** - All HTML files point to `http://localhost:8085`

## How to Run

### Step 1: Start Backend (Spring Boot)
```powershell
# In VS Code: Press F5
# Or in terminal:
.\mvnw.cmd spring-boot:run
```
Backend runs on: **http://localhost:8085**

### Step 2: Start Frontend (Live Server)
1. Open VS Code
2. Navigate to `frontend` folder
3. Right-click `index.html`
4. Select **"Open with Live Server"**

Frontend runs on: **http://127.0.0.1:5500**

## Architecture

```
┌─────────────────┐         ┌─────────────────┐
│   Frontend      │         │    Backend       │
│   (Live Server) │ ──────> │  (Spring Boot)   │
│   Port: 5500    │  HTTP   │   Port: 8085     │
│                 │         │   REST API       │
└─────────────────┘         └─────────────────┘
```

## Important Notes

1. **CORS is configured** - Backend has `@CrossOrigin(origins = "*")` so frontend can call the API
2. **Both must run** - Frontend needs backend to be running to make API calls
3. **API Base URL**: `http://localhost:8085/cse/cse`
4. **Frontend URL**: `http://127.0.0.1:5500` (via Live Server)

## Troubleshooting

### "User not found" Error
- This means you're trying to view a student that doesn't exist
- **Solution**: First add students using the "Add Student" form on the view page

### Frontend can't connect to backend
- Make sure backend is running on port 8085
- Check browser console for errors
- Verify API URL in HTML files (should be `http://localhost:8085`)

### Live Server not working
- Install "Live Server" extension in VS Code
- Make sure you're right-clicking `frontend/index.html`
- Check VS Code status bar for "Go Live" button

## Files Structure

```
BootProject2/
├── frontend/              ← HTML files (served by Live Server)
│   ├── index.html
│   ├── view.html
│   ├── update.html
│   └── delete.html
├── src/
│   └── main/
│       └── resources/
│           └── static/    ← Empty (HTML files moved)
└── ...
```

Enjoy coding! 🚀

