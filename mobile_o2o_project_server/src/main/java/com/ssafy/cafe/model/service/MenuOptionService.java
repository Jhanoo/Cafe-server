package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.MenuOption;

public interface MenuOptionService {

	List<MenuOption> getMenuOptionByMenuId(Long menuId);

	void insertMenuOption(MenuOption option);

	void deleteMenuOption(Long optionId);

	void updateMenuOption(MenuOption option);
}
