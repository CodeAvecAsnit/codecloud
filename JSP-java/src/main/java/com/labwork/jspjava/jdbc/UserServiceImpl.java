package com.labwork.jspjava.jdbc;

import java.util.List;
import java.sql.SQLException;

public record UserServiceImpl(UserRepository userRepository) implements UserService {

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public User getUserById(int id) {
        try {
            return userRepository.getById(id).orElse(null);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createUser(User user) {
        try {
            userRepository.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userRepository.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            userRepository.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
