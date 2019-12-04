package com.raven.croaker.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "wall", type = "croak")
public class Croak implements Serializable {

    @Id
    private String id;

    @Field(type = FieldType.Date, index = false)
    private Date postDate;

    @Field(type = FieldType.Date, index = false)
    private Date lastEditDate;

    @Field(type = FieldType.Text)
    private String message;

    @Field(type = FieldType.Text)
    private String userId;

    @Field(type = FieldType.Text)
    private String username;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
