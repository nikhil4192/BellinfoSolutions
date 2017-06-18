import java.util.*;
public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println("Please enter the number to be reversed:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int temp = num;
		int revNum =0;
		while(temp != 0){
			int i = temp%10;
			revNum = revNum*10+i;
			temp = temp/10;
		}
		System.out.println("Reversed number of "+num+" is "+revNum);
		scan.close();
	}
	

}
