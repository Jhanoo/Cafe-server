package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.MenuOption;
import com.ssafy.cafe.model.dto.OrderDetail;

public interface OrderDetailDao {

	List<OrderDetail> getOrderDetailsByOrderId(Long orderId);

	void insertOrderDetail(OrderDetail orderDetail);

	void deleteOrderDetail(Long orderDetailId);
	
	void insertOrderOption(Long orderDetailId, Long optionId);
	
	List<MenuOption> getOrderOptions(Long orderDetailId);
}
