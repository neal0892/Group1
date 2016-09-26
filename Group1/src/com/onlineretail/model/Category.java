package com.onlineretail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="category")
public class Category {

	@Id
	@Column(name="category_Id")
	private Integer categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="category_disc")
	private String categoryDisc;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDisc() {
		return categoryDisc;
	}

	public void setCategoryDisc(String categoryDisc) {
		this.categoryDisc = categoryDisc;
	}

	public Category(Integer categoryId, String categoryName, String categoryDisc) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDisc = categoryDisc;
	}

	public Category() {
		
	}
	
	
	
	
	
}
