package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.dao.OrderDetailDao;
import com.ssafy.cafe.model.dto.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailDao orderDetailDao;

	@Override
	public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
		return orderDetailDao.getOrderDetailsByOrderId(orderId);
	}

	@Override
	public void insertOrderDetail(OrderDetail orderDetail) {
		orderDetailDao.insertOrderDetail(orderDetail);
	}

	@Override
	public void deleteOrderDetail(Long orderDetailId) {
		orderDetailDao.deleteOrderDetail(orderDetailId);
	}

}
