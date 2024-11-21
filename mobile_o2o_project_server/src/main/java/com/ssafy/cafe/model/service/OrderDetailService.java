package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.MenuOption;
import com.ssafy.cafe.model.dto.OrderDetail;

public interface OrderDetailService {

	public List<OrderDetail> getOrderDetailsByOrderId(Long orderId);

	public void insertOrderDetail(OrderDetail orderDetail);

	public void deleteOrderDetail(Long orderDetailId);

	public void insertOrderOption(Long orderDetailId, Long optionId);

	public List<MenuOption> getOrderOptions(Long orderDetailId);
}
