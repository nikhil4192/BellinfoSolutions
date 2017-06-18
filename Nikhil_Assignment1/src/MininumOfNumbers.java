import java.util.*;
public class MininumOfNumbers {

	public static void main(String[] args) {
		
		int[] num = new int[4];
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter the 4 numbers for which you want to find the minimum value:");
		for(int i=0; i< num.length; i++){
			num[i] = scan.nextInt();
		}
		Arrays.sort(num);
		System.out.println("The minimum of 4 numbers is " +num[0]);
		scan.close();

	}

}
