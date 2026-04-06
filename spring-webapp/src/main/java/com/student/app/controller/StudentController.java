package com.student.app.controller;

import com.student.app.model.Student;
import com.student.app.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        try {
            Student student = studentService.getStudentById(id);
            model.addAttribute("student", student);
            return "edit-student";
        } catch (Exception e) {
            System.err.println("Error fetching student with id: " + id + " - " + e.getMessage());
            e.printStackTrace();
            return "redirect:/students";
        }
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        try {
            studentService.addStudent(student);
            System.out.println("Student added successfully: " + student.getName());
        } catch (Exception e) {
            System.err.println("Error adding student: " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/students";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        try {
            studentService.updateStudent(student);
            System.out.println("Student updated successfully: " + student.getName());
        } catch (Exception e) {
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        try {
            studentService.removeStudent(id);
            System.out.println("Student deleted successfully with id: " + id);
        } catch (Exception e) {
            System.err.println("Error deleting student with id: " + id + " - " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String viewStudent(@PathVariable int id, Model model) {
        try {
            Student student = studentService.getStudentById(id);
            model.addAttribute("student", student);
            return "view-student";
        } catch (Exception e) {
            System.err.println("Error fetching student with id: " + id + " - " + e.getMessage());
            e.printStackTrace();
            return "redirect:/students";
        }
    }
}
