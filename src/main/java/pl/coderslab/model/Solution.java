package pl.coderslab.model;

import java.sql.Timestamp;

public class Solution {

    private int id;
    private Exercise exercise;
    private User user;
    private Timestamp created;
    private Timestamp updated;
    private String description;

    public Solution () {

    }

    public Solution(Exercise exercise, User user, String description) {
        this.exercise = exercise;
        this.user = user;
        this.created = new Timestamp(System.currentTimeMillis());
        this.updated = this.created;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public void setCreated() {
        this.created = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public void setUpdated() {
        this.updated = new Timestamp(System.currentTimeMillis());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
