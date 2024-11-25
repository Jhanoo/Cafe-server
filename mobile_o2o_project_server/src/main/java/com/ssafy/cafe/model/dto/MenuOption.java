package com.ssafy.cafe.model.dto;

public class MenuOption {

	private Long optionId;
	private String category;
	private String name;
	private int price;
	private boolean isRequired;

	public MenuOption(Long optionId, String category, String name, int price, boolean isRequired) {
		super();
		this.optionId = optionId;
		this.category = category;
		this.name = name;
		this.price = price;
		this.isRequired = isRequired;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	@Override
	public String toString() {
		return "MenuOption [optionId=" + optionId + ", category=" + category + ", name=" + name + ", price=" + price
				+ ", isRequired=" + isRequired + "]";
	}

}
