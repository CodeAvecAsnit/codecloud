package com.springdos.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class StdntDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StdntDao() {
    }

    public StdntDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String Id, String name) throws DataAccessException {
        String sql = "Call InsertStd(?,?)";
        int rows = jdbcTemplate.update(sql, Id, name);
        if (rows != 1) {
            throw new RuntimeException("insert failed");
        } else {
            System.out.println("insert success");
        }
    }


    public void insert(Student student) {
        String sql = "Call InsertStd(?,?)";
        int rows = jdbcTemplate.update(sql, student.getId(), student.getUsername());
        if (rows != 1) {
            throw new RuntimeException("insert failed");
        } else System.out.println("insert success");
    }


    public void delete(Student student) throws DataAccessException {
        String sql = "Delete from Students where id = ?";
        int rows = jdbcTemplate.update(sql, student.getId());
        if (rows != 1) {
            throw new RuntimeException("delete failed");
        } else System.out.println("delete success");
    }


    public void delete(String Id) throws DataAccessException {
        String sql = "DELETE FROM Student WHERE Id = ?";
        int rows = jdbcTemplate.update(sql, Id);
        if (rows != 1) {
            throw new RuntimeException("delete failed");
        } else System.out.println("Delete success");

    }


    public void update(String Id, String Name) {
        String sql = "UPDATE Student Set UserName = ? WHERE Id = ?";
        int rows = jdbcTemplate.update(sql, Name, Id);
        if (rows != 1) {
            throw new RuntimeException("update failed");
        } else System.out.println("update success");
    }


    public void update(Student student, String UserName) {
        String sql = "UPDATE Students Set UserName = ? WHERE Id = ?";
        int rows = jdbcTemplate.update(sql, UserName, student.getId());
        if (rows != 1) {
            throw new RuntimeException("update failed");
        } else {
            student.setUsername(UserName);
            System.out.println("update success");
        }
    }


    public java.util.List<Student> getStudent(Student std)throws DataAccessException{
        String sql = "Select * from Student where Id = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        return jdbcTemplate.query(sql, rowMapper, std.getId());
    }


    public List<Student> getAllStudent()throws DataAccessException{
        String sql = "Select * from Student";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper(Student.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

}
