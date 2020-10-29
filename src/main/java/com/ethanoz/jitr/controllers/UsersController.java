package com.ethanoz.jitr.controllers;

import com.ethanoz.jitr.models.User;
import com.ethanoz.jitr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    // GET all users
    @GetMapping
    public List<User> users () {
        return userRepository.findAll();
    }

    // GET an individual user
    @GetMapping
    @RequestMapping("{id}")
    public User user (@PathVariable Long id) {
        User u = userRepository.getOne(id);
        System.out.println("u => " + u);
        System.out.println("u => " + u.getPosts());
        return u;
    }
}
