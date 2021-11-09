package com.sayan.hibernate.ui;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.hibernate.entities.books;

public class AppSection43Udemy {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(books.class)
						.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Scanner sc = new Scanner(System.in);
		
		AppSection43Udemy app = new AppSection43Udemy();
		try {
			//Begin Transactions
			session.beginTransaction();
			
			List<books> resultList = session.createQuery("from books where title like 'N%'").getResultList();
			
			System.out.println();
			for (books book : resultList) {
				System.out.println(book);
			}
			
			//End Transaction and Commit
			//session.getTransaction().commit();
			
		} catch(Exception e) {
			System.out.println("Inside Catch Block");
			e.printStackTrace();
		} finally {
			sc.close();
			session.close();
			factory.close();
		}
	}

}
