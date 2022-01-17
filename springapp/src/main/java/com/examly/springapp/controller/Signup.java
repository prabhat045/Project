package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.model.User;

@CrossOrigin(origins = "*")
@RestController
public class Signup {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/signup")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
