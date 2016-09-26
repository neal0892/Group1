package com.onlineretail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reviews")
public class reviews {

	@Id
	@Column(name="review_id")
	private Integer reviewId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="product_id")
	private Integer productId;

	@Column(name="review")
	private String review;
	
	@Column(name="review_date")
	private String reviewDate;
	
	@Column(name="review_status") 
	private String reviewStatus;

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

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public reviews(Integer reviewId, Integer userId, Integer productId,
			String review, String reviewDate, String reviewStatus) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.productId = productId;
		this.review = review;
		this.reviewDate = reviewDate;
		this.reviewStatus = reviewStatus;
	}

	public reviews() {
			}
	
	


}
