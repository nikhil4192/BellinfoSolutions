package Assignment9;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class DuplicateValueString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a strig to which you want to identify the repeated characters:");
		String s =scan.nextLine();
		int count=0;
		char temp;
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		for(int i=0;i<s.length();i++){
			temp = (s.charAt(i));
			count=0;
			for(int j=0;j<s.length();j++){
			if(s.charAt(i)==s.charAt(j)){
				count++;
			}
			}
			map.put(temp, count);
		}
		for(Entry<Character, Integer> c:map.entrySet()){
			if(c.getValue()>=2){
			System.out.println("Character : "+c.getKey()+" ,Repeats :"+c.getValue()+" times");
			}
			}
			
		scan.close();
	}

}
