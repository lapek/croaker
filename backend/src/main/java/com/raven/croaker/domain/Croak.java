package com.raven.croaker.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "wall", type = "croak")
public class Croak implements Serializable {

    @Id
    private String id;

    @Field(type = FieldType.Date, store = true, format = DateFormat.basic_date_time)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z")
    @CreatedDate
    private Date postDate;

    @Field(type = FieldType.Date, store = true, format = DateFormat.basic_date_time)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z")
    @LastModifiedDate
    private Date lastEditDate;

    @Field(type = FieldType.text)
    private String message;


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
}
