package com.sanjay.service;

import com.sanjay.exception.ProductException;
import com.sanjay.model.Cart;
import com.sanjay.model.User;
import com.sanjay.repository.CartRepository;
import com.sanjay.request.AddItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplementation implements CartService{

    private CartRepository cartRepository;

    @Override
    public Cart createCart(User user) {
        return null;
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
        return null;
    }

    @Override
    public Cart findUserCart(Long userId) {
        return null;
    }
}
