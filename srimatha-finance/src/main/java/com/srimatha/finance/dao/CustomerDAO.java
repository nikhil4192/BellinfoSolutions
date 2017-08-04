package com.srimatha.finance.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.ui.Model;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

public interface CustomerDAO {

	public Customer getCustomer(String username, String password, Model model);
	
	
}
