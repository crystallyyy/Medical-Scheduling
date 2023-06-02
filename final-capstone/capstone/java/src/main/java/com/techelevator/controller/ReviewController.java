package com.techelevator.controller;


import com.techelevator.dao.ReviewDAO;
import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class ReviewController {

    @Autowired
    ReviewDAO reviewDAO;

   @GetMapping(path = "/reviews")
    public List<Review> listReviews(){
        return reviewDAO.getAllReviews();
   }

   @ResponseStatus(HttpStatus.CREATED)
   @PostMapping(path = "/submitReview")
    public Review newReview(@Valid @RequestBody Review review){
        return reviewDAO.addReview(review);
   }

   @GetMapping(path = "/reviews/offices/{officeId}")
    public List<Review> getReviewsByOfficeId(@PathVariable int officeId){
       return reviewDAO.getReviewByOffice(officeId);
   }
}
