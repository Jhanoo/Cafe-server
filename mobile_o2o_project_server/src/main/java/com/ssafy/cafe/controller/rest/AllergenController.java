package com.ssafy.cafe.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Allergen;
import com.ssafy.cafe.model.service.AllergenService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/allergen")
@CrossOrigin("*")
public class AllergenController {

	@Autowired
	AllergenService allergenService;

	@GetMapping("/{allergenId}")
	@Operation(summary = "알레르기 유발 성분 조회",
    		description = "allergenId에 해당하는 알레르기 유발 성분 정보를 조회합니다.")
	public ResponseEntity<Allergen> getAllergenById(@PathVariable Long allergenId) {
		return ResponseEntity.ok(allergenService.getAllergen(allergenId));
	}
	
	@GetMapping
	@Operation(summary = "알레르기 유발 성분 전부 조회", 
			description = "모든 알레르기 유발 성분 정보를 조회합니다.")
	public ResponseEntity<List<Allergen>> getAllAllergens() {
		return ResponseEntity.ok(allergenService.getAllAllergens());
	}

	@PostMapping
	@Operation(summary = "알레르기 유발 성분 추가",
    		description = "새로운 알레르기 유발 성분 정보를 추가합니다.")
	public ResponseEntity<Void> insertReview(@RequestBody Allergen allergen) {
		allergenService.insertAllergen(allergen);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{allergenId}")
	@Operation(summary = "알레르기 유발 성분 삭제",
			description = "allergenId에 해당하는 알레르기 유발 성분 정보를 삭제합니다.")
	public ResponseEntity<Void> deleteAllergen(@PathVariable Long allergenId) {
		allergenService.deleteAllergen(allergenId);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	@Operation(summary = "알레르기 유발 성분 업데이트",
    		description = "알레르기 유발 성분 정보를 업데이트합니다.")
	public ResponseEntity<Void> updateAllergen(@RequestBody Allergen allergen) {
		allergenService.updateAllergen(allergen);
		return ResponseEntity.ok().build();
	}
}
