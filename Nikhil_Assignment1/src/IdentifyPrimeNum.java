import java.util.*;
public class IdentifyPrimeNum {

	public static void main(String[] args) {
		boolean prime = true;
		System.out.println("Enter a number to find whether a prime or not:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if(num == 2 || num == 3){
			//System.out.println("Given number "+ num +" is a prime number");
			prime = true;
		}
		if(num%2 ==0){
			//System.out.println("Given number "+ num +" is a not prime number");
			prime = false;
		}
		if(num%2 !=0){
				for(int i=3; i<num; i+=2){
					if(num%i == 0){
						prime = false;
						//System.out.println("Given number "+ num +" is a not prime number");	
						break;
					}
				}
				//System.out.println("Given number "+ num +" is a prime number");
		}
		if(prime){
			System.out.println("Given number "+ num +" is a prime number");
		}
		else{
			System.out.println("Given number "+ num +" is a not prime number");
		}	
		scan.close();
	}

	}

