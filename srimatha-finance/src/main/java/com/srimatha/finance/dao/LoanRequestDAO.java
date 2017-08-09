package com.srimatha.finance.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.srimatha.finance.model.LoanApprovedCustomers;
import com.srimatha.finance.model.LoanRegistration;

public interface LoanRequestDAO {

	public List<LoanRegistration> getAllLoanRequests();

//	public void addApprovedLoansToDB(
//			LoanApprovedCustomers approvedList, Model model);

	public LoanRegistration getCustomerLoanRequest(int theId);

	public void addLoanRequests(LoanApprovedCustomers approve,LoanRegistration loanRegistration,
			Model model);


}
