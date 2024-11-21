package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.dao.MenuDao;
import com.ssafy.cafe.model.dto.Menu;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> getAllMenus() {
		return menuDao.getAllMenus();
	}

	@Override
	public Menu getMenuById(Long menuId) {
		return menuDao.getMenuById(menuId);
	}

	@Override
	public int insertMenu(Menu menu) {
		return menuDao.insertMenu(menu);
	}

	@Override
	public int deleteMenu(Long menuId) {
		return menuDao.deleteMenu(menuId);
	}

	@Override
	public double getMenuAverageRating(Long menuId) {
		return menuDao.getMenuAverageRating(menuId);
	}
	
}
