package Assignment6;

import java.util.Scanner;

public class SortClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of values you want enter:");
		i= scan.nextInt();
		int[] num = new int[i];
		System.out.println("Enter the number's you want to sort :");
		for(int j=0;j<i;j++){
			num[j] = scan.nextInt();
		}
		
		for(int j=1;j<num.length;j++){
			for(int n=0;n<num.length-1;n++){
			if(num[n]>num[j]){
				int m=num[n];
				num[n]=num[j];
				num[j]=m;
			}
			}
		}
		for(int j=0;j<num.length;j++){
			System.out.print(num[j]+" ");
		}
		scan.close();
	}

}
