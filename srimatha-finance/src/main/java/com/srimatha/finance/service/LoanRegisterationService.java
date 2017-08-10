package com.srimatha.finance.service;

import org.springframework.ui.Model;

import com.srimatha.finance.model.LoanRegistration;

public interface LoanRegisterationService {
	
	public void addLoanFormTODAO(LoanRegistration loanRegistration, Model model);
	
	public boolean isValidCustomer(int customerid, String firstname, String lastname, String fathername, String phonenumber, Model model);

	public boolean isValidAmount(int customerid, double amount, Model model);
}
