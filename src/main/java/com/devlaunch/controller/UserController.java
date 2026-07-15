package com.devlaunch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devlaunch.entity.User;
import com.devlaunch.service.UserService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE USER
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        User savedUser = userService.saveUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // GET ALL USERS
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        User user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    // GET USER BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {

        User user = userService.getUserByEmail(email);

        return ResponseEntity.ok(user);
    }

    // GET USER BY NAME
    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {

        User user = userService.getUserByName(name);

        return ResponseEntity.ok(user);
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody User user) {

        User updatedUser = userService.updateUser(id, user);

        return ResponseEntity.ok(updatedUser);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.ok("User Deleted Successfully");
    }

}