package com.srimatha.finance.dao;

import java.util.List;

import org.hibernate.Query;
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

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<LoanRegistration> isValidAmount(int customerid, double amount, Model model) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("goinf to database");
		
		String hql_select ="from LoanRegistration";
		Query q = session.createQuery(hql_select); 
        List<LoanRegistration> cust  = (List<LoanRegistration>)q.list();
		return cust;
		
	}
	
	public Customer isValidCustomer(int customerid, String firstname, String lastname, String fathername, String phonenumber, Model model) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("goinf to database");
		String hql_select ="from Customer where customerID = ?";
        Query q = session.createQuery(hql_select);
        q.setParameter(0, customerid);
		Customer cust = (Customer)q.uniqueResult();
       
		System.out.println(cust.getCustomerID() + " " + cust.getCustomerFName() + " " +cust.getCustomerLName());
		System.out.println(cust.getCustomerFatherOrHusbandName() + " " + cust.getCustomerPhone()+ " " +cust.getCustomerLName());
        return cust;
	}
	
	public void addLoanFormToDB(LoanRegistration loanRegistration, Model model) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("inside addloan method");
		session.save(loanRegistration);
		System.out.println("loan might commited");
		//session.evict(loanRegistration);
		
	}

	
    
    
}
