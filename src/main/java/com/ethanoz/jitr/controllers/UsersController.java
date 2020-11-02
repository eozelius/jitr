package com.ethanoz.jitr.controllers;

import com.ethanoz.jitr.models.User;
import com.ethanoz.jitr.models.Post;
import com.ethanoz.jitr.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        User user = userRepository.getOne(id);
        return user;
    }

    // POST create a new user
    @RequestMapping
    public User create (@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    /**
     * POST create a new User Post.
     *
     * @PathVariable { Long } userId - id of the User who is adding the new post
     * @RequestBody { Post } post - post to be created, does not yet exist in db
     * @return { User } user - user object with freshly saved post.
     */
    @RequestMapping(value = "{userId}/posts", method = RequestMethod.POST)
    public User createPost (@PathVariable Long userId, @RequestBody Post post) {
        User user = userRepository.getOne(userId);
        user.addPost(post);
        return userRepository.saveAndFlush(user);
    }

    // PUT update a user
    @RequestMapping (value = "{id}", method = RequestMethod.PUT)
    public User update (@PathVariable Long id, @RequestBody User user) {
        User userToUpdate = userRepository.getOne(id);
        BeanUtils.copyProperties(user, userToUpdate, "id");
        return userRepository.saveAndFlush(userToUpdate);
    }

    // DELETE a user
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
    }
}
