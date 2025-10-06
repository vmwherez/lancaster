package com.example.springboot_demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

// @Entity
// public class User {
//     @Id
//     private Long id;
//     private String name;
//     private String email;
//
//     // Default constructor for JPA
//     public User() {}
//
//     public User(Long id, String name, String email) {
//         this.id = id;
//         this.name = name;
//         this.email = email;
//     }
//
//     // Getters and setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
// }