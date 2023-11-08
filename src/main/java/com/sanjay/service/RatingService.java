package com.sanjay.service;

import com.sanjay.exception.ProductException;
import com.sanjay.model.Rating;
import com.sanjay.model.User;
import com.sanjay.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    public Rating createRating(RatingRequest req, User user) throws ProductException;

    public List<Rating>getProductsRating(Long productId);


}
