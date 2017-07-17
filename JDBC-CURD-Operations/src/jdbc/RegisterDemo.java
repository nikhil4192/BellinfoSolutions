package jdbc;

import java.util.Scanner;

public class RegisterDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RegistrationRespository rr = new RegistrationRespository();
		System.out.println("Welcome to Login Page:");
		System.out.println("Enter the user Id:");
		String uName = scan.nextLine();
		System.out.println("Enter the Password");
		String pwd = scan.nextLine();
		if(rr.validateLogin(uName, pwd)){
			rr.createRegistration();
			System.out.println("Select the operation you want to perform :");
			int i = 0;
			System.out.println("1.Insertion\n2.Deletion\n3.Updation\n4.Display Table");
			i=scan.nextInt();
			System.out.println();
			switch (i) {
			case 1:
				System.out.println("Enter the user details you want to enter:");
				scan.nextLine();
				System.out.println("Enter the name of the user:");
				String uNme = scan.nextLine();
				System.out.println();
				System.out.println("Enter the password for the user name:");
				String pswd = scan.nextLine();
				System.out.println("Enter the gender of the user:");
				String gen = scan.next();
				System.out.println("Enter the age of the user:");
				int ag = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the mail id of the user:");
				String ml = scan.nextLine();
				CustInfo info = new CustInfo(uNme, pswd, gen, ag, ml);
				rr.insertCustInfo(info);
				break;
			case 2:
				System.out.println("Enter the name for which you want to delete the record: ");
				String nameN = scan.nextLine();
				rr.deleteCustinfo(nameN);
				break;
			case 3:
			
//				System.out.println("Status Report - inserted:"+statusResult);
				System.out.println("Enter the email id for which you want to change the details:");
				String mail1 = scan.nextLine();
				System.out.println("Enter the name of the user:");
				String n = scan.nextLine();
				System.out.println("Enter the password for the user name:");
				String p = scan.next();
				System.out.println("Enter the gender of the user:");
				String g = scan.next();
				System.out.println("Enter the age of the user:");
				int a = scan.nextInt();
				rr.updateCustInfo(n, p, g, a, mail1);
				break;
			case 4:
				rr.selectAllData();
				break;
			default:
				System.out.println("Please select a option between 1 - 4");
				break;
			}
		}
			
		
//		scan.close();
//	}

}
}
