package com.onlineretail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineretail.model.Category;
import com.onlineretail.service.CategoryService;
import com.onlineretail.serviceImpl.CategoryServiceImpl;

@Controller
public class CategoryController  {
	
	@Autowired
	public CategoryService categoryservice;

	
	

	@RequestMapping(value="/addCategory",method=RequestMethod.GET)
	public  String addCategory(Model model){
		model.addAttribute("cust", new Category());
		return "Add";
	}
	
	@RequestMapping(value="/viewCategory",method=RequestMethod.GET)
	public  String viewCategory(Model model){
		List<Category> cat=categoryservice.viewCategory();
		model.addAttribute("catList", cat);
		return "viewCategory";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public  String delCategory(@RequestParam("cid") Integer catId,Model model){
      
		categoryservice.delCategory(catId);
		model.addAttribute("catList", catId);
		List<Category> cat=categoryservice.viewCategory();
		model.addAttribute("catList", cat);
		return "delCategory";
	}
	
	@RequestMapping(value="/delCategory",method=RequestMethod.GET)
	public  String delCategory1(Model model){
		List<Category> cat=categoryservice.viewCategory();
		model.addAttribute("catList", cat);
		return "delCategory";
	}
	
	@RequestMapping(value="/updateCategory1",method=RequestMethod.POST)
	public  String updateCategory(@RequestParam("Id") Integer catId,
			@RequestParam("Name") String catname,
			@RequestParam("Disc") String catdisc,Model model){
		Category cat=new Category();
		cat.setCategoryId(catId);
		cat.setCategoryDisc(catdisc);
cat.setCategoryName(catname);
			categoryservice.updateCategory(cat);
			List<Category> cat1=categoryservice.viewCategory();
			model.addAttribute("catList", cat1);
			return "updateCategory";
		}
	
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.GET)
	public  String updateCategory1(Model model){
		List<Category> cat=categoryservice.viewCategory();
		model.addAttribute("catList", cat);
		return "updateCategory";
	}
	
	@RequestMapping(value="/updateDetails",method=RequestMethod.GET)
	public  String updateCategory2(@RequestParam("cid") Integer catId,Model model){
		model.addAttribute("cust", new Category());
      
		model.addAttribute("cid", catId);
		return "update";
	}
	

	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public  String addCategory(@ModelAttribute("category") Category cust,BindingResult result,
			Model model)
	{
	
		if(categoryservice.AddCategory(cust)){
			model.addAttribute("cust", cust);
			model.addAttribute("msg", "Category Added");
			return "msg";
		}else {
			model.addAttribute("msg", "Category Not Added");
			return "msg";
		}
		
	}
}
