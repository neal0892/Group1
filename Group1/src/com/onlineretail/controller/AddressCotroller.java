package com.onlineretail.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineretail.model.Address;
import com.onlineretail.model.Category;
import com.onlineretail.model.Order;
import com.onlineretail.model.OrderLine;
import com.onlineretail.model.Product;
import com.onlineretail.service.AddressService;
import com.onlineretail.service.CategoryService;

@Controller
public class AddressCotroller {
	
	
	@Autowired
	public AddressService addressservice;

	@RequestMapping(value="/shipping",method=RequestMethod.GET)
	public  String addAddress(Model model){
		model.addAttribute("order", new Address());
		return "shipping";
	}

	@RequestMapping(value="/placeOrder",method=RequestMethod.POST)
	public  String placeOrder(@ModelAttribute("order")Address address,BindingResult result,
			Model model,HttpSession session) throws ParseException
	{
		Calendar  cal=Calendar.getInstance();
		Long time=cal.getTimeInMillis();
		int oderId=(int) (time%10000);
	//	int quantity=(int) session.getAttribute("quantity");
		int quantity=10;
		//Product prod=(Product) session.getAttribute("product");
		//int user_id=(int) session.getAttribute("userId");
		;
		 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 String strDate = sdf.format(cal.getTime());
		 Date d1=sdf.parse(strDate);
		 int addressId=(int) (time/30000);
		 
		 address.setAddressId(addressId);
		Product prod=cartProduct();
		int user_id=cartuser();
		Order order=new Order();
		order.setUserId(user_id);
		order.setCost(prod.getProductPrice()*quantity);
		order.setOrderDate(d1);
		order.setStatus("processing");
		order.setOrderId(oderId);
		order.setAddressId(addressId);
		
		
		OrderLine oderline=new OrderLine();
		oderline.setOrderId(oderId);
		oderline.setProductId(prod.getProductId());
		oderline.setQuantity(quantity);
		oderline.setAmount(prod.getProductPrice());
		
		
		if(addressservice.addOrder(address,order, oderline))
		{
			return "Payment"; 
		}
		else
		{
		return null; 
		}
		
	}
	
	
	public Product cartProduct()
	{
		Product prod=new Product();
		prod.setProductId(101);
		//prod.setProductImage("/sss/sss");
		prod.setManufacturer("aple");
		prod.setProductName("iphone 6s");
		prod.setProductPrice(50000);
		return prod;
	}
	public int cartuser()
	{
		return 1234;
	}
	
}
