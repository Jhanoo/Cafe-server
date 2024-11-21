package com.ssafy.cafe.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Allergen;
import com.ssafy.cafe.model.dto.Menu;
import com.ssafy.cafe.model.dto.MenuOption;
import com.ssafy.cafe.model.service.AllergenService;
import com.ssafy.cafe.model.service.MenuOptionService;
import com.ssafy.cafe.model.service.MenuService;
import com.ssafy.cafe.model.service.ReviewService;
import com.ssafy.cafe.model.service.ShoppingCartService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {

	@Autowired
	MenuService menuService;

	@Autowired
	ReviewService reviewService;

	@Autowired
	MenuOptionService menuOptionService;

	@Autowired
	ShoppingCartService cartService;

	@Autowired
	AllergenService allergenService;

	@GetMapping
	@Operation(summary = "모든 메뉴 조회",
    		description = "모든 메뉴 정보를 조회합니다.")
	public ResponseEntity<List<Menu>> getAllMenus() {
		List<Menu> menus = menuService.getAllMenus();
		
		for(Menu menu : menus) {
			menu.setAverageRating(menuService.getMenuAverageRating(menu.getMenuId()));
		}
		
		return ResponseEntity.ok(menus);
	}

	@GetMapping("/{menuId}")
	@Operation(summary = "메뉴 조회",
    		description = "menuId에 해당하는 메뉴 정보를 반환합니다.")
	public ResponseEntity<Menu> getMenuById(@PathVariable Long menuId) {
		Menu menu = menuService.getMenuById(menuId);
		
		if(menu != null)
			menu.setAverageRating(menuService.getMenuAverageRating(menuId));
		
		return ResponseEntity.ok(menu);
	}

	@PostMapping
	@Operation(summary = "메뉴 추가",
    		description = "새로운 메뉴를 추가하고 해당 메뉴에 대한 옵션과 알러젠 정보를 설정합니다.")
	public ResponseEntity<Void> insertMenu(@RequestBody Menu menu) {
		menuService.insertMenu(menu);
		for (MenuOption option : menu.getOptions()) {
			menuOptionService.insertMenuOption(option);
		}
		for (Allergen allergen : menu.getAllergens()) {
			allergenService.insertAllergenToMenu(menu.getMenuId(), allergen.getAllergenId());
		}
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{menuId}")
	@Operation(summary = "메뉴 삭제",
    		description = "menuId에 해당하는 메뉴 정보를 삭제합니다.")
	public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId) {
//		reviewService.deleteAllReviewsByMenuId(menuId);
//		menuOptionService.deleteMenuOption(menuId);
//		allergenService.deleteAllergenMappingByMenuId(menuId);
		menuService.deleteMenu(menuId);
		
		return ResponseEntity.ok().build();
	}
}
