package com.ssafy.cafe.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	private Long userId;
	private String name;
	private String password;
	private String email;
	private Date birthday;
	private int points;
	private int stamps;
	private List<CartItem> shoppingCart = new ArrayList<>();

	public User(Long userId, String name, String password, String email, Date birthday, int points, int stamps) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.points = points;
		this.stamps = stamps;
	}

	public User() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStamps() {
		return stamps;
	}

	public void setStamps(int stamps) {
		this.stamps = stamps;
	}

	public List<CartItem> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<CartItem> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", birthday=" + birthday + ", points=" + points + ", stamps=" + stamps + "]";
	}

}