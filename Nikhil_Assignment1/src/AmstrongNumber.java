import java.util.*;
public class AmstrongNumber {

	public static void main(String[] args) {
		System.out.println("Please enter a number to find amstrong number:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int temp = num;
		int result = 0;
		int amstrong = 0;
		while(temp !=0){
			result = temp%10;
			amstrong += result*result*result;
			temp = temp/10;
		}
		if(amstrong == num){
			System.out.println("Entered number "+num+" is a amstrong number.");
		}
		else{
			System.out.println("Entered number "+num+" is not a amstrong number.");
		}
	}

}
