package Assignment6;

import java.util.Scanner;

public class TwoTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		
		System.out.println("Enter the number for which you want the table :");
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		for(int i=1; i<11;i++){
			System.out.println(num+" * "+i+" = "+num*i);
		}
		scan.close();
	}

}
