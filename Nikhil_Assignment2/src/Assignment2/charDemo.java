package Assignment2;

import java.lang.reflect.Array;
import java.util.Scanner;

public class charDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number values you want to enter into array : ");
		int i = scan.nextInt();
		char[] hi = new char[i];
		System.out.println("please enter the char values : ");
		for(int j=0; j< hi.length; j++){
			hi[j] = scan.next().charAt(0);
			
		}
		System.out.println((char[])hi);
		scan.close();

	}
	

}
