package Assignment3;

import java.util.Scanner;

public class Program2 {
	static int num;
	static int i = 0;
	static int count = 1;
	static int j = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number of students :");
		num = scan.nextInt();
		int[] id = new int[num];
		String[] name = new String[num];
		double[] fee = new double[num];
		char[] sec = new char[num];
		details(id, name, fee, sec);
		System.out.println("Enter section that you want to see the result :");
		char find = scan.next().charAt(0);
		
		System.out.println("****** Result*********\nId Name Fee Section");
		printResult(find, id, name, fee, sec);
		scan.close();
	}

	private static void printResult(char find, int[] id, String[] name,
			double[] fee, char[] sec) {
		if (i < sec.length) {
			if (find == sec[i]) {
				System.out.println(id[i] + " " + name[i] + " " + fee[i] + " "+ sec[i]);
				i++;
				printResult(find, id, name, fee, sec);
			}
			else{
				System.out.println("No student with that section");
			}
		}
	}

	private static void details(int[] id, String[] name, double[] fee,char[] sec) {
		
		if (j< num) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter student " + count + " Id :");
			id[j] = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter student " + count + " name:");
			name[j] = scan.nextLine();
			System.out.println("Enter student " + count + " fee :");
			fee[j] = scan.nextDouble();
			System.out.println("Enter student " + count + " section :");
			sec[j] = scan.next().charAt(0);
			j++;
			count++;
			details(id, name, fee, sec);
			scan.close();
		}

	}

}
