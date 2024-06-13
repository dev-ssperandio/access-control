package com.example.accesscontrol;

import com.example.accesscontrol.model.User;
import com.example.accesscontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Sidney");
        user.setUsername("SSperandio");
        user.setPassword("123456");
        user.setRoles(null);
        repository.save(user);

        for (User u: repository.findAll()) {
            System.out.println(u);
        }
    }
}