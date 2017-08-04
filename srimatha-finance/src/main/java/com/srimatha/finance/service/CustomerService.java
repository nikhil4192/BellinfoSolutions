package com.srimatha.finance.service;


import org.springframework.ui.Model;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

public interface CustomerService {

	public String isValidUser(String username,String password, Model model);
	
}
