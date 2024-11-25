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
	private String image;

	private List<CartItem> shoppingCart = new ArrayList<>();
	private List<Allergen> allergens = new ArrayList<>();

	public User(Long userId, String name, String password, String email, Date birthday, int points, int stamps,
			String image) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.points = points;
		this.stamps = stamps;
		this.image = image;
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

	public List<Allergen> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<Allergen> allergens) {
		this.allergens = allergens;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", birthday=" + birthday + ", points=" + points + ", stamps=" + stamps + ", image=" + image
				+ ", shoppingCart=" + shoppingCart + ", allergens=" + allergens + "]";
	}

}