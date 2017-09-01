package sample;

import java.util.Arrays;
import java.util.Scanner;

public class SecondHighestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number values to enter");
		int n = scan.nextInt();
		System.out.println("please enter the values:");
		int[] num = new int[n];
		for(int i=0;i<n; i++){
			num[i] = scan.nextInt();
		}
		Arrays.sort(num);
		int temp = num[num.length-1];
		int len = num.length-1;
		for(int i=len; i>=0;i--){
			if(num[i]<temp){
				temp=num[i];
				System.out.println("Second highest is "+temp);
				break;
			}
			if(i==0){
				System.out.println("There is no highest value. ");
			}
		}
		
		
		scan.close();
		
		

	}

}
