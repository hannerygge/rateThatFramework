package com.rateThatFramework.model;

/**
 * Created by Andre on 26.04.2016.
 */
public class Rating {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private User user;
    private Framework framework;
    private int rating;

}
