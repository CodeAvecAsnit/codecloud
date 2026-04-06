package com.student.app.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private double gpa;
    private String department;

    public Student() {
    }

    public Student(int id, String name, String email, String phone, double gpa, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gpa=" + gpa +
                ", department='" + department + '\'' +
                '}';
    }
}

