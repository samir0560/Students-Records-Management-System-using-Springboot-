# Student Records Management System

A Spring Boot application for managing student records with CRUD operations.

## Features

- View student details by ID
- Update student information (name, city, branch, marks, photo)
- Delete student records
- Photo upload support

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Database Configuration

**MySQL Database**

The application is configured to use MySQL database. Make sure MySQL is installed and running before starting the application.

**MySQL Setup:**

1. Install MySQL if not already installed
2. Create a database (or it will be auto-created):
   ```sql
   CREATE DATABASE studentdb;
   ```
3. Update database credentials in `application.properties` if different from defaults:
   - Username: `root`
   - Password: `root`
   - Update the password in `application.properties` with your actual MySQL password

## Running the Application

### Using VS Code (Recommended)

1. **Open the project in VS Code**
2. **Install recommended extensions** (you'll be prompted automatically)
3. **Start Backend**: Press `F5` or go to Run → Start Debugging
4. **Open Frontend**: Navigate to `http://localhost:8085/index.html` in your browser

See [VS_CODE_SETUP.md](VS_CODE_SETUP.md) for detailed VS Code setup instructions.

### Using Command Line

1. Clone or navigate to the project directory
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   Or use Maven wrapper:
   ```bash
   .\mvnw.cmd spring-boot:run
   ```

3. The application will start on `http://localhost:8085`

## Accessing the Application

### Frontend (HTML Files)
The frontend HTML files are in the `/frontend` directory and should be run using VS Code Live Server:

1. **Start Backend**: Press `F5` in VS Code or run `.\mvnw.cmd spring-boot:run`
2. **Start Frontend**: 
   - Right-click `frontend/index.html` in VS Code
   - Select "Open with Live Server"
   - Frontend will open at `http://127.0.0.1:5500`

### Backend API
- **API Base URL**: `http://localhost:8085/cse/cse`
- Spring Boot only serves the REST API, not the HTML files

## API Endpoints

- **GET** `/cse/cse/{id}` - Get student by ID
- **PUT** `/cse/cse/{id}` - Update student by ID
- **DELETE** `/cse/cse/{id}` - Delete student by ID
- **POST** `/cse/cse` - Create new student (for testing)

## Project Structure

```
src/main/java/com/example/demo/
├── entity/
│   └── Student.java          # Student entity
├── repository/
│   └── StudentRepository.java # JPA Repository
├── service/
│   └── StudentService.java    # Business logic
├── controller/
│   └── StudentController.java # REST endpoints
└── config/
    └── WebConfig.java         # Static file serving config
```

## Notes

- Photos are stored in the `uploads/` directory in the project root
- The database table will be auto-created on first run
- **Important:** Make sure MySQL is running and the database credentials in `application.properties` are correct before starting the application
- Update `spring.datasource.password` in `application.properties` with your actual MySQL root password

