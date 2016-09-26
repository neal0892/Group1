package com.onlineretail.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineretail.dao.AddressDao;
import com.onlineretail.dao.CategoryDao;
import com.onlineretail.model.Address;
import com.onlineretail.model.Order;
import com.onlineretail.model.OrderLine;
import com.onlineretail.model.Product;
import com.onlineretail.service.AddressService;

@Service
public  class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressdao;

	




	@Override
	public boolean addOrder(Address address, Order order, OrderLine oderline) {
		return addressdao.addOrder(address,order,oderline);		
		
	}

	
}
