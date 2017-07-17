package telephoneModel;

public class TelePayment {

	private String phone;
	private String name;
	private String cardNum;
	private String mm;
	private String yy;
	private String cvv;
	private String amount;
	
public TelePayment(){
	
}

public TelePayment(String phone, String name, String cardNum, String mm,
		String yy, String cvv, String amount) {
	super();
	this.phone = phone;
	this.name = name;
	this.cardNum = cardNum;
	this.mm = mm;
	this.yy = yy;
	this.cvv = cvv;
	this.amount = amount;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCardNum() {
	return cardNum;
}

public void setCardNum(String cardNum) {
	this.cardNum = cardNum;
}

public String getMm() {
	return mm;
}

public void setMm(String mm) {
	this.mm = mm;
}

public String getYy() {
	return yy;
}

public void setYy(String yy) {
	this.yy = yy;
}

public String getCvv() {
	return cvv;
}

public void setCvv(String cvv) {
	this.cvv = cvv;
}

public String getAmount() {
	return amount;
}

public void setAmount(String amount) {
	this.amount = amount;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((amount == null) ? 0 : amount.hashCode());
	result = prime * result + ((cardNum == null) ? 0 : cardNum.hashCode());
	result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
	result = prime * result + ((mm == null) ? 0 : mm.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	result = prime * result + ((yy == null) ? 0 : yy.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TelePayment other = (TelePayment) obj;
	if (amount == null) {
		if (other.amount != null)
			return false;
	} else if (!amount.equals(other.amount))
		return false;
	if (cardNum == null) {
		if (other.cardNum != null)
			return false;
	} else if (!cardNum.equals(other.cardNum))
		return false;
	if (cvv == null) {
		if (other.cvv != null)
			return false;
	} else if (!cvv.equals(other.cvv))
		return false;
	if (mm == null) {
		if (other.mm != null)
			return false;
	} else if (!mm.equals(other.mm))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (phone == null) {
		if (other.phone != null)
			return false;
	} else if (!phone.equals(other.phone))
		return false;
	if (yy == null) {
		if (other.yy != null)
			return false;
	} else if (!yy.equals(other.yy))
		return false;
	return true;
}

@Override
public String toString() {
	return "TelePayment [phone=" + phone + ", name=" + name + ", cardNum="
			+ cardNum + ", mm=" + mm + ", yy=" + yy + ", cvv=" + cvv
			+ ", amount=" + amount + "]";
}


}
