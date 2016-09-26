package com.onlineretail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineretail.model.Category;

@Controller
public class homeHandler {

	@RequestMapping(value="category",method=RequestMethod.GET)
	public  String category(){
		//model.addAttribute("cat", new Category());
		return "categoryHome";
	}
	
	@RequestMapping(value="/subcategory",method=RequestMethod.GET)
	public  String subCategory(){
		return "subcategoryHome";
	}
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public  String product(){
		return "productHome";
	}
}
