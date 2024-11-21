package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.Menu;

public interface MenuService {

	public List<Menu> getAllMenus();

	public Menu getMenuById(Long menuId);

	public int insertMenu(Menu menu);

	public int deleteMenu(Long menuId);

	public double getMenuAverageRating(Long menuId);
}
