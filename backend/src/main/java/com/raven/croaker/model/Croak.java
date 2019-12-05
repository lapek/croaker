package com.raven.croaker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "wall", type = "croak")
public class Croak {

    @Id
    private String id;

    private Date postDate;

    private Date lastEditDate;

    private String message;

    private User user;

    public void setId(String id) {
        this.id = id;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
