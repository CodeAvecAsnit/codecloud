package com.rm.useraccount.Service;

import com.rm.useraccount.Models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserImpl {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public String createUser(User user);
    public User updateUser(User user);
    public boolean deleteUser(int id);
}
