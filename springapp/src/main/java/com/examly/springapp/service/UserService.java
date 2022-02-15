package com.examly.springapp.service;

import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean doesUserExists(LoginModel user) {
        for (User x : userRepository.findAll()) {
            if ((x.getEmail().equals(user.getEmail())) && (passwordEncoder.matches(user.getPassword(),x.getPassword()))) {
                System.out.println("Success");
                return true;
            }
        }
        return false;
    }

    public boolean doesUserExists(User user) {
        for (User x : userRepository.findAll()) {
            if ((x.getEmail().equals(user.getEmail())) && (x.getUsername().equals(user.getUsername()))) {
                System.out.println("User Already exists!");
                return true;
            }
        }
        return false;
    }

    public void updateResetPasswordToken(String token, String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        }
    }

    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    public void updatePassword(User user, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
}