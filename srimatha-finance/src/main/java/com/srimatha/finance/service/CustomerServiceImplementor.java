package com.srimatha.finance.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.omg.PortableServer.THREAD_POLICY_ID;
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
	
	
	
	@Transactional
	public String isValidUser(String username, String password, Model model) {
		System.out.println("isvalid is inside service isvaliduser");
		Customer customer;
		
		customer = (Customer)thecustomerDAO.isValidUser(username, password, model);
		
		//int userName = (Integer.parseInt(username));
		 
			 System.out.println(customer.getCustomerID());
			 System.out.println(customer.getCustomerPswd());
			 System.out.println(username);
			 System.out.println(password);
			 if((username.equals("admin")) && (password.equals("admin"))){
				 //System.out.println((customer.getCustomerID().equals("0")) && (customer.getCustomerPswd().equals("admin")));
				 return "adminHome";
			 }
			 else if((customer.getCustomerUserID().equals(username))&&(customer.getCustomerPswd().equals(password))){
				 System.out.println((customer.getCustomerUserID().equals(username)) &&
						  (customer.getCustomerPswd().equals(password)));
				 
				 return "userHome";
			 }
		 return "customer-login";
	}
	
	@Transactional
	public Customer getCustomer(String username) {
		return thecustomerDAO.getCustomer(username);
	}
	
	@Transactional
	public List<LoanRegistration> showMeApprovedLoans(String username) {
		List<LoanRegistration> list = thecustomerDAO.showMeApprovedLoans(username);
		List<LoanRegistration> userApprovedLoans = new ArrayList<LoanRegistration>();
		try{
		for(LoanRegistration l:list){
			if((l.getStatus()).equals("Approve")){
				userApprovedLoans.add(l);
			}
		}
		}catch (NullPointerException e) {
			System.out.println("No values in the list");
		}
		
		
		 return userApprovedLoans;
	}

	@Transactional
	public void postRegistrationData(Customer customer, Model model) {
		List<Customer> list = thecustomerDAO.getAllCustomer();
////		for(Customer c: list){
////			if((c.getCustomerFName().equals(customer.getCustomerFName())) && 
////					(c.getCustomerLName().equals(customer.getCustomerLName())) &&
////					(c.getCustomerFatherOrHusbandName().equals(customer.getCustomerFatherOrHusbandName())) && 
////					(c.getCustomerPhone().equals(customer.getCustomerPhone())) && 
////					c.getCustomerUserID().equals(customer.getCustomerUserID())){
////				
////				return false;
////			}
//		}
		thecustomerDAO.postRegistrationData(customer, model);
		//return true;
		
	}

	@Transactional
	public Customer getTheUserDetails(String user) {
		Customer cust = thecustomerDAO.getTheUserDetails(user);
		return null;
	}

	@Transactional
	public List<Customer> history(LoanRegistration loanRegistration, String user){
		return thecustomerDAO.history(loanRegistration, user);
	}

	@Transactional
	public List<Customer> approvedRequest(
			LoanRegistration loanRegistration, String user) {
		return thecustomerDAO.approvedRequest(loanRegistration, user);
	}

	@Transactional
	public List<Customer> rejectedRequest(
			LoanRegistration loanRegistration, String user) {
		return thecustomerDAO.rejectedRequest(loanRegistration, user);
	}

	@Transactional
	public LoanRegistration getPayment(LoanRegistration loanRegistration, String user) throws ParseException {
		LoanRegistration loan = thecustomerDAO.getPayment(loanRegistration, user);
		int count = 0;
		Calendar calendar = Calendar.getInstance();	
		DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		Date d1 = f.parse(loan.getApproveddate());
		Date d2 = f.parse(f.format(date));
		int diffMonth = differenceInMonths(d1, d2);
		System.out.println(d1 + " "+ d2+" "+diffMonth);
		double intrest = ((loan.getLoanAmount())*(0.01)*(diffMonth+1));
		System.out.println(intrest);
		loan.setIntrestamount(intrest);
		return loan;
	}
	
	private static int differenceInMonths(Date d1, Date d2) {
	    Calendar c1 = Calendar.getInstance();
	    c1.setTime(d1);
	    Calendar c2 = Calendar.getInstance();
	    c2.setTime(d2);
	    int diff = 0;
	    if (c2.after(c1)) {
	        while (c2.after(c1)) {
	            c1.add(Calendar.MONTH, 1);
	            if (c2.after(c1)) {
	                diff++;
	            }
	        }
	    } else if (c2.before(c1)) {
	        while (c2.before(c1)) {
	            c1.add(Calendar.MONTH, -1);
	            if (c1.before(c2)) {
	                diff--;
	            }
	        }
	    }
	    return diff;
	}

	@Transactional
	public void postPayment(LoanRegistration payment, String user) {
//		LoanRegistration loanRegistration = new LoanRegistration();
//		LoanRegistration loanDBValues = getPayment(loanRegistration, user);
//		payment.setCutomerFatherName(loanDBValues.getCustomerFName());
//		payment.setLoanAmount(loanDBValues.getLoanAmount());
//		payment.setStatus(loanDBValues.getStatus());
//		payment.setApproveddate(loanDBValues.getApproveddate());
		double chgAmount = payment.getLoanAmount();
		System.out.println("Loan Amount:" +payment.getLoanAmount());
		double chgPayment = payment.getPayment();
		chgAmount -= chgPayment;
		System.out.println("loan after payment :"+chgAmount);
		payment.setLoanAmount(chgAmount);
		
		thecustomerDAO.postPayment(payment);
	}
	

	
}
