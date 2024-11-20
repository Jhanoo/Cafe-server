package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.Menu;

public interface MenuService {

	List<Menu> getAllMenus();

	Menu getMenuById(Long menuId);

	int insertMenu(Menu menu);

	int deleteMenu(Long menuId);
}
