package com.sanjay.repository;

import com.sanjay.model.Cart;
import com.sanjay.model.CartItem;
import com.sanjay.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    @Query("Select ci From CartItem ci where ci.cart=:card and ci.product=:product and ci.size=:size and ci.userId=:userId")
    public CartItem isCartItemExist(@Param("cart")Cart cart, @Param("product")Product product, @Param("size")String size, @Param("userId")Long userId);

}
