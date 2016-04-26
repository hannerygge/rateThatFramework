package com.rateThatFramework.model;

/**
 * Created by Andre on 26.04.2016.
 */
public class Reviews {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Framework getFramework() {
        return framework;
    }

    public void setFramework(Framework framework) {
        this.framework = framework;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    private User user;
    private Framework framework;
    private String review;
}
