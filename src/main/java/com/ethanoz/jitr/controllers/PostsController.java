package com.ethanoz.jitr.controllers;

import com.ethanoz.jitr.models.Post;
import com.ethanoz.jitr.repositories.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
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
        return postRepository.getOne(id);
    }

    // PUT update a post
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Post update (@PathVariable Long id, @RequestBody Post post) {
        Post postToUpdate = postRepository.getOne(id);
        BeanUtils.copyProperties(post, postToUpdate, "id");
        return postRepository.saveAndFlush(post);
    }

    // DELETE a post
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        Post post = postRepository.getOne(id);
        postRepository.delete(post);
    }
}