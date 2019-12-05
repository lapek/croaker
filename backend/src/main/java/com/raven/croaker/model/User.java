package com.raven.croaker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(indexName = "auth", type = "user")
public class User {

    @Id
    private String id;

    @Size(min = 2, max = 20, message = "{user.info.name}")
    @NotNull
    private String username;

    @NotNull
    private String displayName;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    public User() {
    }

    public User(@Size(min = 2, max = 20, message = "{user.info.name}") @NotNull String username, @NotNull String displayName, @Email @NotNull String email, @NotNull String password) {
        this.username = username;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}