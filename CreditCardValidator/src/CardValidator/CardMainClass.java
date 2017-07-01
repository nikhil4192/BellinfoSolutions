package CardValidator;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Scanner;

public class CardMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cardNum, cvv, cardtype;
		int mm, yyyy;
		boolean result = false;

		CardDetails cd = new CardDetails();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the card number : ");
		cardNum = scan.next();
		System.out.println("Enter the expire month of card : ");
		mm = scan.nextInt();
		System.out.println("Enter the expire year of card : ");
		yyyy = scan.nextInt();
		YearMonth userDate = YearMonth.of(yyyy, mm);
		System.out.println("Enter the cvv number : ");
		cvv = scan.next();
		System.out.println("Enter the card Type : ");
		cardtype = scan.next();
		if (cd.cardValidator(cardNum)) {
		} else {
			throw new CardNumberInvalidException("Invalid card number");
		}

		String dateValidator = cd.dateValidator(userDate);
		//System.out.println(dateValidator);
		String cvvValidator = cd.cvvValidator(cvv);
		//System.out.println(cvvValidator);
		String cardTypeValidator = cd.cardTypeValidator(cardNum, cardtype);
		//System.out.println(cardTypeValidator);
		System.out.println("Enter card details are "+cardTypeValidator+" with a "+dateValidator+" vaild security details" );
	}
}

class CardDetails {

	public boolean cardValidator(String cardNumber)
			throws CardNumberInvalidException {
		if (cardNumber.length() > 19 || cardNumber.length() < 13
				|| cardNumber.length() == 14 || cardNumber.length() == 17
				|| cardNumber.length() == 18) {
			throw new CardNumberInvalidException(
					"Please enter proper number of digits.");
		}
		int sum = 0;
		try {
			boolean alternate = false;
			for (int i = cardNumber.length() - 1; i >= 0; i--) {
				int n = Integer.parseInt(cardNumber.substring(i, i + 1));
				// throw new CreditCardNumException("Invalid Digits Entered");
				if (alternate) {
					n *= 2;
					if (n > 9) {
						n = (n % 10) + 1;
					}
				}
				sum += n;
				alternate = !alternate;
			}

		} catch (NumberFormatException e) {
			System.out
					.println("Invalid Digits Entered. Please enter integer values."
							+ e);
		}
		return (sum % 10 == 0);
	}

	public String cvvValidator(String cvv) {
		String[] num = cvv.split("");
		int[] cvvNum = new int[num.length];
		String result;
		for (int i = 0; i < num.length; i++) {
			cvvNum[i] = Integer.parseInt(num[i]);
		}
		if (cvvNum.length == 3) {
			result = "valid Card";
		}
		else if (cvvNum.length == 4) {
			result = "Amex Card";
		} else {
			throw new CvvNumInvalidException("CVV num invalid");
		}
		return result;
	}

	public String cardTypeValidator(String cardNum, String cardType)
			throws CreditCardTypeException {
		if (cardNum.length() > 19 || cardNum.length() < 13
				|| cardNum.length() == 14 || cardNum.length() == 17
				|| cardNum.length() == 18) {
			throw new CreditCardTypeException(
					"Please enter proper number of digits.");
		}

		String num = cardNum;
		String result;
		if ((num.startsWith("34") || num.startsWith("37"))
				&& num.length() == 15) {
			result = "Amex";
		}
		else if ((num.startsWith("6011") || num.startsWith("644")
				|| num.startsWith("645") || num.startsWith("646")
				|| num.startsWith("647") || num.startsWith("648")
				|| num.startsWith("649") || num.startsWith("65"))
				&& (num.length() == 16 || num.length() == 19)) {
			result = "Discover";
		}
		else if ((num.startsWith("51") || num.startsWith("52")
				|| num.startsWith("53") || num.startsWith("54") || num
					.startsWith("55")) && (num.length() == 16)) {
			result = "Master";
		}
		else if (num.startsWith("4")
				&& (num.length() == 13 || num.length() == 16 || num.length() == 19)) {
			result = "Visa";
		}
		else if ((num.startsWith("4026") || num.startsWith("417500")
				|| num.startsWith("4508") || num.startsWith("4844")
				|| num.startsWith("4913") || num.startsWith("4917"))
				&& (num.length() == 16)) {
			result = "Visa Electron";
		} else {
			throw new CreditCardTypeException(
					"Unknown Credit Card. Please enter valid type.");
		}
		if((result.toLowerCase()).equals(cardType.toLowerCase())){
			 result = cardType;
		}
		else{
			throw new CreditCardTypeException("Card number and card type mismatch");
		}
		return result;
	}

	public String dateValidator(YearMonth userDate) {
		String result;
		YearMonth presentDate = YearMonth.now();
		if (userDate.isAfter(presentDate)) {
			result = "valid date";
		} else {
			throw new DateInvalidException("Expired Date");
		}
		return result;
	}
}

class CardNumberInvalidException extends RuntimeException {
	public CardNumberInvalidException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
}

class CvvNumInvalidException extends RuntimeException {
	public CvvNumInvalidException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
}

class DateInvalidException extends RuntimeException {
	public DateInvalidException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
}

class CreditCardTypeException extends RuntimeException {
	public CreditCardTypeException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
}