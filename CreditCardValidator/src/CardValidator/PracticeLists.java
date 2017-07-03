package CardValidator;

import java.util.ArrayList;
import java.util.LinkedList;

public class PracticeLists {

	public static void main(String[] args) {
		int num = 1000000;
		ArrayList<String> al = new ArrayList<String>();
		LinkedList<String> ll = new LinkedList<String>();
		
		for(int i =0; i<num; i++){
			al.add("Nikhil");
			ll.add("Nikhil");
		}
		
		long startAl = System.currentTimeMillis();
		for(int i=70000; i<75000; i++){
			al.add(i+1000,"Nikhil");
		}
		long endAl = System.currentTimeMillis();
		System.out.println("ArrayList Insertion Time is : "+(endAl-startAl));
		
		long startll = System.currentTimeMillis();
		for(int i=70000; i<75000; i++){
			ll.add(i+1000,"Nikhil");
		}
		long endll = System.currentTimeMillis();
		System.out.println("LinkedList Insertion Time is : "+(endll-startll));
		
		System.out.println();
		
		long startAls = System.currentTimeMillis();
		for(int i=70000; i<75000; i++){
			al.get(i+1000);
		}
		long endAls = System.currentTimeMillis();
		System.out.println("ArrayList Search Time is : "+(endAls-startAls));
		
		long startLls = System.currentTimeMillis();
		for(int i=70000; i<75000; i++){
			ll.get(i+1000);
		}
		long endLls = System.currentTimeMillis();
		System.out.println("LinkedList Search Time is : "+(endLls-startLls));
		
		System.out.println();
		
		long startAld = System.currentTimeMillis();
		for(int i=70000; i<75000; i++){
			al.remove(i+1000);
		}
		long endAld = System.currentTimeMillis();
		System.out.println("ArrayList Deletion Time is : "+(endAld-startAld));
		
		long startLld = System.currentTimeMillis();
		for(int i=70000; i<75000; i++){
			ll.remove(i+1000);
		}
		long endLld = System.currentTimeMillis();
		System.out.println("LinkedList Deletion Time is : "+(endLld-startLld));
		
	}

}
