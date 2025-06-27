package com.springdos.JDBC;
import java.util.List;

public interface StudentDao {
    void insert(String Id,String Name);
    void insert(Student student);
    void delete(String Id);
    void delete(Student student);
    void update(String Id,String Name);
    void update(Student student,String UserName);
    List<Student> getStudent(Student std);
    List<Student> getAllStudent();
}
