package com.ssafy.cafe.model.dto;

public class MenuOption {

	private Long optionId;
	private Long menuId;
	private String name;
	private int price;
	private boolean isRequired;

	public MenuOption(Long optionId, Long menuId, String name, int price, boolean isRequired) {
		super();
		this.optionId = optionId;
		this.menuId = menuId;
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
		return "MenuOption [optionId=" + optionId + ", menuId=" + menuId + ", name=" + name + ", price=" + price
				+ ", isRequired=" + isRequired + "]";
	}

}
