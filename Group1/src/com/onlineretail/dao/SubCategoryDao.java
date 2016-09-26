package com.onlineretail.dao;

import java.util.List;


import com.onlineretail.model.SubCategory;


public interface SubCategoryDao {
	
	int Save(SubCategory subcategory);
	void delSubCategory(int subcid);
	boolean isDuplicateSubCategoryId(int subcategoryId);

	List<SubCategory> viewSubCategory();
	void updateSubCategory(SubCategory subcat);

}