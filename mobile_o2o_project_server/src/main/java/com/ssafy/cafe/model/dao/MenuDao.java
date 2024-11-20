package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.Menu;

public interface MenuDao {
	List<Menu> getAllMenus();

	Menu getMenuById(Long menuId);

	int insertMenu(Menu menu);

	int deleteMenu(Long menuId);

}
