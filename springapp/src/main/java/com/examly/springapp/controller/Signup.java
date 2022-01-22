package com.examly.springapp.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.model.User;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
public class Signup {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value="/signup",method=RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        for (User x : userRepository.findAll()) {
            if (x.equals(user)) {
                System.out.println("User Already exists!");
                return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
