package com.ssafy.cafe.model.dto;

import java.math.BigDecimal;

public class Menu {
	private Long menuId;
	private String name;
	private BigDecimal price;
	private String category;
	private String imageUrl;
	private String description;
	private double averageRating;
	private int reviewCount;

	public Menu(Long menuId, String name, BigDecimal price, String category, String imageUrl, String description,
			double averageRating, int reviewCount) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.category = category;
		this.imageUrl = imageUrl;
		this.description = description;
		this.averageRating = averageRating;
		this.reviewCount = reviewCount;
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

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", imageUrl=" + imageUrl + ", description=" + description + ", averageRating=" + averageRating
				+ ", reviewCount=" + reviewCount + "]";
	}

}