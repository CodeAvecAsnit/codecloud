package com.rm.useraccount.Controllers;

import com.rm.useraccount.Models.User;
import com.rm.useraccount.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/public")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll(){
        System.out.println("In this Section");
       return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
            return user == null ? ResponseEntity.notFound().build():ResponseEntity.ok(user);
    }

    @GetMapping("users/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        return user == null ? ResponseEntity.notFound().build():ResponseEntity.ok(user);
    }

    @GetMapping("users/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = userService.getUserByEmail(email);
        return user == null ? ResponseEntity.notFound().build():ResponseEntity.ok(user);
    }

    @PostMapping("/users/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/users/edit")
    public ResponseEntity<String> editUser(@RequestBody User user){
        try{
            userService.updateUser(user);
            return ResponseEntity.ok(user.getUserName()+" was updated");
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
            if(userService.deleteUser(id)){
            return ResponseEntity.ok("User deleted");
             }
            else return ResponseEntity.notFound().build();
    }
}
