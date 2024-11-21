package com.ssafy.cafe.model.dto;

public class CartItem {

	private Long cartId;
	private Long userId;
	private Long menuId;
	private int quantity;

	public CartItem(Long cartId, Long userId, Long menuId, int quantity) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.menuId = menuId;
		this.quantity = quantity;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "CartItem [cartId=" + cartId + ", userId=" + userId + ", menuId=" + menuId + ", quantity=" + quantity
				+ "]";
	}

}
