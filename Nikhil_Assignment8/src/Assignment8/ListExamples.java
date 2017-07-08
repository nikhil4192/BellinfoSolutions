package Assignment8;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for(int i =0;i<10;i++){
			int j= (int)(Math.random()*50+1);
			list.add(j);
		}
		System.out.println("Values in a Arraylist are : ");
		for(Integer d:list){
			System.out.print(d+" ");
		}
		Collections.reverse(list);
		System.out.println();
		System.out.println("************************************************");
		System.out.println("Reverse order of ArrayList are :");
		for(Integer d:list){
			System.out.print(d+" ");
		}
		Collections.sort(list);
		System.out.println();
		System.out.println("************************************************");
		System.out.println("Minimum element in the Array List is :");
		System.out.println(list.get(0));
	}

}
