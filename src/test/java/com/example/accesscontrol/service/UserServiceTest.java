package com.example.accesscontrol.service;

import com.example.accesscontrol.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        User user = new User("Ivanessa", "IDantas", "456123", null);
        User savedUser = service.saveUser(user);
        assertEquals(savedUser, user);
    }

    @Test
    void testUpdateUser() {
        User user = new User("Ivanessa", "IDantas", "456123", null);
        User updatedUser = service.updateUser(1, user);
        assertEquals(updatedUser, user);
    }

    @Test
    void testFindUserByUsername() {
        User user = new User("Ivanessa", "IDantas", "456123", null);
        User savedUser = service.saveUser(user);
        User retrievedUser = service.findUserByUsername(savedUser.getUsername());
        assertEquals("Ivanessa", retrievedUser.getName());
    }

    @Test
    void testFindAllUsers() {
        Assertions.assertFalse(service.findAllUsers().isEmpty());
    }




    @AfterAll
    void tearDown() {
        service.deleteUserById(1);
    }
}
