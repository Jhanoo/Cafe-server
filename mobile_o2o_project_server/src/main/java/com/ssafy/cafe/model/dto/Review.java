package com.ssafy.cafe.model.dto;

import java.util.Date;

public class Review {
	private Long reviewId;
	private Long menuId;
	private Long userId;
	private double rating;
	private String comment;
	private Date createdAt;

	public Review(Long reviewId, Long menuId, Long userId, double rating, String comment, Date createdAt) {
		super();
		this.reviewId = reviewId;
		this.menuId = menuId;
		this.userId = userId;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", menuId=" + menuId + ", userId=" + userId + ", rating=" + rating
				+ ", comment=" + comment + ", createdAt=" + createdAt + "]";
	}

}
