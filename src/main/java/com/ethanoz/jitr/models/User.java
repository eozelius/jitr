package com.ethanoz.jitr.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {
    // db columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

//    @Lob
//    @Type(type="org.hibernate.type.BinaryType")
//    private byte[] photo;

    // db relationships
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Post> posts = new ArrayList<>();

    // getters and setters
    public void addPost(final Post post) {
        if (posts.contains(post)) {
            System.out.println("[User.java] addPost() warning: user already contains this post.");
            return;
        }
        posts.add(post);
        post.setUser(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts () {
        return posts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // overrides

    @Override
    public String toString() {
        return new String(
                "\n User => { " +
                        "\n  id:" + this.id +
                        "\n  firstName: " + this.firstName +
                        "\n  lastName: " + this.lastName +
                        "\n}"
        );
    }
}
