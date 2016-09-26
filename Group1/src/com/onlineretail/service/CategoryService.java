package com.onlineretail.service;

import java.util.List;

import com.onlineretail.model.Category;

public interface CategoryService {

	
	boolean isDuplicateCategoryId(Category category) throws Exception;

	boolean AddCategory(Category cust);
   void	updateCategory(Category cust);

	List<Category> viewCategory();

	void delCategory(int cid);

}
