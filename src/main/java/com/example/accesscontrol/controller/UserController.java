package com.example.accesscontrol.controller;

import com.example.accesscontrol.model.User;
import com.example.accesscontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/users")
    public void post(@RequestBody User user) {
        service.saveUser(user);
    }

    @PutMapping("/users")
    public void put(@RequestBody User user) {
        service.updateUser(user);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return service.findAllUsers();
    }

    @GetMapping("/users/{username}")
    public User getOne(@PathVariable("username") String username) {
        return service.findUserByUsername(username);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.deleteUserById(id);
    }
}