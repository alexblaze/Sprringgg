package com.sanjay.service;

import com.sanjay.exception.ProductException;
import com.sanjay.model.Product;
import com.sanjay.model.Rating;
import com.sanjay.model.User;
import com.sanjay.repository.RatingRepository;
import com.sanjay.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImplementation implements RatingService{

    private RatingRepository ratingRepository;
    private ProductService productService;

    public RatingServiceImplementation(RatingRepository ratingRepository, ProductService productService) {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
    }

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {

        Product product = productService.findProductById(req.getProductId());

        Rating rating= new Rating();

rating.setProduct(product);
rating.setUser(user);
rating.setRating(req.getRating());
rating.setCreatedAt(LocalDateTime.now());
return ratingRepository.save(rating);




    }

    @Override
    public List<Rating> getProductsRating(Long productId) {
        return ratingRepository.getAllProductsRating(productId);
    }
}
