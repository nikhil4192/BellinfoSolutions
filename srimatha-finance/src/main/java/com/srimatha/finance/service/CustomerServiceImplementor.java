package com.srimatha.finance.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;












import com.srimatha.finance.dao.CustomerDAO;
import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanApprovedCustomers;
import com.srimatha.finance.model.LoanRegistration;

@Service
public class CustomerServiceImplementor implements CustomerService {

	@Autowired
	private CustomerDAO thecustomerDAO;
	@Transactional
	public String isValidUser(String username, String password, Model model) {
		System.out.println("isvalid is inside service isvaliduser");
		Customer customer;
		
		customer = (Customer)thecustomerDAO.isValidUser(username, password, model);
		
		//int userName = (Integer.parseInt(username));
		 
			 System.out.println(customer.getCustomerID());
			 System.out.println(customer.getCustomerPswd());
			 System.out.println(username);
			 System.out.println(password);
			 if((username.equals("admin")) && (password.equals("admin"))){
				 //System.out.println((customer.getCustomerID().equals("0")) && (customer.getCustomerPswd().equals("admin")));
				 return "adminHome";
			 }
			 else if((customer.getCustomerUserID().equals(username))&&(customer.getCustomerPswd().equals(password))){
				 System.out.println((customer.getCustomerUserID().equals(username)) &&
						  (customer.getCustomerPswd().equals(password)));
				 
				 return "userHome";
			 }
		 return "customer-login";
	}
	
	@Transactional
	public Customer getCustomer(String username) {
		return thecustomerDAO.getCustomer(username);
	}
	
	@Transactional
	public List<LoanApprovedCustomers> showMeApprovedLoans(String username) {
		List<LoanApprovedCustomers> list = thecustomerDAO.showMeApprovedLoans(username);
		List<LoanApprovedCustomers> userApprovedLoans = new ArrayList<LoanApprovedCustomers>();
		try{
		for(LoanApprovedCustomers l:list){
			if(l.getDecision().equals("Approve")){
				userApprovedLoans.add(l);
			}
		}
		}catch (NullPointerException e) {
			System.out.println("No values in the list");
		}
		
		
		 return userApprovedLoans;
	}

	@Transactional
	public void postRegistrationData(Customer customer, Model model) {
		thecustomerDAO.postRegistrationData(customer, model);
		
	}

	@Transactional
	public Customer getTheUserDetails(String user) {
		Customer cust = thecustomerDAO.getTheUserDetails(user);
		return null;
	}

	@Transactional
	public List<Customer> history(LoanApprovedCustomers loanApprovedCustomers, String user){
		return thecustomerDAO.history(loanApprovedCustomers, user);
	}

	@Transactional
	public List<Customer> approvedRequest(
			LoanApprovedCustomers loanApprovedCustomers, String user) {
		// TODO Auto-generated method stub
		return thecustomerDAO.approvedRequest(loanApprovedCustomers, user);
	}

	@Transactional
	public List<Customer> rejectedRequest(
			LoanApprovedCustomers loanApprovedCustomers, String user) {
		// TODO Auto-generated method stub
		return thecustomerDAO.rejectedRequest(loanApprovedCustomers, user);
	}
	

	
}
