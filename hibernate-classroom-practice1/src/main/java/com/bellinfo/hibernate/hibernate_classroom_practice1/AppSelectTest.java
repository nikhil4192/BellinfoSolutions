package com.bellinfo.hibernate.hibernate_classroom_practice1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppSelectTest {

	public static void main(String[] args) {
		
		 	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();

	        MobilePhone mp = (MobilePhone)session.get(MobilePhone.class, 10);
	        System.out.println(mp.getBrand());
	        
	        //System.out.println(mp.getBrand());
	        
	        session.close();
	        sf.close();
	}

}
