package com.srimatha.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.srimatha.finance.dao.LoanRegistrationDAO;
import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

@Service
public class LoanRegistrationServiceImplementor implements LoanRegisterationService{

	@Autowired
	private LoanRegistrationDAO theLoanRegistrationDAO;
	
	@Transactional
	public boolean isValidAmount(int customerid, double amount, Model model){
		
		boolean idContain = false;
		List<LoanRegistration> list = (List<LoanRegistration>)theLoanRegistrationDAO.isValidAmount(customerid, amount, model);
		for(LoanRegistration l:list){
			if(l.getCustomerID() == customerid){
			double amt = l.getLoanAmount();

			String amtd = Double.toString(amt);
			if (amt == 0 || amtd == null){
				return true;
			}
			return false;
		}
		
		}
		
		return true;
		
	}
	
	
	@Transactional
	public boolean isValidCustomer(int customerid, String firstname, String lastname, String fathername, String phonenumber, Model model){
		Customer lr;
		System.out.println("Going to DAO");
		lr = (Customer)theLoanRegistrationDAO.isValidCustomer(customerid, firstname, lastname, fathername, phonenumber, model);
		System.out.println(customerid + " " + lr.getCustomerID());
		System.out.println(firstname + " " + lr.getCustomerFName());
		System.out.println(lastname + " " + lr.getCustomerLName());
		System.out.println(fathername + " " + lr.getCustomerFatherOrHusbandName());
		System.out.println(phonenumber + " " + lr.getCustomerPhone());
		if((lr.getCustomerID() == customerid) && (lr.getCustomerFName().equals(firstname)) && (lr.getCustomerLName().equals(lastname)) && (lr.getCustomerFatherOrHusbandName().equals(fathername)) && (lr.getCustomerPhone().equals(phonenumber))){
			System.out.println("All correct");
			return true;
		}
		else{
			System.out.println("All wrong");
			return false;
		}
	}
	
	
	@Transactional
	public void addLoanFormTODAO(LoanRegistration loanRegistration, Model model) {
		System.out.println("isvalid is inside service addLoanFoarm");
		theLoanRegistrationDAO.addLoanFormToDB(loanRegistration, model);
		
	}

}
