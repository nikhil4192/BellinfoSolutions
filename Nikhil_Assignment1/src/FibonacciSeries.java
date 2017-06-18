import java.util.*;
public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println("Enter a number to find the fibonacci series:");
		Scanner scan = new Scanner(System.in);
		long num =  scan.nextInt();
		long i =0;
		long j =1;
		long fab =0;
		int count =2;
		System.out.print(i+" ,"+j);
		do{
			fab = i+j;
//			if(fab>num){
//				break;
//			}
			i = j;
			j = fab;
			count ++;
			System.out.print(" ,"+fab);
		}while(count<num);
		scan.close();
	}

}
