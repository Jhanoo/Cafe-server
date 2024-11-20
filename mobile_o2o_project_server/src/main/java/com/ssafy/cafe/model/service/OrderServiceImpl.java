package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.cafe.model.dao.OrderDao;
import com.ssafy.cafe.model.dao.OrderDetailDao;
import com.ssafy.cafe.model.dao.UserDao;
import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.User;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	OrderDetailDao orderDetailDao;

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public void insertOrder(Order order) {
		// client에서 들어온 id 는 무시해야 오류생기지 않음.
		order.setOrderId(null);

		orderDao.insertOrder(order);

		// 사용자 정보 업데이트
		User user = new User();
		user.setUserId(order.getUserId());
		int stampCnt = user.getStamps() + 1;
		userDao.updateStamps(user.getUserId(), stampCnt);

	}

	@Override
	public List<Order> getOrdersByUserId(Long userId) {
		return orderDao.getOrdersByUserId(userId);
	}

	@Override
	public void updateOrderStatus(Long orderId, String status) {
		orderDao.updateOrderStatus(orderId, status);
	}

	@Override
	public Order getOrderById(Long orderId) {
        return orderDao.getOrderById(orderId);
	}

}
