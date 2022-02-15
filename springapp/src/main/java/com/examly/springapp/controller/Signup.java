package com.examly.springapp.controller;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class Signup {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/signup",method=RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        if(userService.doesUserExists(user))
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        else
        {
            userService.saveUser(user);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
    }
}