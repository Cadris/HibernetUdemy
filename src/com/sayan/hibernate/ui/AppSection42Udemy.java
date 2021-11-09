package com.sayan.hibernate.ui;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.hibernate.entities.books;
import com.sayan.utilities.NoDataException;

public class AppSection42Udemy {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(books.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Scanner sc = new Scanner(System.in);
		
		AppSection42Udemy app = new AppSection42Udemy();
		
		try {
			
			//add a row to the database
			//addRow(session);
			
			//getting data from a table using id
			
			System.out.print("Enter Id : ");
			int id = sc.nextInt();
//			app.getData(session,id);
			System.out.println("Updating...\n");
			app.update(session, 8);
			System.out.println("Updating Successful\nDisplaying Data Again...\n");
			app.getData(session,8);
			
//			System.out.println("Deleting...");
//			app.delete(session, 8);			
			
		} catch(Exception e) {
			System.out.println("Catch Block");
			e.printStackTrace();
		} finally {
			System.out.println("Finally Block");
			sc.close();
			session.close();
			factory.close();
		}
	}
	
	public void delete(Session session, int id) throws Exception{
		//Create Book Object
		books obj = new books();
		
		//Start Transactions
		session.beginTransaction();	
		
		//Perform Operations
		obj = session.get(books.class, id); 
		if(obj==null) throw new NoDataException("No SQL Data returned");
		session.delete(obj);
		
		//Commit Changes
		session.getTransaction().commit();
		
		System.out.println("Data : "+obj);
	}
	
	public void update(Session session, int id) throws Exception{
		//Create Book Object
		books obj = new books();
		
		//Start Transactions
		session.beginTransaction();	
		
		//Perform Operations
		obj = session.get(books.class, id); 
		if(obj==null) throw new NoDataException("No SQL Data returned");
		obj.setTitle("test8Updated");
		
		//Commit Changes
		session.getTransaction().commit();
		
		System.out.println("Data : "+obj);
	}
	
	public void getData(Session session, int id) throws Exception {
		//Create Book Object
		books obj = new books();
		
		//Start Transactions
		session.beginTransaction();
		obj = session.get(books.class, id);
		if(obj==null) throw new NoDataException("No SQL Data returned");
		//Perform Operations
		
		//Commit Changes
		session.getTransaction().commit();
		
		System.out.println("Data : "+obj);
	}
	
	public void addRow(Session session)throws Exception {
		//Create Book Object
		books obj = new books("test4", 423, 67678);
		
		//Start Transactions
		session.beginTransaction();
		
		//Perform Operations
		session.save(obj);
		
		//Commit Changes
		session.getTransaction().commit();
		
		System.out.println("Row Added and Commited :: "+obj);
	}

}
