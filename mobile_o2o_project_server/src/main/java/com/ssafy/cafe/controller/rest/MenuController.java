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

import com.ssafy.cafe.model.dto.Menu;
import com.ssafy.cafe.model.service.MenuService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {
	@Autowired
	MenuService menuService;

	@GetMapping
	public ResponseEntity<List<Menu>> getAllMenus() {
		return ResponseEntity.ok(menuService.getAllMenus());
	}

	@GetMapping("/{menuId}")
	@Operation(summary = "{menuId}에 해당하는 상품의 정보를 반환한다.")
	public ResponseEntity<Menu> getMenuById(@PathVariable Long menuId) {
		return ResponseEntity.ok(menuService.getMenuById(menuId));
	}

	@PostMapping
	public ResponseEntity<Void> insertMenu(@RequestBody Menu menu) {
		menuService.insertMenu(menu);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{menuId}")
	public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId) {
		menuService.deleteMenu(menuId);
		return ResponseEntity.ok().build();
	}
}
