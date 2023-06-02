package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDAO{

    private final JdbcTemplate jdbcTemplate;
    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Review getReviewById(int id){
        Review review = null;
        String sql = "SELECT * FROM reviews WHERE review_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            review = mapRowToReview(result);
        }
        return review;
    }

    @Override
    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Review addReview(Review review) {
        Review newReview = null;
        String sql = "INSERT INTO reviews (office_id, description, rating) " +
                "VALUES (?, ?, ?) RETURNING review_id";
        int reviewId = jdbcTemplate.queryForObject(sql, int.class, review.getOfficeId(), review.getDescription(), review.getRating());

        return getReviewById(reviewId);
    }

    @Override
    public List<Review> getReviewByOffice(int officeId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE office_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);

        while (results.next()){
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }


    private Review mapRowToReview(SqlRowSet row){
        Review review = new Review(
                row.getInt("review_id"),
                row.getInt("office_id"),
                row.getString("description"),
                row.getInt("rating")
        );

        return review;
    }
}
