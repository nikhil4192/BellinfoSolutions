package com.srimatha.finance.service;


import java.text.ParseException;
import java.util.List;

import org.springframework.ui.Model;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

public interface CustomerService {

	public String isValidUser(String username,String password, Model model);

	
	
	public Customer getCustomer(String username);

	public List<LoanRegistration> showMeApprovedLoans(String username);

	public void postRegistrationData(Customer customer, Model model);
	
	public Customer getTheUserDetails(String user);

	public List<Customer> history(LoanRegistration loanRegistration, String user);

	public List<Customer> approvedRequest(
			LoanRegistration loanRegistration, String user);

	public List<Customer> rejectedRequest(
			LoanRegistration loanRegistration, String user);

	public LoanRegistration getPayment(LoanRegistration loanRegistration, String user) throws ParseException;

	public void postPayment(LoanRegistration payment, String user);
}
