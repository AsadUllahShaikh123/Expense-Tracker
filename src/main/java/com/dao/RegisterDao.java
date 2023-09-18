package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.User;

public class RegisterDao {

	SessionFactory factory;
	public RegisterDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	public void registerUser(User user) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
}
