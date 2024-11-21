package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.dao.AllergenDao;
import com.ssafy.cafe.model.dto.Allergen;

@Service
public class AllergenServiceImpl implements AllergenService {

	@Autowired
	private AllergenDao allergenDao;

	@Override
	public Allergen getAllergen(Long allergenId) {
		return allergenDao.getAllergen(allergenId);
	}

	@Override
	public void insertAllergen(Allergen allergen) {
		allergenDao.insertAllergen(allergen);
	}

	@Override
	public void updateAllergen(Allergen allergen) {
		allergenDao.updateAllergen(allergen);
	}

	@Override
	public void deleteAllergen(Long allergenId) {
		allergenDao.deleteAllergen(allergenId);
	}

	@Override
	public void insertAllergenToMenu(Long menuId, Long allergenId) {
		allergenDao.insertAllergenToMenu(menuId, allergenId);
	}

	@Override
	public void deleteAllergenMappingByMenuId(Long menuId) {
		allergenDao.deleteAllergenMappingByMenuId(menuId);
	}

	@Override
	public void insertAllergenToUser(Long userId, Long allergenId) {
		allergenDao.insertAllergenToUser(userId, allergenId);
	}

	@Override
	public void deleteAllergenMappingByUser(Long userId, Long allergenId) {
		allergenDao.deleteAllergenMappingByUser(userId, allergenId);
	}

	@Override
	public List<Allergen> getAllergensByUserId(Long userId) {
		return allergenDao.getAllergensByUserId(userId);
	}

}
