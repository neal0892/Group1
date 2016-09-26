package com.onlineretail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@Column(name="product_Id")
	private Integer productId;
   
	@Column(name="product_Name")
	private String productName;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="price")
	private Integer productPrice;
	
	@Column(name="product_Disc ")
	private String productDescription;
	
	@Column(name="image_Url")
	private String productImageURI;
	
	@Column(name="subcategory_Id")
	private Integer subCategoryId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImageURI() {
		return productImageURI;
	}

	public void setProductImageURI(String productImageURI) {
		this.productImageURI = productImageURI;
	}

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Product(Integer productId, String productName, String manufacturer,
			Integer productPrice, String productDescription,
			String productImageURI, Integer subCategoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productImageURI = productImageURI;
		this.subCategoryId = subCategoryId;
	}

	public Product() {
		}
	
	
	
}
