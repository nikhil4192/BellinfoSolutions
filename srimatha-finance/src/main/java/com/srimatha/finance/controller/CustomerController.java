package com.srimatha.finance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.service.CustomerService;
import com.srimatha.finance.service.CustomerServiceImplementor;



@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService thecustomerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String studentData(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("message", "Welcome....");
		return "customer-login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String postStudentData(HttpServletRequest req, @Valid @ModelAttribute Customer customer, BindingResult result, Model model){
		String username = req.getParameter("customerID");
		String password = req.getParameter("customerPswd");
		String user;
		System.out.println("isvalid is going to execute");
		user = thecustomerService.isValidUser(username,password,model);
		if(result.hasErrors()){
			return "customer-login";
		}
		System.out.println("isvalid is executed");
		if(user.equals("adminHome")){
			return "adminHome";
		}
		if(user.equals("userHome")){
			return "userHome";
		}
		
			return "customer-login";
		
	}
}
