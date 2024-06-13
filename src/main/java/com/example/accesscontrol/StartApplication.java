package com.example.accesscontrol;

import com.example.accesscontrol.model.User;
import com.example.accesscontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserService service;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            service.save(new User("user" + i));
        }

        User user2 = service.findByUsername("user2");
        user2.setName("MAIN");
        service.update(user2);

        for (User user: service.findAll()) {
            System.out.println(user);
        }
    }
}