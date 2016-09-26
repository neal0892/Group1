package com.onlineretail.service;

import java.util.List;


import com.onlineretail.model.SubCategory;

public interface SubCategoryService {

	
	boolean isDuplicateSubCategoryId(SubCategory subcategory) throws Exception;

	boolean AddSubCategory(SubCategory cust);

	List<SubCategory> viewSubCategory();

	void delSubCategory(int subcid);



	void updateSubCategory(SubCategory subcat);

}
