package com.student.app.dao;

import com.student.app.model.Student;
import java.util.List;

public interface StudentDao {
    void save(Student student);
    void update(Student student);
    void delete(int id);
    Student findById(int id);
    List<Student> findAll();
}
