package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.Review;

public interface ReviewService {

	public Review getReviewById(Long reviewId);

	public List<Review> getReviewByMenuId(Long menuId);

	public void insertReview(Review review);

	public void updateReview(Review review);

	public void deleteReview(Long reviewId);
	
	public void deleteAllReviewsByMenuId(Long menuId);
}
