package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class LoginModel {
    @Id
    private String email;

    private String password;

    LoginModel(){}
    LoginModel(String email,String password){
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        LoginModel user = (LoginModel) o;
        return Objects.equals(password, user.getPassword()) &&
                Objects.equals(email, user.getEmail());
    }


}
