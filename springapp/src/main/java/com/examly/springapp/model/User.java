package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="username")
    private String username;

    @Column(name="mobileNumber")
    private String mobileNumber;

    @Column(name="active")
    private boolean active;

    @Column(name="role")
    private String role;

    @Column(name="reset_password_token")
    private String resetPasswordToken;

    User(){}
    User(String email,String password,String username,String mobileNumber,boolean active,String role,String resetPasswordToken){
        this.email = email;
        this.password = password;
        this.username = username;
        this.active = active;
        this.mobileNumber = mobileNumber;
        this.role = role;
        this.resetPasswordToken=resetPasswordToken;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public void setResetPasswordToken(String resetPasswordToken) {this.resetPasswordToken=resetPasswordToken;}

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getMobileNumber(){
        return this.mobileNumber;
    }

    public String getRole(){
        return this.role;
    }

    public boolean getActive(){
        return this.active;
    }

    public Long getId(){
        return this.id;
    }

    public String getResetPasswordToken() {return this.resetPasswordToken;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.getUsername()) ||
                Objects.equals(email, user.getEmail()) || Objects.equals(mobileNumber,user.getMobileNumber());
    }
}