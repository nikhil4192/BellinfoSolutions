package com.srimatha.finance.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;
import com.srimatha.finance.service.LoanRegisterationService;

@Repository
public class LoanRegisterationDAOImplementor implements LoanRegistrationDAO{

	/*Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();
    Transaction transaction = session.beginTransaction();*/
	@Autowired
	private SessionFactory sessionFactory;

	
	public void addLoanFormToDB(LoanRegistration loanRegistration, Model model) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("inside addloan method");
		session.save(loanRegistration);
		System.out.println("loan might commited");
		//session.evict(loanRegistration);
		
	}
    
    
}
