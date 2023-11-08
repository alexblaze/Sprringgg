package com.sanjay.service;

import com.sanjay.exception.ProductException;
import com.sanjay.model.Product;
import com.sanjay.model.Review;
import com.sanjay.model.User;
import com.sanjay.repository.ProductRepository;
import com.sanjay.repository.ReviewRepository;
import com.sanjay.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService{

    private ReviewRepository reviewRepository;
    private ProductService productService;

    private ProductRepository productRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {

        Product product = productService.findProductById(req.getProductId());
        Review review = new Review();
        review.setUser(user);
        review.setReview(req.getReview());
        review.setProduct(product);
        review.setCreatedAt(LocalDateTime.now());


        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {



        return reviewRepository.getAllProductsReview(productId);
    }
}
