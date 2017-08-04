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
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

@Repository
public class CustomerDAOImplementor implements CustomerDAO {
	
	 Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     Transaction transaction = session.beginTransaction();
     
     
		public Customer getCustomer(String username, String password, Model model) {
			System.out.println("isvalid is inside DAO isvaliduser");
			String hql_select ="from Customer where customerID = ?";
	        Query q = session.createQuery(hql_select);
	        q.setParameter(0, username);
//	        @SuppressWarnings("unchecked")
	        Customer c;
	        
			c = (Customer)q.uniqueResult();
	        
	        System.out.println("query executed");
//	        for(Customer cust:c){
//			//System.out.println(customer.getCustomerID());
//			//Customer cust = (Customer) session.get(Customer.class, customer.getCustomerID());
//	        if( ((Integer)cust.getCustomerID() == customer.getCustomerID()) &&
//	        		((cust.getCustomerPswd()).equals(customer.getCustomerPswd()))){
//	        	String text = "Welcome to the portal " +cust.getCustomerFName();
//	        	model.addAttribute("message", text);  
//	        	return true;
//	        	
//	        }    
//	        }
			//int userName = (Integer.parseInt(username));
//			Criteria c = session.createCriteria(Customer.class);
//			Criterion cr  = Restrictions.eq("customerid", username);
//			Criterion cr1  = Restrictions.eq("password", password);
//			c.add(cr);
//			c.add(cr1);
//			Customer cust =(Customer)c.uniqueResult();
			//List list = c.list();
	        return c;
		}


	
	
	

}
