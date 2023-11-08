package com.sanjay.service;

import com.sanjay.exception.ProductException;
import com.sanjay.model.Cart;
import com.sanjay.model.CartItem;
import com.sanjay.model.Product;
import com.sanjay.model.User;
import com.sanjay.repository.CartRepository;
import com.sanjay.request.AddItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplementation implements CartService{



    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService productService;

    public CartServiceImplementation(CartRepository cartRepository, CartItemService cartItemService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    @Override
    public Cart createCart(User user) {

        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);

    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {

        Cart cart = cartRepository.findByUserId(userId);
        Product product = productService.findProductById(req.getProductId());

        CartItem isPresent=cartItemService.isCartItemExist(cart,product,req.getSize(),userId);

        if(isPresent==null){
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(req.getQuantity());
            cartItem.setUserId(userId);

            int price = req.getQuantity()*product.getDiscountedPrice();

            cartItem.setPrice(price);
            cartItem.setSize(req.getSize());

            CartItem createdCartItem = cartItemService.createCartItem();
            cart.getCartItems().add(createdCartItem);
        }

        return "Item Added to Cart";

    }

    @Override
    public Cart findUserCart(Long userId) {

        Cart cart = cartRepository.findByUserId(userId);

        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem = 0;

        for (CartItem cartItem :cart.getCartItems()){
            totalPrice =totalPrice+cartItem.getPrice();
            totalDiscountedPrice=totalDiscountedPrice+cartItem.getDiscountedPrice();
            totalItem=totalItem+cartItem.getQuantity();
        }

        cart.setTotalItems(totalItem);
        cart.setTotalDiscountedPrice(totalDiscountedPrice);
        cart.setTotalPrice(totalPrice);
        cart.setDiscounte(totalPrice - totalDiscountedPrice);

        return cartRepository.save(cart);


    }
}
