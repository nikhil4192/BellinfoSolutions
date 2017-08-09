package com.srimatha.finance.controller;

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
	public String postCustomerData(@Valid @ModelAttribute("loanRegistration") LoanRegistration loanRegistration, 
									BindingResult result, Model model){

		boolean valid = false;
		System.out.println("loan form method started");
		theLoanRegisterationService.addLoanFormTODAO(loanRegistration, model);
		System.out.println("loan method executed");
		if(result.hasErrors()){
			return "loanForm";
		}
		return "userHome";
		
	}
	
	
		
}
