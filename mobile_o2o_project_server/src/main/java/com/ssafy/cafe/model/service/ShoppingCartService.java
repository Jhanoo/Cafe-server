package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.CartItem;
import com.ssafy.cafe.model.dto.CartItemOption;
import com.ssafy.cafe.model.dto.MenuOption;

public interface ShoppingCartService {

	public List<CartItem> getCartByUserId(Long userId);

	public void addToCart(CartItem cartItem);
	
	public void updateCartItem(CartItem cartItem);

	public void removeFromCart(Long cartId);

	public void clearCartByUserId(Long userId);
	
	public List<MenuOption> getCartItemOptions(Long cartId);

	public void insertCartItemOption(CartItemOption cartItemOption);
}
