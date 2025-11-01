package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class StudentService {
    
    private static final String UPLOAD_DIR = "uploads/";
    
    @Autowired
    private StudentRepository studentRepository;
    
    // Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
    
    // Update student
    public Student updateStudent(Long id, String name, String city, String branch, Double marks, MultipartFile photo) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        
        // Update fields if provided
        if (name != null && !name.isEmpty()) {
            student.setName(name);
        }
        if (city != null && !city.isEmpty()) {
            student.setCity(city);
        }
        if (branch != null && !branch.isEmpty()) {
            student.setBranch(branch);
        }
        if (marks != null) {
            student.setMarks(marks);
        }
        
        // Handle photo upload
        if (photo != null && !photo.isEmpty()) {
            try {
                String photoPath = savePhoto(photo, id);
                student.setPhoto(photoPath);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save photo: " + e.getMessage());
            }
        }
        
        return studentRepository.save(student);
    }
    
    // Delete student
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
    
    // Create new student
    public Student createStudent(String name, String city, String branch, Double marks, MultipartFile photo) {
        Student student = new Student(name, city, branch, marks, null);
        student = studentRepository.save(student);
        
        // Handle photo upload if provided
        if (photo != null && !photo.isEmpty()) {
            try {
                String photoPath = savePhoto(photo, student.getId());
                student.setPhoto(photoPath);
                student = studentRepository.save(student);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save photo: " + e.getMessage());
            }
        }
        
        return student;
    }
    
    // Helper method to save photo
    private String savePhoto(MultipartFile photo, Long studentId) throws IOException {
        // Create upload directory if it doesn't exist
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        
        // Get file extension
        String originalFilename = photo.getOriginalFilename();
        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        
        // Create unique filename
        String filename = "student_" + studentId + extension;
        Path filePath = uploadPath.resolve(filename);
        
        // Save file
        Files.copy(photo.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        
        // Return URL path for accessing the photo
        return "/uploads/" + filename;
    }
}

