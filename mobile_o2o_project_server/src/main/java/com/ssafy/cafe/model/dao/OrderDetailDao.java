package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.OrderDetail;

public interface OrderDetailDao {

	List<OrderDetail> getOrderDetailsByOrderId(Long orderId);

	void insertOrderDetail(OrderDetail orderDetail);

	void deleteOrderDetail(Long orderDetailId);
}
