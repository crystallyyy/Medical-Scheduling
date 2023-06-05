package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Review {
    @JsonIgnore
    private int reviewId;
    private int officeId;
    private String description;
    private int rating;
    private int patientId;

    public Review() {
    }

    public Review(int reviewId, int officeId, String description, int rating) {
        this.reviewId = reviewId;
        this.officeId = officeId;
        this.description = description;
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
