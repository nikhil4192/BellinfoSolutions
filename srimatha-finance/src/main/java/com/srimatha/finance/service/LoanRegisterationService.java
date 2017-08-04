package com.srimatha.finance.service;

import org.springframework.ui.Model;

import com.srimatha.finance.model.LoanRegistration;

public interface LoanRegisterationService {
	
	public void addLoanFormTODAO(LoanRegistration loanRegistration, Model model);

}
