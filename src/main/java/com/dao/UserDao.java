package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;

public class UserDao {

	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	public UserDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	public boolean registerUser(User user) {
		boolean inserted = false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(user);
			tx.commit();
			session.close();
			inserted = true;
		}catch(Exception ex) {
			if(tx !=null) {
				inserted = false;
				ex.printStackTrace();
			}
		}
				
		return inserted;
	}
	
	public User userLogin(String email, String password) {
		session = factory.openSession();
		User user = null;
		Query<User> query = session.createQuery("from User where email=:em and password =:ps");
		query.setParameter("em",email);
		query.setParameter("ps", password);
		user = query.uniqueResult();
		session.close();
		return user;
	}
}
