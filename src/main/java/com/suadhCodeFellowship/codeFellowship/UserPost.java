package com.suadhCodeFellowship.codeFellowship;

import com.suadhCodeFellowship.codeFellowship.AppUser.AppUser;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public long getId() {
        return id;
    }

    public AppUser getPostWriter() {
        return postWriter;
    }

    public String getPost() {
        return post;
    }



    @ManyToOne
    public AppUser postWriter;
    public String post;
    public Timestamp createdAt;

    public UserPost(){}

    public UserPost(String post, AppUser postWriter, Timestamp createdAt){
        this.post = post;
        this.postWriter = postWriter;
        this.createdAt = createdAt;
    }

}