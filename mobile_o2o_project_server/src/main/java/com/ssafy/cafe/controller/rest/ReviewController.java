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

@RestController
@RequestMapping("/review")
@CrossOrigin("*")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
		return ResponseEntity.ok(reviewService.getReviewById(reviewId));
	}
	
	@GetMapping("menu/{menuId}")
	public ResponseEntity<List<Review>> getAllReviewsByMenuId(@PathVariable Long menuId) {
		return ResponseEntity.ok(reviewService.getReviewByMenuId(menuId));
	}

	@PostMapping
	public ResponseEntity<Void> insertReview(@RequestBody Review review) {
		reviewService.insertReview(review);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{reviewId}")
	public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
		reviewService.deleteReview(reviewId);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Void> updateReview(@RequestBody Review review) {
		reviewService.updateReview(review);
		return ResponseEntity.ok().build();
	}
}
