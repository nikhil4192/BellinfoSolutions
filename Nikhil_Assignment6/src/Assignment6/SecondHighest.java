package Assignment6;

import java.util.Scanner;

public class SecondHighest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		boolean same =true;
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
			System.out.println();
		}
		for(int j=0;j<num.length-2;j++){
			if(num[num.length-2]==num[j]){
			System.out.println(num[num.length-2]+" and "+num[j]+" as the values ");
			same=false;
			}else if(num[num.length-2]==num[num.length-1]){
				System.out.println(num[num.length-2]+" and "+num[num.length-1]+" as the values ");
				same = false;
			}	
		}
		if(same == true){
			System.out.println("The Second heighest value in the array is: "+num[num.length-2]);
		}
		
		scan.close();


	}

}
