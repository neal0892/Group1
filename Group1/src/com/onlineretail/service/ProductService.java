package com.onlineretail.service;

import java.util.List;


import com.onlineretail.model.Product;

public interface ProductService{

	boolean isDuplicateProductName(String productName) throws Exception;
	
	boolean AddProduct(Product prod);
	
	List<Product> viewProduct();
	
	List<Product> searchByProductName(String productName);

	void deleteProduct(int productId);
	void updateProduct(Product prod);
}
