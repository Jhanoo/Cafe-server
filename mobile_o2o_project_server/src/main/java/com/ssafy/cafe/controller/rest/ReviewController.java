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

import com.ssafy.cafe.model.dto.Review;
import com.ssafy.cafe.model.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/review")
@CrossOrigin("*")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@GetMapping("/{reviewId}")
	@Operation(summary = "리뷰 조회",
    	description = "reviewId에 해당하는 리뷰 정보를 조회합니다.")
	public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
		return ResponseEntity.ok(reviewService.getReviewById(reviewId));
	}
	
	@GetMapping("menu/{menuId}")
	@Operation(summary = "메뉴별 리뷰 조회",
    	description = "menuId에 해당하는 모든 리뷰 정보를 조회합니다.")
	public ResponseEntity<List<Review>> getAllReviewsByMenuId(@PathVariable Long menuId) {
		return ResponseEntity.ok(reviewService.getReviewByMenuId(menuId));
	}

	@PostMapping
	@Operation(summary = "리뷰 추가",
    	description = "새로운 리뷰 정보를 추가합니다.")
	public ResponseEntity<Void> insertReview(@RequestBody Review review) {
		reviewService.insertReview(review);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{reviewId}")
	@Operation(summary = "리뷰 삭제",
    	description = "reviewId에 해당하는 리뷰 정보를 삭제합니다.")
	public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
		reviewService.deleteReview(reviewId);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	@Operation(summary = "리뷰 업데이트",
    	description = "리뷰 정보를 업데이트합니다.\nrating과 comment만 반영됩니다.")
	public ResponseEntity<Void> updateReview(@RequestBody Review review) {
		reviewService.updateReview(review);
		return ResponseEntity.ok().build();
	}
}
