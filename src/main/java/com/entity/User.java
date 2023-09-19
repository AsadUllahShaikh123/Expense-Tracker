package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	List<Expense> expense;
	public User() {
		
	}
	public User(String name, String email, String password, String about) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	public User(int id, String name, String email, String password, String about) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	public List<Expense> getExpense(){
		return expense;
	}
	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
	
}
