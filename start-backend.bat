@echo off
echo Starting Spring Boot Backend...
echo.
echo Backend will run on: http://localhost:8085
echo Frontend will be available at:
echo   - Main: http://localhost:8085/index.html
echo   - View: http://localhost:8085/view.html
echo   - Update: http://localhost:8085/update.html
echo   - Delete: http://localhost:8085/delete.html
echo.
call mvnw.cmd spring-boot:run
pause

