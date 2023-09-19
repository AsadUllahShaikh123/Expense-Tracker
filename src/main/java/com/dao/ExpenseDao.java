package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Expense;

public class ExpenseDao {

	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	
	public ExpenseDao(SessionFactory factory) {
		this.factory = factory;
	}
	public boolean saveExpense(Expense expense) {
		boolean saved = false;
		try {
		      session = factory.openSession();
		      tx = session.beginTransaction();
		      
		      session.persist(expense);
		      
		      tx.commit();
		      saved = true;
		}catch(Exception e) {
			if(tx!=null) {
				saved =  false;
			}
			e.printStackTrace();
			
		}
		session.close();		
		
		return saved;
		
	}
}
