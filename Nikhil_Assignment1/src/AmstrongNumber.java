import java.util.*;
public class AmstrongNumber {

	public static void main(String[] args) {
		System.out.println("Please enter a number to find amstrong number:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int temp = num;
		int result = 0;
		int count = String.valueOf(num).length();
		int amstrong=0;
		while(temp !=0){
			result = temp%10;
			int x = 1;
			for(int i=1; i<=count;i++){
			x *= result;
			}
			temp = temp/10;
			amstrong += x;
		}
		if(amstrong == num){
			System.out.println("Entered number "+num+" is a amstrong number.");
		}
		else{
			System.out.println("Entered number "+num+" is not a amstrong number.");
		}
		scan.close();
	}
	
}
