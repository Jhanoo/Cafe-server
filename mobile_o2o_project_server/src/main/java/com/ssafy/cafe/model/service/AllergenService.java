package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.Allergen;

public interface AllergenService {

	public Allergen getAllergen(Long allergenId);

	public void insertAllergen(Allergen allergen);

	public void updateAllergen(Allergen allergen);

	public void deleteAllergen(Long allergenId);

	public void insertAllergenToMenu(Long menuId, Long allergenId);

	public void deleteAllergenMappingByMenuId(Long menuId);

	public void insertAllergenToUser(Long userId, Long allergenId);

	public void deleteAllergenMappingByUser(Long userId, Long allergenId);

	public List<Allergen> getAllergensByUserId(Long userId);

	public void deleteAllAllergenByUser(Long userId);

	public List<Allergen> getAllAllergens();

	public List<Allergen> getAllergensByMenuId(Long menuId);
}
