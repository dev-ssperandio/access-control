package com.example.accesscontrol.service;

import com.example.accesscontrol.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

    @Autowired
    private UserService service;

    @BeforeAll
    void setup() {
        User user = new User();
        user.setName("Sidney");
        user.setUsername("SSperandio");
        user.setPassword("123456");
        user.setRoles(null);
        service.saveUser(user);
    }


    @Test
    void testSaveUser() {

    }

    @Test
    void testUpdateUser() {

    }

    @Test
    void testFindUserByUsername() {

    }

    @Test
    void testFindAllUsers() {

    }


    @AfterAll
    void tearDown() {

    }
}
