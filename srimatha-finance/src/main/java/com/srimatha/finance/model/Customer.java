package com.srimatha.finance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@NotNull(message="Should not be empty")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerID")
	private String customerID;
	
	@Column(name="firstName")
	private String customerFName;
	
	@Column(name="lastName")
	private String customerLName;
	
	@Column(name="fatherOrHusbandName")
	private String customerFatherOrHusbandName;
	
	@Column(name="phoneNumber")
	private String customerPhone;
	
	@Column(name="userId")
	@NotNull(message="Should not be empty")
	private String customerUserID;
	
	@Column(name="password")
	@NotNull(message="Should not be empty")
	private String customerPswd;
	
	public Customer(){
		
	}
	

	public Customer(String customerID, String customerFName, String customerLName,
			String customerFatherOrHusbandName, String customerPhone,
			String customerUserID, String customerPswd) {
		super();
		this.customerID = customerID;
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.customerFatherOrHusbandName = customerFatherOrHusbandName;
		this.customerPhone = customerPhone;
		this.customerUserID = customerUserID;
		this.customerPswd = customerPswd;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
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

	public String getCustomerFatherOrHusbandName() {
		return customerFatherOrHusbandName;
	}

	public void setCustomerFatherOrHusbandName(String customerFatherOrHusbandName) {
		this.customerFatherOrHusbandName = customerFatherOrHusbandName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerUserID() {
		return customerUserID;
	}

	public void setCustomerUserID(String customerUserID) {
		this.customerUserID = customerUserID;
	}

	public String getCustomerPswd() {
		return customerPswd;
	}

	public void setCustomerPswd(String customerPswd) {
		this.customerPswd = customerPswd;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerFName="
				+ customerFName + ", customerLName=" + customerLName
				+ ", customerFatherOrHusbandName="
				+ customerFatherOrHusbandName + ", customerPhone="
				+ customerPhone + ", customerUserID=" + customerUserID
				+ ", customerPswd=" + customerPswd + "]";
	}
	

}
