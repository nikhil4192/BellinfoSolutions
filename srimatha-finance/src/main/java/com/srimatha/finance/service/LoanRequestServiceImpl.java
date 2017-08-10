package com.srimatha.finance.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.srimatha.finance.dao.LoanRequestDAO;
import com.srimatha.finance.model.LoanRegistration;

@Service
public class LoanRequestServiceImpl implements LoanRequestService{

	@Autowired
	private LoanRequestDAO theLoanRequestDAO;
	@Transactional
	public List<LoanRegistration> getAllLoanRequests() {
		
		List<LoanRegistration> rawlist = theLoanRequestDAO.getAllLoanRequests();
//		List<LoanRegistration> list = new ArrayList<LoanRegistration>();
//		
//		for(LoanRegistration l:rawlist){
//			System.out.println(l.getCustomerID()+" "+l.getStatus());
//			if(!((l.getStatus()).equals("Approve")) && !((l.getStatus()).equals("Reject")));
//			list.add(l);
//		}
		return rawlist;
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
	public void addLoanRequests(LoanRegistration approve,
			Model model) {
		// TODO Auto-generated method stub
		DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		approve.setApproveddate(f.format(date));
		System.out.println("saving approved list started in service");
		 theLoanRequestDAO.addLoanRequests(approve, model);
	}

	

}
