package com.bellinfo.hibernate.inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cheque_payment_concrete")
@AttributeOverrides({  
    @AttributeOverride(name="paymentId", column=@Column(name="payment_id")),  
    @AttributeOverride(name="amount", column=@Column(name="amount"))  
}) 
public class ChequePayment extends Payment{

	@Column(name="cheque_number")
	private String chequeNo;
	
	@Column(name="cheque_by")
	private String checkBy;
	
	public ChequePayment(){
		
	}

	public ChequePayment(int paymentId, String amount, String chequeNo, String checkBy) {
		super(paymentId, amount);
		this.chequeNo = chequeNo;
		this.checkBy = checkBy;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getCheckBy() {
		return checkBy;
	}

	public void setCheckBy(String checkBy) {
		this.checkBy = checkBy;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", checkBy=" + checkBy
				+ "]";
	}
	
	
}
