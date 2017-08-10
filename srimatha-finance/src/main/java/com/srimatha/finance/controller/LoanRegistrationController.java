package com.srimatha.finance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanRegistration;
import com.srimatha.finance.service.CustomerService;
import com.srimatha.finance.service.LoanRegisterationService;

@Controller
@RequestMapping("/loanRegistration")
public class LoanRegistrationController {

	@Autowired
	private LoanRegisterationService theLoanRegisterationService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String customerData(Model model){
		LoanRegistration loanRegistration =
				new LoanRegistration();
		model.addAttribute("loanRegistration", loanRegistration);
		return "loanForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String postCustomerData(HttpServletRequest req, @Valid @ModelAttribute("loanRegistration") LoanRegistration loanRegistration, 
									BindingResult result, Model model){
		String id = req.getParameter("customerID");
		String firstname = req.getParameter("customerFName");
		String lastname = req.getParameter("customerLName");
		String fathername = req.getParameter("cutomerFatherName");
		String phonenumber = req.getParameter("customerPhone");
		String amt = req.getParameter("loanAmount");
		System.out.println(fathername);
		req.getSession().setAttribute("customerid", id);
		req.getSession().setAttribute("firstname", firstname);
		req.getSession().setAttribute("lastname", lastname);
		req.getSession().setAttribute("fatherorhusbandname", fathername);
		req.getSession().setAttribute("phonenumber", phonenumber);
		int customerid = Integer.parseInt(id);
		double amount = Double.parseDouble(amt);
		
		boolean user;
		boolean checkAmount;
		System.out.println("loan form method started");
		user = theLoanRegisterationService.isValidCustomer(customerid, firstname, lastname, fathername, phonenumber, model);
		if(user){
		boolean valid = false;
		System.out.println("loan form method started");
		checkAmount = theLoanRegisterationService.isValidAmount(customerid, amount, model);
			if(checkAmount){
				theLoanRegisterationService.addLoanFormTODAO(loanRegistration, model);
				System.out.println("loan method executed");
				if(result.hasErrors()){
					return "loanForm";
				}
				return "userHome";
		
			}
			return "amount";
			
		}
			return "error";
		}
	
	
	
		
}
