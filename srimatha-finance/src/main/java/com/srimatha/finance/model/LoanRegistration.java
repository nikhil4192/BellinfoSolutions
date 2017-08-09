package com.srimatha.finance.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="loanRegistration")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class LoanRegistration{
	
	@Id
	@Column(name="loanSerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serialNumber;
	
	@Column(name="customerId")
	private int customerID;
	
	@Column(name="firstName")
	private String customerFName;
	
	@Column(name="lastName")
	private String customerLName;
	
	@Column(name="fatherName")
	private String cutomerFatherName;
	
	@Column(name="phoneNumber")
	private String customerPhone;
	
	@Column(name="loanAmount")
	private double loanAmount;
	
	public LoanRegistration(){
		
	}


	public LoanRegistration(int serialNumber, int customerID,
			String customerFName, String customerLName,
			String cutomerFatherName, String customerPhone, double loanAmount) {
		super();
		this.serialNumber = serialNumber;
		this.customerID = customerID;
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.cutomerFatherName = cutomerFatherName;
		this.customerPhone = customerPhone;
		this.loanAmount = loanAmount;
	}


	

	public int getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public String getCustomerFName() {
		return customerFName;
	}


	public void setCustomerFName(String customerFName) {
		this.customerFName = customerFName;
	}


	public String getCustomerLName() {
		return customerLName;
	}


	public void setCustomerLName(String customerLName) {
		this.customerLName = customerLName;
	}


	public String getCutomerFatherName() {
		return cutomerFatherName;
	}


	public void setCutomerFatherName(String cutomerFatherName) {
		this.cutomerFatherName = cutomerFatherName;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	
	@Override
	public String toString() {
		return "LoanRegistration [serialNumber=" + serialNumber
				+ ", customerID=" + customerID + ", customerFName="
				+ customerFName + ", customerLName=" + customerLName
				+ ", cutomerFatherName=" + cutomerFatherName
				+ ", customerPhone=" + customerPhone + ", loanAmount="
				+ loanAmount + "]";
	}
	
	
	

}
