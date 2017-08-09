package com.srimatha.finance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srimatha.finance.model.Customer;
import com.srimatha.finance.model.LoanApprovedCustomers;
import com.srimatha.finance.model.LoanRegistration;
import com.srimatha.finance.service.CustomerService;
import com.srimatha.finance.service.CustomerServiceImplementor;



@Controller
public class CustomerController {

	@Autowired
	private CustomerService thecustomerService;
	
	@RequestMapping(value="/customer",method=RequestMethod.GET)
	public String studentData(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("message", "Welcome....");
		return "customer-login";
	}
	
	@GetMapping("/adHome")
	public String adminHome(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "adminHome";
	}
	@GetMapping("/registration")
	public String getRegistrationData(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "registration";
	}
	
	
	@RequestMapping(value="/customer",method=RequestMethod.POST)
	public String postStudentData(HttpServletRequest req, @Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){
		String username = req.getParameter("customerUserID");
		String password = req.getParameter("customerPswd");
		req.getSession().setAttribute("username", username);
		req.getSession().setAttribute("password", password);
		String user;
		System.out.println("isvalid is going to execute");
		user = thecustomerService.isValidUser(username,password,model);
//		if(result.hasErrors()){
//			return "customer-login";
//		}
		System.out.println("isvalid is executed");
		if(user.equals("adminHome")){
			return "adminHome";
		}
		if(user.equals("userHome")){
			return "userHome";
		}
		
			return "customer-login";
		
	}
	
	
	@PostMapping("/registration")
	public String PostRegistrationData(@ModelAttribute("customer") Customer customer, Model model){
		System.out.println("Hello");
		thecustomerService.postRegistrationData(customer, model);
		return "customer-login";
	}
	
	@RequestMapping(value="/customer")
	public Customer getCustomer(String username){
		Customer customer = thecustomerService.getCustomer(username);
		return customer;
	}
	
	
	@GetMapping("/userApprovedLoans")
	public String showMeApprovedLoans(HttpServletRequest req,String username, Model model){
		System.out.println(username);
		String user = (String)req.getSession().getAttribute("username");
		System.out.println("INSIDE showMeApprovedLoans = "+user);
		List<LoanApprovedCustomers> userApprovedLoans= thecustomerService.showMeApprovedLoans(user);
		if(userApprovedLoans.isEmpty()){
			model.addAttribute("userApprovedLoans", "No approved loans for this user.");
		}
		else{
		model.addAttribute("userApprovedLoans", userApprovedLoans);
		}
		return "userApproved";
	}
	
	@GetMapping("/userHistory")
	public String history(HttpServletRequest req, LoanApprovedCustomers loanApprovedCustomers,
							String username,Model model){
		String user =(String)req.getSession().getAttribute("username");
		System.out.println(user);
		Customer customer = new Customer();
		List<Customer> list = thecustomerService.history(loanApprovedCustomers,user);
		model.addAttribute("userHistory", list);
		return "userHistory";
	}
	
	@GetMapping("/approvedRequest")
	public String approvedRequest(HttpServletRequest req, LoanApprovedCustomers loanApprovedCustomers,
							String username,Model model){
		String user =(String)req.getSession().getAttribute("username");
		System.out.println(user);
		Customer customer = new Customer();
		List<Customer> list = thecustomerService.approvedRequest(loanApprovedCustomers,user);
		model.addAttribute("approvedRequest", list);
		return "approvedRequest";
	}
	
	@GetMapping("/rejectedRequest")
	public String rejectedRequest(HttpServletRequest req, LoanApprovedCustomers loanApprovedCustomers,
							String username,Model model){
		String user =(String)req.getSession().getAttribute("username");
		System.out.println(user);
		Customer customer = new Customer();
		List<Customer> list = thecustomerService.rejectedRequest(loanApprovedCustomers,user);
		model.addAttribute("rejectedRequest", list);
		return "rejectedRequest";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request, String username, String password){
		request.setAttribute("null", username);
		request.setAttribute("null", password);
		return "logout";
	}
}
