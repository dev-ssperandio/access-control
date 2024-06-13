package com.example.accesscontrol.service;

import com.example.accesscontrol.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    //Simulating a database with the user table
    private List<User> database = new ArrayList<>();

    public void save(User user) {
        System.out.println("Saving user");
        database.add(user);
    }

    public void update(User user) {
        System.out.println("Updating user");
        int index = database.indexOf(user);
        database.set(index, user);
    }

    public User findByUsername(String username) {
        System.out.println("Searching for user by login");
        int index = database.indexOf(new User(username));
        return database.get(index);
    }

    public List<User> findAll() {
        System.out.println("Listing all users");
        return database;
    }
}
