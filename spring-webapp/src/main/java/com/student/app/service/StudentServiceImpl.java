package com.student.app.service;

import com.student.app.dao.StudentDao;
import com.student.app.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        studentDao.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        if (student == null || student.getId() <= 0) {
            throw new IllegalArgumentException("Invalid student data");
        }
        studentDao.update(student);
    }

    @Override
    public void removeStudent(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid student ID");
        }
        studentDao.delete(id);
    }

    @Override
    public Student getStudentById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid student ID");
        }
        return studentDao.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}
