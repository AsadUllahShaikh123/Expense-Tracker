package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Expense;
import com.entity.User;


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
	public List<Expense> getAllExpensesByUser(User user){
		List<Expense> expenses = new ArrayList<Expense>();;
		
		session = factory.openSession();
		Query<Expense> query = session.createQuery("from Expense where user=:user");
		query.setParameter("user",user);
		expenses = query.list();		
		
		return expenses;
	}
	
	public void editExpense(Expense expense) {
		
	}
	public Expense getExpenseById(int id) {
		Expense expense = null;
		
		session =factory.openSession();
		
		expense = session.get(Expense.class, id);
		
		return expense;
	}
	
	public boolean updateExpense(Expense expense) {
		boolean saved = false;
		try {
		      session = factory.openSession();
		      tx = session.beginTransaction();
		      Expense expense1 = session.get(Expense.class, expense.getId());
		      expense1.setTitle(expense.getTitle());
		      expense1.setDescription(expense.getDescription());
		      expense1.setDate(expense.getDate());
		      expense1.setTime(expense.getTime());
		      expense1.setPrice(expense.getPrice());
		      expense1.setUser(expense.getUser());
		      session.update(expense1);
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
	
	public boolean deleteExpense(int id) {
		boolean deleted = false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Expense expense = session.get(Expense.class, id);
			session.remove(expense);
			tx.commit();
			deleted = true;
		}catch(Exception e) {
			if(tx!=null) {
				deleted = false;
			}
		}
		
		return deleted;
	}
	
	
	
	
	
}
