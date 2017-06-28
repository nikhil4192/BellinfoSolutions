package Assignment6;

import java.util.Scanner;

public class ThreeDimTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number for which you want the table :");
		num = scan.nextInt();
		for(int i=1; i<11; i++){
			for(int j =1; j<11; j++){
				System.out.println(num+" * "+i+" * "+j+" = "+num*i*j);
			}
		}scan.close();
	}
	
}
