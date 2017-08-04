package com.srimatha.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;




import com.srimatha.finance.dao.CustomerDAO;
import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;

@Service
public class CustomerServiceImplementor implements CustomerService {

	@Autowired
	private CustomerDAO thecustomerDAO;

	public String isValidUser(String username, String password, Model model) {
		System.out.println("isvalid is inside service isvaliduser");
		Customer customer;
		try{
		customer = (Customer)thecustomerDAO.getCustomer(username, password, model);
		}catch(NullPointerException e){
			return "customer-login";
		}
		//int userName = (Integer.parseInt(username));
		 
			 System.out.println(customer.getCustomerID());
			 System.out.println(customer.getCustomerPswd());
			 System.out.println(username);
			 System.out.println(password);
			 if((username.equals("0")) && (password.equals("admin"))){
				 //System.out.println((customer.getCustomerID().equals("0")) && (customer.getCustomerPswd().equals("admin")));
				 return "adminHome";
			 }
			 if((customer.getCustomerID().equals(username))&&(customer.getCustomerPswd().equals(password))){
				 System.out.println((customer.getCustomerID() == username) &&
						  (customer.getCustomerPswd().equals(password)));
				 
				 return "userHome";
			 }
		 return "customer-login";
	}

	

}
