package test.java.com.examly.springapp;

import main.java.com.examly.springapp.model.User;
import main.java.com.examly.springapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository testRepository;

   @Test
    void iffindByEmail() {
      
       String email = "test@gmail.com";
       String password = "mohh";
       String username = "test123";
       String mobileNumber = "9857390612";
       boolean active = true;
       String role ="Student";
       String resetPasswordToken ="eufhdhs";

       User user = new User(email,password,username,mobileNumber,active,role,resetPasswordToken);
       testRepository.save(user);



    }


    void findByResetPasswordToken() {
    }
}