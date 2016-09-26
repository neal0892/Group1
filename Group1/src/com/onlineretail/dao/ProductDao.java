package com.onlineretail.dao;

import java.util.List;

import com.onlineretail.model.Product;

public interface ProductDao {
	int saveProduct(Product product);

	List<Product> viewProducts();

	void deleteProduct(int productId);

	Product searchByProductName(String productName);

	public Product viewProduct(int productId);

	boolean isDuplicateProductName(Integer prodId);

	void updateProduct(Product product);


}
