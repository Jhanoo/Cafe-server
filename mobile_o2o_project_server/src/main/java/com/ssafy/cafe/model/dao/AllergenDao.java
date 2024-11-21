package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.Allergen;

public interface AllergenDao {

	Allergen getAllergen(Long allergenId);

	void insertAllergen(Allergen allergen);

	void updateAllergen(Allergen allergen);

	void deleteAllergen(Long allergenId);

	// Menu랑 mapping
	void insertAllergenToMenu(Long menuId, Long allergenId);

	void deleteAllergenMappingByMenuId(Long menuId);

	// User랑 mapping
	void insertAllergenToUser(Long userId, Long allergenId);

	void deleteAllergenMappingByUser(Long userId, Long allergenId);

	List<Allergen> getAllergensByUserId(Long userId);
	
}
