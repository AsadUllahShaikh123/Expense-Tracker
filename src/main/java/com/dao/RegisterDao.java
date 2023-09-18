package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.User;

public class RegisterDao {

	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	public RegisterDao(SessionFactory factory) {
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
}
