package com.onlineretail.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.onlineretail.dao.SubCategoryDao;

import com.onlineretail.model.SubCategory;

@Repository
public class JdbcSubCategoryDao implements SubCategoryDao{

	//ApplicationContext ctx = new ClassPathXmlApplicationContext("springhiber.xml");
	
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	@Override
	public boolean isDuplicateSubCategoryId(int subcategoryId) {
		System.out.println(factory);
		Session session = factory.openSession();
		 session.beginTransaction();
		
		 
		 if( session.get(SubCategory.class,subcategoryId)!=null)
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
	public int Save(SubCategory subcategory) {
		try {
			Session session = factory.openSession();
			System.out.println(subcategory.getcategoryId()+"---");
			System.out.println(session);
			session.beginTransaction();
			session.save(subcategory);
			session.getTransaction().commit();
			return 1;
		} catch (HibernateException e) {
	
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<SubCategory> viewSubCategory() {
		List<SubCategory> subcat=new ArrayList<SubCategory>();
		Session session = factory.openSession();
		session.beginTransaction();
		//String find="select * from category";
		Query query = session.createQuery("from SubCategory"); 
		subcat = query.list();
		return subcat;
	}

	@Override
	public void delSubCategory(int subcid) {
		Session session = factory.openSession();
		session.beginTransaction();
		SubCategory subcat=(SubCategory) session.get(SubCategory.class, subcid);
		session.delete(subcat);
		session.getTransaction().commit();
			}
	
	@Override
	public void updateSubCategory(SubCategory subcat) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(subcat);
		session.getTransaction().commit();
		
	}
}
