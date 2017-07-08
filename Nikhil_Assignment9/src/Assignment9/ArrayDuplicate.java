package Assignment9;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class ArrayDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of values you want to enter into an array : ");
		int n =scan.nextInt();
		int[] num = new int[n];
		System.out.println("Enter the values :");
		for(int i=0;i<n;i++){
			num[i]=scan.nextInt();
		}
		int count = 0,temp=0;
		Map<Integer, Integer> ma = new TreeMap<Integer, Integer>();
		for(int i=0;i<num.length;i++){
			temp = num[i];
			count= 0;
			for(int j=0;j<num.length;j++){
				if(num[i]==num[j]){
					count++;
				}
			}
			ma.put(temp, count);
		}
		for(Entry<Integer, Integer> i:ma.entrySet()){
			if(i.getValue()>=2){
			System.out.println("Number :"+i.getKey()+", Repeated "+i.getValue()+" of times.");
			}
		}
		scan.close();
	}

}
