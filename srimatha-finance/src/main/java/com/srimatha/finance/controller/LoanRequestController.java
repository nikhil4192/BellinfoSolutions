package com.srimatha.finance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.srimatha.finance.model.LoanRegistration;
import com.srimatha.finance.service.LoanRegisterationService;
import com.srimatha.finance.service.LoanRequestService;


@Controller
@RequestMapping(value="/request")
public class LoanRequestController {


	@Autowired
	private LoanRequestService theLoanRequestService;
	
	List<LoanRegistration>  list;
	@RequestMapping(method=RequestMethod.GET)
	public String getAllLoanRequests(Model model){
		System.out.println("getting the loan approval form");
		LoanRegistration loanRegistration =
				new LoanRegistration();
		list= (List<LoanRegistration>) theLoanRequestService.getAllLoanRequests();
		model.addAttribute("list", list);
		return "loanRequest";
	}
	
	
	@GetMapping("/approve")
	public String showFormForApprove(@RequestParam("serialID") int theId, Model model){
		
		LoanRegistration loanRegistration = theLoanRequestService.getCustomerLoanRequest(theId);
		
		
		model.addAttribute("approve", loanRegistration);
		
		return "loanApprovalForm";
	}
	
	
	@PostMapping("/approve")
	public String addLoanRequests(@ModelAttribute("approve") LoanRegistration approve,
									 Model model){
		int theId = approve.getSerialNumber();
		System.out.println("saving approved list started");
		theLoanRequestService.addLoanRequests(approve,model);
		return "loanRequest";
	}
	
	
	
}
