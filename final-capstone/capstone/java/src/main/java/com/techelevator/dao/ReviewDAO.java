package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDAO {

    List<Review> getAllReviews();
    Review addReview(Review review);
    List<Review> getReviewByOffice(int id);
}
