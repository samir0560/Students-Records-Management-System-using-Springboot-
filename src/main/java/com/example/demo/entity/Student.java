package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String branch;
    
    @Column(nullable = false)
    private Double marks;
    
    @Column(length = 500)
    private String photo; // URL or path to the photo
    
    // Default constructor
    public Student() {
    }
    
    // Constructor with parameters
    public Student(String name, String city, String branch, Double marks, String photo) {
        this.name = name;
        this.city = city;
        this.branch = branch;
        this.marks = marks;
        this.photo = photo;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getBranch() {
        return branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    public Double getMarks() {
        return marks;
    }
    
    public void setMarks(Double marks) {
        this.marks = marks;
    }
    
    public String getPhoto() {
        return photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

