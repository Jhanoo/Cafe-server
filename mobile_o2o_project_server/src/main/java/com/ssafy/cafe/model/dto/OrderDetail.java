package com.ssafy.cafe.model.dto;

public class OrderDetail {
	private Long orderDetailId;
	private Long orderId;
	private Long menuId;
	private int quantity;

	public OrderDetail(Long orderDetailId, Long orderId, Long menuId, int quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", menuId=" + menuId
				+ ", quantity=" + quantity + "]";
	}

}
