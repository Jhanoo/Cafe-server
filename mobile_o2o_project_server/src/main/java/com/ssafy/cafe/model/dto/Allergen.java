package com.ssafy.cafe.model.dto;

public class Allergen {

	private Long allergenId;
	private String name;

	public Allergen(Long allergenId, String name) {
		super();
		this.allergenId = allergenId;
		this.name = name;
	}

	public Long getAllergenId() {
		return allergenId;
	}

	public void setAllergenId(Long allergenId) {
		this.allergenId = allergenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Allergen [allergenId=" + allergenId + ", name=" + name + "]";
	}

}
