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
	private SessionFactory factory;
	private Session session=null;
	private Transaction tx=null;

	public ExpenseDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public boolean saveExpense(Expense ex) {
		boolean f= false;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.save(ex);
			tx.commit();
			f=true;
			
		}
		catch(Exception e) {
			if(tx!=null) {
				f=false;
				e.printStackTrace();

			}
			 
		}
		return f;
		
	}
	
	public List<Expense> getAllExpenseByUser(User user){
		
		List<Expense> list=new ArrayList<>();
		try {
			session=factory.openSession();
			Query query=session.createQuery("from Expense where user=:u");
			query.setParameter("u", user);

			list=query.list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Expense getExpenseById(int id) {
		Expense ex=null;
		try {
			session=factory.openSession();
			Query q=session.createQuery("from Expense where id=:id");
			q.setParameter("id", id);
			ex=(Expense)q.uniqueResult();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ex;

	}
	public boolean updateExpense(Expense ex) {
		boolean f= false;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(ex);
			tx.commit();
			f=true;
			
		}
		catch(Exception e) {
			if(tx!=null) {
				f=false;
				e.printStackTrace();

			}
			 
		}
		return f;
		
	}
	public boolean deleteExpense(int id) {
		boolean f=false;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Expense ex=session.get(Expense.class, id);
			session.delete(ex);
			tx.commit();
			f=true;
;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public int totalExpense(int id) {
		int sum=0;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			 String hql = "SELECT SUM(price) FROM Expense where id=:id";
			 Query<Long> query = session.createQuery(hql, Long.class);
		        query.setParameter("id", id);
		        Long result = query.uniqueResult();
		        if (result != null) {
		            sum = result.intValue();
		        }
	           tx.commit();
		}
		catch(Exception e) {
			  if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
		}
		return sum;
	}
	
}
