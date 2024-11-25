package com.ssafy.cafe.model.dto;

public class CartItemOption {

	private Long cartOptionId;
	private Long cartId;
	private Long optionId;

	public CartItemOption(Long cartOptionId, Long cartId, Long optionId) {
		super();
		this.cartOptionId = cartOptionId;
		this.cartId = cartId;
		this.optionId = optionId;
	}

	public Long getCartOptionId() {
		return cartOptionId;
	}

	public void setCartOptionId(Long cartOptionId) {
		this.cartOptionId = cartOptionId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	@Override
	public String toString() {
		return "CartItemOption [cartOptionId=" + cartOptionId + ", cartId=" + cartId + ", optionId=" + optionId + "]";
	}

}
