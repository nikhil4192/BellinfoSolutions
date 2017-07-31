package com.bellinfo.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppTest {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        
	        CreditCardPayment ccp = new CreditCardPayment(1,"500","123654789","123");
	        CreditCardPayment ccp1 = new CreditCardPayment(1,"200","185255554","159");
	        CreditCardPayment ccp2 = new CreditCardPayment(1,"900","129898289","183");
	        CreditCardPayment ccp3 = new CreditCardPayment(1,"400","619879789","263");
	        
	        ChequePayment chq1 = new ChequePayment(1,"1500","165113","Nikhil");
	        ChequePayment chq2 = new ChequePayment(1,"2500","5451564","Vemula");
	        ChequePayment chq3 = new ChequePayment(1,"1800","56465654","Ashish");
	        ChequePayment chq4 = new ChequePayment(1,"3000","65656","Ravi");
	        
	        session.save(ccp);
	        session.save(ccp1);
	        session.save(ccp2);
	        session.save(ccp3);
	        
	        session.save(chq1);
	        session.save(chq2);
	        session.save(chq3);
	        session.save(chq4);
	        
	        transaction.commit();
	        
	        session.close();
	        
	        sf.close();
	}

}
