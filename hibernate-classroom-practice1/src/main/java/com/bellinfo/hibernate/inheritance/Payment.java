package com.bellinfo.hibernate.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="payment_concrete")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="payment_id")
	private int paymentId;
	
	@Column(name="amount")
	private String amount;
	
	public Payment(){
		
	}

	public Payment(int paymentId, String amount) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + "]";
	}
	
	
}
