package com.onlineretail.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineretail.dao.ProductDao;
import com.onlineretail.model.Product;
import com.onlineretail.service.ProductService;

	@Service
	public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productdao;
	
	@Override
	public boolean AddProduct(Product product)  {
/*		if (isDuplicateProductName(product) == false) {
				productdao.saveProduct(product);
				return true;
		}	else
		{			
			return false;
			
		}
*/		
		if(productdao.saveProduct(product) == 1){
			return true;
		}else{
			return false;
		}
	}

	private boolean isDuplicateProductName(Product product) {
		boolean status = false;
		 if(productdao.isDuplicateProductName(product.getProductId()) == true)
		 {	 
			 status = true;
		 }
		 else
			 status = false;
		 
		 return status;
	}

	
	public List<Product> viewProduct() {
		List<Product> prodList=productdao.viewProducts();
		return prodList;
	}

	public void deleteProduct(int productId) {
		productdao.deleteProduct(productId);
	
	}
	
	@Override
	public void updateProduct(Product product) {
		productdao.updateProduct(product);
	}
	
	@Override
	public boolean isDuplicateProductName(String productName) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> searchByProductName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
