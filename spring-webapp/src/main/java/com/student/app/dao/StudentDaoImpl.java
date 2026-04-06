package com.student.app.dao;

import com.student.app.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_SQL = 
        "INSERT INTO students (name, email, phone, gpa, department) VALUES (?, ?, ?, ?, ?)";
    
    private static final String UPDATE_SQL = 
        "UPDATE students SET name=?, email=?, phone=?, gpa=?, department=? WHERE id=?";
    
    private static final String DELETE_SQL = "DELETE FROM students WHERE id=?";
    
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM students WHERE id=?";
    
    private static final String SELECT_ALL_SQL = "SELECT * FROM students";

    @Override
    public void save(Student student) {
        jdbcTemplate.update(INSERT_SQL,
            student.getName(),
            student.getEmail(),
            student.getPhone(),
            student.getGpa(),
            student.getDepartment()
        );
    }

    @Override
    public void update(Student student) {
        jdbcTemplate.update(UPDATE_SQL,
            student.getName(),
            student.getEmail(),
            student.getPhone(),
            student.getGpa(),
            student.getDepartment(),
            student.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    @Override
    public Student findById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new StudentRowMapper(), id);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new StudentRowMapper());
    }

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setPhone(rs.getString("phone"));
            student.setGpa(rs.getDouble("gpa"));
            student.setDepartment(rs.getString("department"));
            return student;
        }
    }
}
