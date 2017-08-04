package com.srimatha.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srimatha.finance.model.Customer;


@Controller
public class LandingPageController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String landingPage(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-login";
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String indexPage(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-login";
	}
}
