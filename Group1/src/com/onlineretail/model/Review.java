package com.onlineretail.model;

public class Review {
	private Integer reviewId;
	private Integer userId;
	private Integer productId;
	private String review;
	private String date;
	private String status;
	private String rating;
	
	public Review(){}

	public Review(Integer reviewId, Integer userId, Integer productId,
			String review, String date, String status, String rating) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.productId = productId;
		this.review = review;
		this.date = date;
		this.status = status;
		this.rating = rating;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
