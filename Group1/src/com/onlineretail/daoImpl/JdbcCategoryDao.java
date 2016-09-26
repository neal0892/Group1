package com.onlineretail.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.onlineretail.dao.CategoryDao;
import com.onlineretail.model.Category;

@Repository
public class JdbcCategoryDao implements CategoryDao{

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
	public boolean isDuplicateCategoryId(int categoryId) {
		System.out.println(factory);
		Session session = factory.openSession();
		 session.beginTransaction();
		
		 
		 if( session.get(Category.class,categoryId)!=null)
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
	public int Save(Category category) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		return 1;
	}

	@Override
	public List<Category> viewCategory() {
		List<Category> cat=new ArrayList<Category>();
		Session session = factory.openSession();
		session.beginTransaction();
		//String find="select * from category";
		Query query = session.createQuery("from Category"); 
		cat = query.list();
		return cat;
	}

	@Override
	public void delCategory(int cid) {
		Session session = factory.openSession();
		session.beginTransaction();
		Category cat=(Category) session.get(Category.class, cid);
		session.delete(cat);
		session.getTransaction().commit();
			}

	@Override
	public void updateCategory(Category cat) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(cat);
		session.getTransaction().commit();
		
	}

}
