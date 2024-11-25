package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.dao.ShoppingCartDao;
import com.ssafy.cafe.model.dto.CartItem;
import com.ssafy.cafe.model.dto.CartItemOption;
import com.ssafy.cafe.model.dto.MenuOption;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartDao cartDao;

	@Override
	public List<CartItem> getCartByUserId(Long userId) {
		return cartDao.getCartByUserId(userId);
	}

	@Override
	public void addToCart(CartItem cartItem) {
		cartDao.addToCart(cartItem);
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		cartDao.updateCartItem(cartItem);
	}

	@Override
	public void removeFromCart(Long cartId) {
		cartDao.removeFromCart(cartId);
	}

	@Override
	public void clearCartByUserId(Long userId) {
		cartDao.clearCartByUserId(userId);
	}

	@Override
	public List<MenuOption> getCartItemOptions(Long cartId) {
		return cartDao.getCartItemOptions(cartId);
	}

	@Override
	public void insertCartItemOption(CartItemOption cartItemOption) {
		cartDao.insertCartItemOption(cartItemOption);
	}

}
