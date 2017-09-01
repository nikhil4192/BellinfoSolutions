package sample;

import java.util.Scanner;


public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a number to find the fibonacci series:");
		Scanner scan = new Scanner(System.in);
		long num =  scan.nextInt();
		long i =0;
		long j =1;
		long fab =0;
		int count =2;
		System.out.print(i+" ,"+j);
		do{
			fab = i+j;
			i = j;
			j = fab;
			count ++;
			System.out.print(" ,"+fab);
		}while(count<num);
		scan.close();
	}

}
