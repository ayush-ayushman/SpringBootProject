package com.jwt;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jwt.model.User;
import com.jwt.repo.UserRepository;

@SpringBootApplication
public class JwtauthenticationApplication implements  CommandLineRunner {
	
	@Autowired
    private UserRepository userRepository;

    Random random = new Random();

    public void createUsers() {

        User user = new User();
        Long id = new Long(random.nextInt(100));
        user.setId(id);
        user.setEmail("user" + id + "@gmail.com");
        user.setPassword("user" + id);
        user.setEnabled(true);
        user.setRol("Admin");
        user.setUsername("user" + id);
        User save = this.userRepository.save(user);

        System.out.println(save);

    }

    public static void main(String[] args) {
        SpringApplication.run(JwtauthenticationApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }

   
}
