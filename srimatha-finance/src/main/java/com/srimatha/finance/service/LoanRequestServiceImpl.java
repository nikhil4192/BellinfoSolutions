package com.srimatha.finance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.srimatha.finance.dao.LoanRequestDAO;
import com.srimatha.finance.model.LoanApprovedCustomers;
import com.srimatha.finance.model.LoanRegistration;

@Service
public class LoanRequestServiceImpl implements LoanRequestService{

	@Autowired
	private LoanRequestDAO theLoanRequestDAO;
	@Transactional
	public List<LoanRegistration> getAllLoanRequests() {
		
		return theLoanRequestDAO.getAllLoanRequests();
	}

//	@Transactional
//	public void addApprovedLoansToDB(
//			ArrayList<LoanApprovedCustomers> approvedList, Model model) {
//		System.out.println("hello form service");
//		for(LoanApprovedCustomers loan: approvedList){
//			theLoanRequestDAO.addApprovedLoansToDB(loan,model);
//		}		
//	}

	@Transactional
	public LoanRegistration getCustomerLoanRequest(int theId) {
		return theLoanRequestDAO.getCustomerLoanRequest(theId);
	}

	@Transactional
	public void addLoanRequests(LoanApprovedCustomers approve,LoanRegistration loanRegistration,
			Model model) {
		// TODO Auto-generated method stub
		System.out.println("saving approved list started in service");
		 theLoanRequestDAO.addLoanRequests(approve,loanRegistration, model);
	}

	

}
