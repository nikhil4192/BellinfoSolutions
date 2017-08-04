package com.srimatha.finance.dao;

import org.springframework.ui.Model;

import com.srimatha.finance.model.LoanRegistration;

public interface LoanRegistrationDAO {
	
	public void addLoanFormToDB(LoanRegistration loanRegistration, Model model);

}
