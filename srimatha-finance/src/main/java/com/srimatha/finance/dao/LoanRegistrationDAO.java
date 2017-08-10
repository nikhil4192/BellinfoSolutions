package com.srimatha.finance.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

public interface LoanRegistrationDAO {
	
	public void addLoanFormToDB(LoanRegistration loanRegistration, Model model);
	
	public Customer isValidCustomer(int customerid, String firstname, String lastname, String fathername, String phonenumber, Model model);

	public List<LoanRegistration> isValidAmount(int customerid, double amount, Model model);
	
	
}
