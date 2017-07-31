package com.bellinfo.hibernate.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bellinfo.hibernate.hibernate_classroom_practice1.MobilePhone;

public class AppHqlTest {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        
	        MobilePhone mp = new MobilePhone("iphone","7+", 1000.00, 16);
	 
	        
//	        String hql = "insert into mobilephone(mobilid, brand, model, cost, memory) select mp.getMobileid(),mp.getBrand(),mp.getModel(),mp.getCost(), mp.getMemory(), from mobilephone mp";
//	        Query q = session.createQuery(hql);
//	        int rows = q.executeUpdate();
//	        System.out.println("no. of rows afftected :" + rows);
//	        transaction.commit();
//	        session.close();
	        
	        
	        String hql_select ="from mobilephone where mobileid='4'";
	        Query q = session.createQuery(hql_select);
	        MobilePhone sd = (MobilePhone)q.uniqueResult();
	        System.out.println(sd);
	        session.close();
	}
}
