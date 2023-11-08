package com.sanjay.service;

import com.sanjay.exception.ProductException;
import com.sanjay.model.Review;
import com.sanjay.model.User;
import com.sanjay.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;

    public List<Review>getAllReview(Long productId);
}
