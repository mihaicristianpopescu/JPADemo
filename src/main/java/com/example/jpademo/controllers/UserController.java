package com.example.jpademo.controllers;

import com.example.jpademo.entities.User;
import com.example.jpademo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public User getUserById(@RequestParam final long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody final User user) {
        return userService.saveUser(user);
    }
}
