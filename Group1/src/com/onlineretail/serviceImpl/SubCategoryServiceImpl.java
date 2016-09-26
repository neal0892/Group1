package com.onlineretail.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineretail.dao.SubCategoryDao;
import com.onlineretail.model.SubCategory;
import com.onlineretail.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryDao subcategorydao;

	@Override
	public boolean AddSubCategory(SubCategory subcategory)  {
		if (isDuplicateSubCategoryId(subcategory) == false) {
			
				subcategorydao.Save(subcategory);
				System.out.println("service");
				return true;
		}	else
		{			
			return false;
			
		}
	}

	@Override
	public boolean isDuplicateSubCategoryId(SubCategory subcategory )  {
		boolean status = false;
		 if(subcategorydao.isDuplicateSubCategoryId(subcategory.getsubcategoryId()) == true)
		 {	 
			 status = true;
		 }
		 else
			 status = false;
		 
		 return status;
	}

	@Override
	public List<SubCategory> viewSubCategory() {
		List<SubCategory> subcat=subcategorydao.viewSubCategory();
		return subcat;
	}

	@Override
	public void delSubCategory(int subcid) {
		subcategorydao.delSubCategory(subcid);
	
	}
	@Override
	public void updateSubCategory(SubCategory cust) {
		subcategorydao.updateSubCategory(cust);
	}


}
