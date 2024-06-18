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

    @GetMapping
    public List<User> list() {
        return service.findAllUsers();
    }

    @PostMapping
    public void save(@RequestBody User user) {
        service.saveUser(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        service.updateUser(user);
    }

    @GetMapping("/{username}")
    public User find(@PathVariable("/username") String username) {
        return service.findUserByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("/id") Integer id) {
        service.deleteUserById(id);
    }
}