package com.onlineretail.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineretail.daoImpl.JdbcCategoryDao;
import com.onlineretail.dao.CategoryDao;
import com.onlineretail.model.Category;
import com.onlineretail.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categorydao;

	@Override
	public boolean AddCategory(Category category)  {
		if (isDuplicateCategoryId(category) == false) {
				categorydao.Save(category);
				return true;
		}	else
		{			
			return false;
			
		}
	}

	@Override
	public boolean isDuplicateCategoryId(Category category )  {
		boolean status = false;
		 if(categorydao.isDuplicateCategoryId(category.getCategoryId()) == true)
		 {	 
			 status = true;
		 }
		 else
			 status = false;
		 
		 return status;
	}

	@Override
	public List<Category> viewCategory() {
		List<Category> cat=categorydao.viewCategory();
		return cat;
	}

	@Override
	public void delCategory(int cid) {
		categorydao.delCategory(cid);
	
	}

	@Override
	public void updateCategory(Category cust) {
		categorydao.updateCategory(cust);
	}

}
