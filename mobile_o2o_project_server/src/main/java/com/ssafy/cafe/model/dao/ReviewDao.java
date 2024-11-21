package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.Review;

public interface ReviewDao {

	Review getReviewById(Long reviewId);

	List<Review> getReviewsByMenuId(Long menuId);

	void insertReview(Review review);

	void updateReview(Review review);

	void deleteReview(Long reviewId);

	void deleteAllReviewsByMenuId(Long menuId);

}
