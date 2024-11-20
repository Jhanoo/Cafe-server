package com.ssafy.cafe.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;
    
    @PostMapping
    @Operation(summary="order 객체를 저장하고 추가된 Order의 id를 반환한다.", 
    		description = "<pre>아래 형태로 입력하면 주문이 입력된다. \r\n"
    				+"{\r\n"
    				+ "  \"userId\": \"ssaf\",\r\n"
    				+ "  \"totalPrice\": \"4000\",\r\n"
    				+ "  \"orderStatus\": \"Pending\",\r\n"
    				+ "} "
					+ "</pre>")
	public ResponseEntity<Long> insertOrder(@RequestBody Order order) {
		logger.debug("insertOrder", order);
		orderService.insertOrder(order);
		return ResponseEntity.ok(order.getOrderId());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
	}
	
	@GetMapping("/detail/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
	
	@PutMapping("/{orderId}/status")
	public ResponseEntity<Void> updateOrderStatus(@PathVariable Long orderId, String status) {
		orderService.updateOrderStatus(orderId, status);
		return ResponseEntity.ok().build();
	}


}
