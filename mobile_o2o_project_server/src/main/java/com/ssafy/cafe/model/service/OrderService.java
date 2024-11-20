package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.Order;

public interface OrderService {

	public List<Order> getOrdersByUserId(Long userId);
	
	public Order getOrderById(Long orderId);

	public void insertOrder(Order order);

	public void updateOrderStatus(Long orderId, String status);

}
