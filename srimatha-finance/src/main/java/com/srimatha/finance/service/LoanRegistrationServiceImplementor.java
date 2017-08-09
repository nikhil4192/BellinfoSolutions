package com.srimatha.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.srimatha.finance.dao.LoanRegistrationDAO;
import com.srimatha.finance.model.LoanRegistration;

@Service
public class LoanRegistrationServiceImplementor implements LoanRegisterationService{

	@Autowired
	private LoanRegistrationDAO theLoanRegistrationDAO;
	
	@Transactional
	public void addLoanFormTODAO(LoanRegistration loanRegistration, Model model) {
		System.out.println("isvalid is inside service addLoanFoarm");
		theLoanRegistrationDAO.addLoanFormToDB(loanRegistration, model);
		
	}

}
