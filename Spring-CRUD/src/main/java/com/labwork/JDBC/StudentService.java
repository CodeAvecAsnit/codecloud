package com.labwork.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Add CRUD methods here
}
