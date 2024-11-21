package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.MenuOption;

public interface MenuOptionService {

	public List<MenuOption> getMenuOptionByMenuId(Long menuId);

	public void insertMenuOption(MenuOption option);

	public void deleteMenuOption(Long optionId);

	public void updateMenuOption(MenuOption option);
}
