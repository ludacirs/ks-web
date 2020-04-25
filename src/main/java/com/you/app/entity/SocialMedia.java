package com.you.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SocialMedia {

    @Id
    @GeneratedValue
    private Long id;

    private String github;
    private String instagram;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }


    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public  SocialMedia(){

    }
    public SocialMedia(String github, String instagram) {
        this.github = github;
        this.instagram = instagram;
    }
}