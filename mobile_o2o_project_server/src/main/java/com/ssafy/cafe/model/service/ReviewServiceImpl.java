package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.dao.ReviewDao;
import com.ssafy.cafe.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Override
	public Review getReviewById(Long reviewId) {
		return reviewDao.getReviewById(reviewId);
	}

	@Override
	public List<Review> getReviewByMenuId(Long menuId) {
		return reviewDao.getReviewsByMenuId(menuId);
	}

	@Override
	public void insertReview(Review review) {
		reviewDao.insertReview(review);
	}

	@Override
	public void updateReview(Review review) {
		reviewDao.updateReview(review);
	}

	@Override
	public void deleteReview(Long reviewId) {
		reviewDao.deleteReview(reviewId);
	}

	@Override
	public void deleteAllReviewsByMenuId(Long menuId) {
		reviewDao.deleteAllReviewsByMenuId(menuId);
	}

}
