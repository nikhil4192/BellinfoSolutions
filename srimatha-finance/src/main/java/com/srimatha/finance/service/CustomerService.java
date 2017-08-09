package com.srimatha.finance.service;


import java.util.List;

import org.springframework.ui.Model;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanApprovedCustomers;
import com.srimatha.finance.model.LoanRegistration;

public interface CustomerService {

	public String isValidUser(String username,String password, Model model);

	public Customer getCustomer(String username);

	public List<LoanApprovedCustomers> showMeApprovedLoans(String username);

	public void postRegistrationData(Customer customer, Model model);
	
	public Customer getTheUserDetails(String user);

	public List<Customer> history(LoanApprovedCustomers loanApprovedCustomers, String user);

	public List<Customer> approvedRequest(
			LoanApprovedCustomers loanApprovedCustomers, String user);

	public List<Customer> rejectedRequest(
			LoanApprovedCustomers loanApprovedCustomers, String user);
}
