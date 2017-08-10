//package com.srimatha.finance.model;
//
//import javax.persistence.AttributeOverride;
//import javax.persistence.AttributeOverrides;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="loanApprovedCustomerList")
//@AttributeOverrides({  
//    @AttributeOverride(name="serialNumber", column=@Column(name="serialnumber")),  
//    @AttributeOverride(name="customerID", column=@Column(name="customerid")),
//    @AttributeOverride(name="customerFName", column=@Column(name="fname")),  
//    @AttributeOverride(name="customerLName", column=@Column(name="lname")),
//    @AttributeOverride(name="cutomerFatherName", column=@Column(name="fathername")),  
//    @AttributeOverride(name="customerPhone", column=@Column(name="phonenumber")),
//    @AttributeOverride(name="loanAmount", column=@Column(name="loanamount")),   
//}) 
//public class LoanApprovedCustomers extends LoanRegistration{
//	
//	/*@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="loanid")
//	private int loanID;*/
//	
//	@Column(name="decision")
//	private String decision;
//	
//	
//	public LoanApprovedCustomers(){
//		
//	}
//
//	public LoanApprovedCustomers( int serialNumber,
//			int customerID, String customerFName, String customerLName,
//			String cutomerFatherName, String customerPhone, Double loanAmount,
//			String decision) {
//		super(serialNumber, customerID, customerFName, customerLName, cutomerFatherName, customerPhone, loanAmount);
//		
//		this.decision = decision;
//	}
//
///*	public int getLoanID() {
//		return loanID;
//	}
//
//	public void setLoanID(int loanID) {
//		this.loanID = loanID;
//	}
//*/
//	
//	public String getDecision() {
//		return decision;
//	}
//
//	public void setDecision(String decision) {
//		this.decision = decision;
//	}
//
//	@Override
//	public String toString() {
//		return "LoanApprovedCustomers , decision="
//				+ decision + "]";
//	}
//	
//
//}
