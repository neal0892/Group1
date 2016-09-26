package com.onlineretail.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineretail.dao.AddressDao;
import com.onlineretail.model.Address;
import com.onlineretail.model.Order;
import com.onlineretail.model.OrderLine;
import com.onlineretail.model.Product;

@Repository
public class JdbcAddressDao implements AddressDao{

	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	
	

	@Override
	public boolean addOrder(Address address, Order order, OrderLine oderline) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(address);
		session.save(order);
		session.save(oderline);
		session.getTransaction().commit();
		return true;
		}

	
	
	
}
