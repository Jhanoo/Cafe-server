package com.ssafy.cafe.model.dto;

import java.util.Date;

public class Review {
	private Long reviewId;
	private Long menuId;
	private Long userId;
	private double rating;
	private String comment;
	private Date createdAt;
	private String name;
	private String image;

	public Review(Long reviewId, Long menuId, Long userId, double rating, String comment, Date createdAt,
			String name, String image) {
		super();
		this.reviewId = reviewId;
		this.menuId = menuId;
		this.userId = userId;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
		this.name = name;
		this.image = image;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", menuId=" + menuId + ", userId=" + userId + ", rating=" + rating
				+ ", comment=" + comment + ", createdAt=" + createdAt + ", name=" + name + ", image=" + image + "]";
	}

}
