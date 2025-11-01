-- SQL script to fix the students table AUTO_INCREMENT issue
-- Run this script in MySQL to fix the existing table structure

-- Drop the existing table if you want to recreate it
DROP TABLE IF EXISTS students;

-- Create the table with proper AUTO_INCREMENT
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    branch VARCHAR(255) NOT NULL,
    marks DOUBLE NOT NULL,
    photo VARCHAR(500)
);

-- Alternative: If you want to keep existing data, use ALTER TABLE instead:
-- ALTER TABLE students MODIFY id BIGINT AUTO_INCREMENT PRIMARY KEY;

