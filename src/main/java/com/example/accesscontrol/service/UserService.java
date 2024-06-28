package com.example.accesscontrol.service;

import com.example.accesscontrol.exception.BusinessException;
import com.example.accesscontrol.model.User;
import com.example.accesscontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    //Simulating a database with the user table
    //private List<User> database = new ArrayList<>();

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        Optional<User> existingUser = repository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new BusinessException("User already exist.");
        }
        System.out.println("Saving user");
        return repository.save(user);
    }

    public User updateUser(/*Integer id*/ User user) {
        if (!repository.existsById(user.getId())) {
            throw new BusinessException("User not found.");
        }
        System.out.println("Updating user");
        /*User updatedUser = repository.findById(id).orElse(null);
        updatedUser.setName(user.getName());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setRoles(user.getRoles());*/
        return repository.save(user);
    }

    public User findUserByUsername(String username) {
        System.out.println("Searching for user by login");
        return repository.findByUsername(username)
                .orElseThrow(() -> new BusinessException("User not found."));
    }

    public List<User> findAllUsers() {
        System.out.println("Listing all users");
        return repository.findAll();
    }

    public void deleteUserById(Integer id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("User not found.");
        }
        System.out.println("Deleting user with Id: " + id);
        repository.deleteById(id);
    }
}
