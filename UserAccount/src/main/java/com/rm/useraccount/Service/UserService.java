package com.rm.useraccount.Service;

import com.rm.useraccount.Models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserImpl {

    private List<User> userList;

    @PostConstruct
    public void init() {
        userList = new ArrayList<>();
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User getUserById(int id) {
        return findUserById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return findUserByField(user -> user.getAccount().getEmailAddress().equals(email)).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return findUserByField(user -> user.getUserName().equals(username)).orElse(null);
    }

    @Override
    public String createUser(User user) {
        userList.add(user);
        return user.getUserName() + " created successfully";
    }

    @Override
    public User updateUser(User user) {
        return findUserById(user.getUserId()).map(existingUser -> {
            existingUser.setUserName(user.getUserName());
            existingUser.setAccount(user.getAccount());
            return existingUser;
        }).orElse(null);
    }

    @Override
    public boolean deleteUser(int id) {
        return userList.removeIf(user -> user.getUserId() == id);
    }

    private Optional<User> findUserById(int id) {
        return userList.stream().filter(user -> user.getUserId() == id).findFirst();
    }

    private Optional<User> findUserByField(Predicate<User> predicate) {
        return userList.stream().filter(predicate).findFirst();
    }
}