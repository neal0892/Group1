package com.onlineretail.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineretail.dao.ProductDao;
import com.onlineretail.model.Product;

@Repository
public class JdbcProductDao implements ProductDao{

	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory(){
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int saveProduct(Product product) {
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			System.out.println("not found");
			session.save(product);
			session.getTransaction().commit();
			return 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Product> viewProducts() {
		
		List<Product> prodList=new ArrayList<Product>();
		Session session = factory.openSession();
		session.beginTransaction();
		//String find="select * from category";
		Query query = session.createQuery("from Product"); 
		prodList = query.list();
		return prodList;
		
	}
	
	@Override
	public void updateProduct(Product product){
		Session session=factory.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
	}

	
	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		session.beginTransaction();
		Product prod=(Product) session.get(Product.class, productId);
		session.delete(prod);
		session.getTransaction().commit();
			
		
	}

	@Override
	public Product searchByProductName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDuplicateProductName(Integer prodId) {
		// TODO Auto-generated method stub
		System.out.println(factory);
		Session session = factory.openSession();
		 session.beginTransaction();
		
		 
		 if( session.get(Product.class,prodId)!=null)
		 {
			 System.out.println("found");
			 return true;
		 }
		 else
		 {
			 System.out.println("not  found");
		 return false;
		 }
		
	}

	

	@Override
	public Product viewProduct(int productId) {
		Session session = factory.openSession();
		Product prod=(Product) session.get(Product.class, productId);
		return prod;
	}




}
