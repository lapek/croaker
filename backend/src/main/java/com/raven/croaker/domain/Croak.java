package com.raven.croaker.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "wall", type = "croak")
public class Croak {

    @Id
    private String id;

    private Date postDate;

    private String message;

    public Croak() {
    }

    public Croak(String id, Date postDate, String message) {
        this.id = id;
        this.postDate = postDate;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
