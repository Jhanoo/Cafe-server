package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.CartItem;

public interface ShoppingCartService {

	public List<CartItem> getCartByUserId(Long userId);

	public void addToCart(CartItem cartItem);
	
	public void updateCartItem(CartItem cartItem);

	public void removeFromCart(Long cartId);

	public void clearCartByUserId(Long userId);
}
