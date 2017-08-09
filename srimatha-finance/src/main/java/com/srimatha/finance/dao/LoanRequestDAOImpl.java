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
import com.srimatha.finance.model.LoanApprovedCustomers;
import com.srimatha.finance.model.LoanRegistration;

@Repository
public class LoanRequestDAOImpl implements LoanRequestDAO{
	@Autowired
	private SessionFactory sessionFactory;
	/*Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();
    Transaction transaction = session.beginTransaction();*/
    
    
	public List<LoanRegistration> getAllLoanRequests() {
		Session session = sessionFactory.getCurrentSession();
//		String hql_select ="from LoanRegistration";
//        Query q = session.createQuery(hql_select);
		Criteria c = session.createCriteria(LoanRegistration.class);
		List<LoanRegistration> list = (List<LoanRegistration>)c.list();
		
		return list;
	}


//	public void addApprovedLoansToDB(
//			LoanApprovedCustomers approvedList, Model model) {
//		Session session = sessionFactory.getCurrentSession();
//		System.out.println("inside daoapproval");
//		System.out.println(approvedList.getLoanAmount());
//			session.save(approvedList);
//			System.out.println("loan might commited");
//			
//	}


	public LoanRegistration getCustomerLoanRequest(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		LoanRegistration loanForm = session.get(LoanRegistration.class, theId);
		System.out.println(loanForm);
		return loanForm;
	}


	public void addLoanRequests(LoanApprovedCustomers approve,LoanRegistration loanRegistration,
			Model model) {
		System.out.println(approve.getSerialNumber());
		System.out.println("saving approved list started in DAo");
		Session session = sessionFactory.getCurrentSession();
		
		session.save(approve);
		int serNum = approve.getSerialNumber();
		System.out.println(approve.getDecision());
		daleteTheSavedRecord(loanRegistration);
		
		
	}

	public void daleteTheSavedRecord(LoanRegistration loanRegistration){
		
		System.out.println(loanRegistration.getSerialNumber());
//		Team team = getTeam(id);
//		String name = team.getName();
//		if(team != null){
//			getCurrentSession().delete(team);
//		}
		Session session = sessionFactory.openSession();
		LoanRegistration lonreg = session.get(LoanRegistration.class, loanRegistration.getSerialNumber());
		session.delete(lonreg);
	}

	

}
