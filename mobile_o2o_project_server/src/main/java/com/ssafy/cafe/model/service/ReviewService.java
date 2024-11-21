package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.Review;

public interface ReviewService {

	Review getReviewById(Long reviewId);

	List<Review> getReviewByMenuId(Long menuId);

	void insertReview(Review review);

	void updateReview(Review review);

	void deleteReview(Long reviewId);
	
	void deleteAllReviewsByMenuId(Long menuId);
}
