package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.CartItem;
import com.ssafy.cafe.model.dto.CartItemOption;
import com.ssafy.cafe.model.dto.MenuOption;

public interface ShoppingCartDao {

	List<CartItem> getCartByUserId(Long userId);

	void addToCart(CartItem cartItem);

	void updateCartItem(CartItem cartItem);
	
	void removeFromCart(Long cartId);

	void clearCartByUserId(Long userId);

	List<MenuOption> getCartItemOptions(Long cartId);

	void insertCartItemOption(CartItemOption cartItemOption);

	
}
