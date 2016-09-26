package com.onlineretail.dao;

import com.onlineretail.model.Address;
import com.onlineretail.model.Order;
import com.onlineretail.model.OrderLine;
import com.onlineretail.model.Product;

public interface AddressDao {

	
	boolean addOrder(Address address, Order order, OrderLine oderline);

}
