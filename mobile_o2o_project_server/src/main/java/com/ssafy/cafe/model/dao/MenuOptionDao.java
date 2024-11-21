package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.MenuOption;

public interface MenuOptionDao {

	List<MenuOption> getMenuOptionByMenuId(Long menuId);

	void insertMenuOption(MenuOption option);

	void deleteMenuOption(Long optionId);

	void updateMenuOption(MenuOption option);

}
