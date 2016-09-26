package com.onlineretail.dao;

import java.util.List;

import com.onlineretail.model.Category;

public interface CategoryDao {

	boolean isDuplicateCategoryId(int categoryId);

	int Save(Category category);
	
	List<Category> viewCategory();
	void delCategory(int cid);
	void updateCategory(Category cat);

}
