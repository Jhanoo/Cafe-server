package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.Order;

public interface OrderDao {

    void insertOrder(Order order);

    void updateOrderStatus(Long orderId, String status);

    List<Order> getOrdersByUserId(Long userId);

    Order getOrderById(Long orderId);
 
}
