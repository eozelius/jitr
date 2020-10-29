package com.ethanoz.jitr.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;

    // db relationships
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // getters and setters
    public Long getUserId() {
        return user.getId();
    }

    public void setUser (User user) {
        id = user.getId();
    }

    public String getTitle () {
        return title;
    }

    public String getBody () {
        return body;
    }

}
