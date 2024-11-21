package com.ssafy.cafe.model.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Menu {
	private Long menuId;
	private String name;
	private BigDecimal price;
	private String category;
	private String imageUrl;
	private String description;

	private double averageRating;

	private List<Allergen> allergens = new ArrayList<>();
	private List<MenuOption> options = new ArrayList<>();
	private List<Review> reviews = new ArrayList<>();

	public Menu(Long menuId, String name, BigDecimal price, String category, String imageUrl, String description) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.category = category;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public Menu() {
		super();
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<MenuOption> getOptions() {
		return options;
	}

	public void setOptions(List<MenuOption> options) {
		this.options = options;
	}

	public List<Allergen> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<Allergen> allergens) {
		this.allergens = allergens;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", imageUrl=" + imageUrl + ", description=" + description + ", averageRating=" + averageRating + "]";
	}

}