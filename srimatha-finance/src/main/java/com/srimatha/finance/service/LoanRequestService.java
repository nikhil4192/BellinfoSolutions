package com.srimatha.finance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.srimatha.finance.model.LoanRegistration;

public interface LoanRequestService {

	public List<LoanRegistration> getAllLoanRequests();

//	public void addApprovedLoansToDB(
//			ArrayList<LoanApprovedCustomers> approvedList, Model model);

	public LoanRegistration getCustomerLoanRequest(int theId);

	public void addLoanRequests(LoanRegistration approve,
			Model model);


}