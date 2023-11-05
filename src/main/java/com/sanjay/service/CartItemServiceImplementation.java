package com.sanjay.service;

import com.sanjay.exception.CartItemException;
import com.sanjay.exception.UserException;
import com.sanjay.model.Cart;
import com.sanjay.model.CartItem;
import com.sanjay.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImplementation implements CartItemService {
    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        return null;
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        return null;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        return null;
    }
}
