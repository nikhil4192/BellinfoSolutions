package Assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<10;i++){
			int j = (int)(Math.random()*50+1);
			set.add(j);
		}
		System.out.println("Values in the Hashset are :");
		for(Integer i:set){
			System.out.print(i+" ");
		}
		List<Integer> list1 = new ArrayList<Integer>(set);
		Collections.sort(list1);
		System.out.println();
		System.out.println("************************************************");
		System.out.println("Minimum value of Hashset is :");
		System.out.println(list1.get(0));
	}

}
