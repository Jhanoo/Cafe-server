package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.dao.MenuOptionDao;
import com.ssafy.cafe.model.dto.MenuOption;

@Service
public class MenuOptionServiceImpl implements MenuOptionService {

	@Autowired
	private MenuOptionDao menuOptionDao;
	
	@Override
	public List<MenuOption> getMenuOptionByMenuId(Long menuId) {
		return menuOptionDao.getMenuOptionByMenuId(menuId);
	}

	@Override
	public void insertMenuOption(MenuOption option) {
		menuOptionDao.insertMenuOption(option);
	}

	@Override
	public void deleteMenuOption(Long optionId) {
		menuOptionDao.deleteMenuOption(optionId);
	}

	@Override
	public void updateMenuOption(MenuOption option) {
		menuOptionDao.updateMenuOption(option);
	}

}
