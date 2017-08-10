package com.srimatha.finance.dao;


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
import org.springframework.web.bind.annotation.ModelAttribute;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

@Repository
public class CustomerDAOImplementor implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
     
	
	
		public Customer isValidUser(String username, String password, Model model) {
			Session session = sessionFactory.getCurrentSession();
			System.out.println(username);
			String hql_select ="from Customer where customerUserID = ?";
	        Query q = session.createQuery(hql_select);
	        q.setParameter(0, username);
			Customer cust = (Customer)q.uniqueResult();
	        System.out.println(cust.getCustomerUserID());
	        return cust;
		}
		

		public Customer getCustomer(String username) {
			Session session = sessionFactory.getCurrentSession();
			String hql_select ="from Customer where customerUserID = ?";
	        Query q = session.createQuery(hql_select);
	        q.setParameter(0, username);
	        Customer c= (Customer)q.uniqueResult();        
	        System.out.println(c.getCustomerUserID());
			return c;
		}


		public List<LoanRegistration> showMeApprovedLoans(String username) {
			
			Session session = sessionFactory.getCurrentSession();
			System.out.println("inside the show me Approval list");
			String hql_select ="from LoanRegistration where customerID = ?";
	        Query q = session.createQuery(hql_select);
	        q.setParameter(0, Integer.parseInt(username));
			 List<LoanRegistration> list = (List<LoanRegistration>)q.list();
			return list;
		}


		public void postRegistrationData(Customer customer, Model model) {
			Session session = sessionFactory.getCurrentSession();
			System.out.println("bye");
			session.save(customer);
			
		}


		public Customer getTheUserDetails(String user) {
			Session session = sessionFactory.getCurrentSession();
			System.out.println(user+"1");
			String hql_select ="from Customer where customerUserID = ?";
	        Query q = session.createQuery(hql_select);
	        q.setParameter(0, user);
	        Customer c= (Customer)q.uniqueResult();        
	        System.out.println(c.getCustomerUserID());
			return c;
		}


		public List<Customer> history(LoanRegistration loanRegistration, String user) {
			Session session = sessionFactory.getCurrentSession();
			Customer cust = getTheUserDetails(user);
			int id = cust.getCustomerID();
			System.out.println("hi");
			String hql_select ="from LoanRegistration where customerID = ?";
	        Query q = session.createQuery(hql_select);
	        q.setParameter(0, id);
			List<Customer> clist = (List<Customer>)q.list(); 
			return clist;
		}


		public List<Customer> approvedRequest(
				LoanRegistration loanRegistration, String user) {
			Session session = sessionFactory.getCurrentSession();
			String q = "Approve";
			Criteria c = session.createCriteria(LoanRegistration.class);
			Criterion cr = Restrictions.eq("status", q);
			c.add(cr);
			List<Customer> clist = (List<Customer>)c.list(); 
			return clist;
		}


		public List<Customer> rejectedRequest(
				LoanRegistration loanRegistration, String user) {
			Session session = sessionFactory.getCurrentSession();
			String q = "Reject";
			Criteria c = session.createCriteria(LoanRegistration.class);
			Criterion cr = Restrictions.eq("status", q);
			c.add(cr);
			List<Customer> clist = (List<Customer>)c.list(); 
			return clist;
		}


		public LoanRegistration getPayment(LoanRegistration loanRegistration, String user) {
			Session session = sessionFactory.getCurrentSession();
			Customer cust = getTheUserDetails(user);
			int q = cust.getCustomerID();
			System.out.println(q);
			Criteria c = session.createCriteria(LoanRegistration.class);
			Criterion cr = Restrictions.eq("customerID", q);
			c.add(cr);
			LoanRegistration loan = (LoanRegistration)c.uniqueResult();
			System.out.println(loan.getCustomerFName());
			return loan;
		}


		public void postPayment(LoanRegistration payment) {
			Session session = sessionFactory.getCurrentSession();
			session.update(payment);
		}


		public List<Customer> getAllCustomer() {
			Session session = sessionFactory.getCurrentSession();
			String hql_select ="from Customer";
	        Query q = session.createQuery(hql_select);
			List<Customer> clist = (List<Customer>)q.list();
			return clist;
		}


		


	
	
	

}
