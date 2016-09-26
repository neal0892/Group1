package com.onlineretail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


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


import com.onlineretail.model.SubCategory;

import com.onlineretail.service.SubCategoryService;


@Controller
public class SubCategoryController  {
	
	@Autowired
	public SubCategoryService subcategoryservice;
	
	@RequestMapping (value="/addSubCategory",method=RequestMethod.GET)
	public  String addSubCategory(Model model){
		model.addAttribute("cust", new SubCategory());
		return "AddSubCategory";
	}

	@RequestMapping(value="/viewSubCategory",method=RequestMethod.GET)
	public  String viewSubCategory(Model model){
		List<SubCategory> subcat=subcategoryservice.viewSubCategory();
		model.addAttribute("subcatList", subcat);
		return "viewSubCategory";
	}
	
	@RequestMapping(value="/delete1",method=RequestMethod.GET)
	public  String delSubCategory1(@RequestParam("subcid") Integer subcatId,Model model){
      
		System.out.println(subcatId);
		subcategoryservice.delSubCategory(subcatId);
		model.addAttribute("subcatList", subcatId);
		List<SubCategory> subcat=subcategoryservice.viewSubCategory();
		model.addAttribute("subcatList", subcat);
		return "delSubCategory";
	}
	
	@RequestMapping(value="/delSubCategory",method=RequestMethod.GET)
	public  String delSubCategory(Model model){
		List<SubCategory> subcat=subcategoryservice.viewSubCategory();
		model.addAttribute("subcatList", subcat);
		return "delSubCategory";
	}
	
	@RequestMapping(value="/addSubCategory",method=RequestMethod.POST)
	public  String addSubCategory(@ModelAttribute("cust") SubCategory cust,BindingResult result,
			Model model)
	{
		
		if(subcategoryservice.AddSubCategory(cust)){
			model.addAttribute("cust", cust);
			model.addAttribute("msg", "Subcategory Added successfully");
			System.out.println("cont true");
			return "msg";
		}else {
			model.addAttribute("msg", "Registration Unsuccessful");
			System.out.println("cont false");
			return "msg";
		}
		
	}

	@RequestMapping(value="/updateSubCategory1",method=RequestMethod.POST)
	public  String updateSubCategory(@RequestParam("Id") Integer subcatId,
			@RequestParam("Name") String subcatname,
			@RequestParam("Disc") String subcatdisc,@RequestParam("catid") Integer categoryId
			,Model model){
		SubCategory subcat=new SubCategory();
		subcat.setsubcategoryId(subcatId);
		subcat.setsubcategoryDisc(subcatdisc);
		subcat.setsubcategoryName(subcatname);
		subcat.setcategoryId(categoryId);
			subcategoryservice.updateSubCategory(subcat);
			List<SubCategory> subcat1=subcategoryservice.viewSubCategory();
			model.addAttribute("subcatList", subcat1);
			return "updateSubCategory";
		}
	
	
	@RequestMapping(value="/updateSubCategory",method=RequestMethod.GET)
	public  String updateSubCategory1(Model model){
		List<SubCategory> subcat=subcategoryservice.viewSubCategory();
		model.addAttribute("subcatList", subcat);
		return "updateSubCategory";
	}
	
	@RequestMapping(value="/updateDetails1",method=RequestMethod.GET)
	public  String updateSubCategory2(@RequestParam("subcid") Integer subcatId,@RequestParam("cid") Integer catId,Model model){
		model.addAttribute("cust", new SubCategory());
      
		model.addAttribute("subcid", subcatId);
		model.addAttribute("cid", catId);
		
		return "updatesub";
	}
	
}
