package com.sanjay.service;

import com.sanjay.exception.OrderException;
import com.sanjay.model.Address;
import com.sanjay.model.Order;
import com.sanjay.model.User;


import java.util.List;

public interface OrderService {


    public Order createOrder(User user, Address shippingAddress);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> usersOrderHistory(Long userId);
    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order cancleOrder(Long orderId) throws OrderException;
public List<Order>getAllOrders();
public void deleteOrder(Long orderId) throws OrderException;


}
