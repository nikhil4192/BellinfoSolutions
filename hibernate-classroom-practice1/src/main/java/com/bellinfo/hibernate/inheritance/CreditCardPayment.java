package com.bellinfo.hibernate.inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="creditcard_payment_concrete")
@AttributeOverrides({  
    @AttributeOverride(name="paymentId", column=@Column(name="payment_id")),  
    @AttributeOverride(name="amount", column=@Column(name="amount"))  
}) 
public class CreditCardPayment extends Payment {

	@Column(name="card_number")
	private String ccNumber;
	
	@Column(name="cvv")
	private String cvv;
	
	public CreditCardPayment(){
		
	}

	public CreditCardPayment(int paymentId, String amount, String ccNumber, String cvv) {
		super(paymentId, amount);
		this.ccNumber = ccNumber;
		this.cvv = cvv;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CreditCardPayment [ccNumber=" + ccNumber + ", cvv=" + cvv + "]";
	}
	
	
}
