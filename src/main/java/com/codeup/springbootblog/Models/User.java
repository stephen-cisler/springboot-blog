package com.codeup.springbootblog.Models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
}
