package com.labwork.jspjava.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll() throws SQLException;
    Optional<User> getById(int id) throws SQLException;
    void create(User user) throws SQLException;
    void update(User user) throws SQLException;
    void delete(int id) throws SQLException;
}
