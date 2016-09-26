package com.onlineretail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineretail.dao.ProductDao;
import com.onlineretail.model.Category;
import com.onlineretail.model.Product;
import com.onlineretail.model.SubCategory;
import com.onlineretail.service.ProductService;
import com.onlineretail.service.SubCategoryService;

@Controller
public class ProductController {
	
	@Autowired
	public ProductService productservice;
	
	@Autowired
	public SubCategoryService subcategoryservice;
	
	/*@Autowired
	public ProductDao dao;*/
	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String addProduct(Model model){
		model.addAttribute("prod",new Product());
		List<SubCategory> subcat=subcategoryservice.viewSubCategory();
		List<Integer>  pro=new ArrayList<Integer>();
		for(SubCategory prod:subcat){
			pro.add(prod.getcategoryId());
		}
		model.addAttribute("caid", pro);
		return "addProduct";
		
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public  String addCategory(@ModelAttribute("product") Product prod,BindingResult result,
			Model model)
	{
		
		if(productservice.AddProduct(prod)){
			model.addAttribute("prod", prod);
			model.addAttribute("msg", "Congrats! The product got Added");
			return "msg";
		}else {
			model.addAttribute("msg", "Unable to add Product");
			return "msg";
		}
		
	}
	@RequestMapping(value="/viewProduct",method=RequestMethod.GET)
	public String viewProduct(Model model){
		List<Product> prodList=productservice.viewProduct();
		System.out.println(prodList.get(0).getProductId());
		model.addAttribute("prodList", prodList);
		return "viewProduct";
	}
	
	

	@RequestMapping(value="/updateProduct",method=RequestMethod.GET)
	public String updateProduct1(Model model){
		List<Product>prod=productservice.viewProduct();
		model.addAttribute("prodList", prod);
		return "updateProduct";

}
		@RequestMapping(value="/updateProduct1",method=RequestMethod.POST)
	public String updateProduct(@RequestParam("Id")Integer productId,
			@RequestParam("productName")String productName,
			@RequestParam("manufacturer")String manufacturer,
			@RequestParam("productPrice")Integer productPrice,
			@RequestParam("productDescription")String productDescription,
			@RequestParam("productImageURI")String productImageURI,
			@RequestParam("subCategoryId")Integer subCategoryId,Model model){
		
		Product product=new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setManufacturer(manufacturer);
		product.setProductPrice(productPrice);
		product.setProductDescription(productDescription);
		product.setProductImageURI(productImageURI);
		product.setSubCategoryId(subCategoryId);
		
		productservice.updateProduct(product);
		List<Product>prodList1=productservice.viewProduct();
		model.addAttribute("prodList",prodList1);
		return "updateProduct";
	}


	@RequestMapping(value="/updateDetails2",method=RequestMethod.GET)
	public String updateProduct2(@RequestParam("prodid") Integer productId,
			@RequestParam("subid")Integer subCategoryId,Model model)
	{
		model.addAttribute("prod",new Product());
		
		model.addAttribute("prodid",productId);
		model.addAttribute("subid", subCategoryId);
		return "updateprod";
	}
	
	
	@RequestMapping(value="/deleteProduct1",method=RequestMethod.GET)
	public  String deleteProduct(@RequestParam("productId") Integer productId,Model model){
      
		productservice.deleteProduct(productId);
		model.addAttribute("prodList", productId);
		List<Product> prod=productservice.viewProduct();
		model.addAttribute("prodList", prod);
		return "deleteProduct";
	}
	
		@RequestMapping(value="/deleteProduct",method=RequestMethod.GET)
	public  String deleteProduct1(Model model){
		List<Product> prod=productservice.viewProduct();
		model.addAttribute("prodList", prod);
		return "deleteProduct";
	}

		
		
	
}
