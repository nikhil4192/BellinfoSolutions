import java.util.*;
public class PerfectNumber {

	public static void main(String[] args) {
		System.out.println("Enter a number to find whether given number is perfect number or not:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int sum =0;
		for(int i =1; i<num; i++){
			if(num%i == 0){
				sum +=i;
			}
		}
		if(num == sum){
			System.out.println("Entered number "+num+" is a perfect number.");
		}
		else{
			System.out.println("Entered number "+num+" is not a perfect number.");
		}
		scan.close();
	}

}
