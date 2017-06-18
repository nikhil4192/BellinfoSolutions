import java.util.*;
public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println("Please enter a number to be find weather palindrome or not:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int temp = num;
		int revNum = 0;
		while(temp !=0){
			int i = temp%10;
			revNum = revNum*10+i;
			temp = temp/10;
		}
		if(num == revNum){
			System.out.println("Entered Number "+num+" is a palindrome number.");
		}
		else{
			System.out.println("Entered Number "+num+" is not a palindrome number.");
		}
		scan.close();
	}

}
