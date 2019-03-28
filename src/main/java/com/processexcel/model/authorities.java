package com.processexcel.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class authorities {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String authority;


    @ManyToOne
    private users users;

    public authorities() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public com.processexcel.model.users getUsers() {
        return users;
    }

    public void setUsers(com.processexcel.model.users users) {
        this.users = users;
    }
}
