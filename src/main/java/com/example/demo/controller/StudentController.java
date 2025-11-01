package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cse/cse")
@CrossOrigin(origins = "*")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    // GET student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        try {
            Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    // UPDATE student by ID
    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<String> updateStudent(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) String marks,
            @RequestParam(required = false) MultipartFile photo) {
        try {
            Double marksValue = null;
            if (marks != null && !marks.isEmpty()) {
                try {
                    marksValue = Double.parseDouble(marks);
                } catch (NumberFormatException e) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid marks value");
                }
            }
            studentService.updateStudent(id, name, city, branch, marksValue, photo);
            return ResponseEntity.ok("Student updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student: " + e.getMessage());
        }
    }
    
    // DELETE student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    // POST endpoint to create a student
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createStudent(
            @RequestParam String name,
            @RequestParam String city,
            @RequestParam String branch,
            @RequestParam String marks,
            @RequestParam(required = false) MultipartFile photo) {
        try {
            // Parse marks from string to Double
            Double marksValue;
            try {
                marksValue = Double.parseDouble(marks);
            } catch (NumberFormatException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Invalid marks value: " + marks);
            }
            
            // Validate required fields
            if (name == null || name.trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Name is required");
            }
            if (city == null || city.trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("City is required");
            }
            if (branch == null || branch.trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Branch is required");
            }
            
            Student student = studentService.createStudent(name.trim(), city.trim(), branch.trim(), marksValue, photo);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating student: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected error: " + e.getMessage());
        }
    }
}

