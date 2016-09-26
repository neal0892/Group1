package com.onlineretail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class SubCategory {

	@Id
	@Column(name="subcategory_Id")
	private Integer subcategoryId;
	
	@Column(name="subcategory_Name")
	private String subcategoryName;
	
	@Column(name="subcategory_Disc")
	private String subcategoryDisc;
	
	@Column(name="category_Id")
	private Integer categoryId;

	public Integer getsubcategoryId() {
		return subcategoryId;
	}

	public void setsubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getsubcategoryName() {
		return subcategoryName;
	}

	public void setsubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getsubcategoryDisc() {
		return subcategoryDisc;
	}

	public void setsubcategoryDisc(String subcategoryDisc) {
		this.subcategoryDisc = subcategoryDisc;
	}

	public Integer getcategoryId() {
		return categoryId;
	}

	public void setcategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	
}