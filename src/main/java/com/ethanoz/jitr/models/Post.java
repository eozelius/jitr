package com.ethanoz.jitr.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity(name = "posts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    public void setUser (User user) {
        if (sameUser(user)) {
            System.out.println("[Post.java] setUser() warning: new user is same as old user.");
            return;
        }

        this.user = user;
    }

    public Long getPostId () { return id; }

    public Long getUserId() {
        return user.getId();
    }

    public String getTitle () {
        return title;
    }

    public String getBody () {
        return body;
    }

    // private utility methods
    private boolean sameUser (User newUser) {
        if (this.user == null) {
            return false;
        }

        return this.user.equals(newUser);
    }

    // overrides
    @Override
    public String toString() {
        return new String(
                "\n Post => {" +
                        "\n   id: " + this.id +
                        "\n   title: " + this.title +
                        "\n   body: " + this.body +
                        "\n }");
    }
}
