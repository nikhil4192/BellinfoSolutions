import java.util.*;
public class Factorial {

	public static void main(String[] args) {
		System.out.println("Enter the number to which you want to find the factorial:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int factorial = 1;
		for(int i=1; i<=num; i++){
			factorial *= i; 
		}
		System.out.println("Factorial of "+num+" is "+factorial);
	}

}
