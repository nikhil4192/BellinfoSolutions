package Assignment3;

import java.util.Scanner;

public class Program1 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int num,count=1;
		System.out.println("Enter Number of students :");
		num = scan.nextInt();
		int[] id = new int[num];
		String[] name = new String[num];
		double[] fee = new double[num];
		char[] sec  = new char[num];
		
		for(int i=0;i<num; i++){
			System.out.println("Enter student "+count+" Id :");
			id[i]= scan.nextInt();
			scan.nextLine();
			System.out.println("Enter student "+count+" name:");
			name[i]= scan.nextLine();
			System.out.println("Enter student "+count+" fee :");
			fee[i]= scan.nextDouble();
			System.out.println("Enter student "+count+" section :");
			sec[i] = scan.next().charAt(0);
			count++;
		}
		System.out.println("****** Result*********\nId Name Fee Section");
		for(int j=0; j<num; j++){
			System.out.println(id[j]+" "+name[j]+" "+fee[j]+" "+sec[j]);
		}
	scan.close();	
	}

}
