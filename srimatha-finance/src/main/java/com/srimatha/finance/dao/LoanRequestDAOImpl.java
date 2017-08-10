package com.srimatha.finance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

@Repository
public class LoanRequestDAOImpl implements LoanRequestDAO{
	@Autowired
	private SessionFactory sessionFactory;
	 
	public List<LoanRegistration> getAllLoanRequests() {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(LoanRegistration.class);
		Criterion cr = Restrictions.isNull("status");
		List<LoanRegistration> list = (List<LoanRegistration>)c.list();
		
		return list;
	}


	public LoanRegistration getCustomerLoanRequest(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		LoanRegistration loanForm = session.get(LoanRegistration.class, theId);
		System.out.println(loanForm);
		return loanForm;
	}


	public void addLoanRequests(LoanRegistration approve,
			Model model) {
		System.out.println(approve.getSerialNumber());
		System.out.println("saving approved list started in DAo");
		Session session = sessionFactory.getCurrentSession();
		
		session.update(approve);
		int serNum = approve.getSerialNumber();
		
		
	}

}
