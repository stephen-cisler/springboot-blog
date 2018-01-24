package com.codeup.springbootblog.Models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id @GeneratedValue
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
//    @JoinColumn(name="user_id")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }



    public Post() {
    }

//    public Post(String title, String body) {
//        this.title = title;
//        this.body = body;
//    }

//    public Post(long id, String title, String body) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//    }
}
