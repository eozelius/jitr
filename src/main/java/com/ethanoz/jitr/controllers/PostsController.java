package com.ethanoz.jitr.controllers;

import com.ethanoz.jitr.models.Post;
import com.ethanoz.jitr.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    // GET all posts
    @GetMapping
    public List<Post> posts () {
        return postRepository.findAll();
    }

    // GET an individual post
    @GetMapping
    @RequestMapping("{id}")
    public Post post (@PathVariable Long id) {
        Post p = postRepository.getOne(id);
        System.out.println("u => " + p);
        System.out.println("u.getUser => " + p.getUserId());
        return p;
    }
}