package com.bellinfo.hibernate.inheritance;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class AppSelect {

	
	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();
    Transaction transaction = session.beginTransaction();
    
    Criteria ct = session.createCriteria(Payment.class);
    Criterion cr = Restrictions.eq("paymentId", 4);
   // ct.add(cr);
    
    
}
