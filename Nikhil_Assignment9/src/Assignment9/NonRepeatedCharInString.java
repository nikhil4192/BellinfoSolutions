package Assignment9;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class NonRepeatedCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a strig to which you want to identify the repeated characters:");
		String s =scan.nextLine();
		int count=0;
		char temp;
		for(int i=0;i<s.length();i++){
			temp = (s.charAt(i));
			count=0;
			for(int j=0;j<s.length();j++){
			if(s.charAt(i)==s.charAt(j)){
				count++;
			}
			}
			if(count<2){
				System.out.println("The first non-repeated character in astring is "+temp);
				break;
			}
			
		}
		
			
		scan.close();
	}

}
