package com.examly.springapp.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.User;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
public class Login {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value="/login",method=RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<Object> loginUser(@RequestBody LoginModel user){
        for (User x : userRepository.findAll()) {
            if ((x.getEmail().equals(user.getEmail())) && (x.getPassword().equals(user.getPassword()))) {
                System.out.println("Success");
                return new ResponseEntity<>("Insert session token",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Login failed",HttpStatus.OK);
    }



}
