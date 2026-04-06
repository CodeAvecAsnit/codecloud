-- Create Database
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

-- Create Students Table
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    gpa DECIMAL(3, 2) NOT NULL,
    department VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create User for the Application
CREATE USER IF NOT EXISTS 'student_user'@'localhost' IDENTIFIED BY 'student_pass@123';
GRANT ALL PRIVILEGES ON student_db.* TO 'student_user'@'localhost';
FLUSH PRIVILEGES;

-- Insert Sample Data (Optional)
-- INSERT INTO students (name, email, phone, gpa, department) VALUES 
-- ('John Doe', 'john.doe@example.com', '9876543210', 3.8, 'Computer Science'),
-- ('Jane Smith', 'jane.smith@example.com', '9876543211', 3.6, 'Engineering'),
-- ('Robert Johnson', 'robert.j@example.com', '9876543212', 3.9, 'Business');
