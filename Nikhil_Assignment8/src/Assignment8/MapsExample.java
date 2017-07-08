package Assignment8;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MapsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "Nikhil");
		map.put(1, "Kumar");
		map.put(4, "Vemula");
		map.put(3, "Ashish");
		System.out.println("Enter a value between 1 - 4 to get a key :");
		int i = scan.nextInt();
		if(map.containsKey(i)){
			System.out.println("Yes, this key exists.");
		}
		else{
			System.out.println("Sorry, No key exist with this key.");
		}
		System.out.println("Enter a value to verify certain value is exist or not (Try:Nikhil/Kumar/Vemula/Ashish)");
		String s=scan.next();
		if(map.containsValue(s)){
			System.out.println("Yes, this value exists.");
		}
		else{
			System.out.println("Sorry, No value exist with this key.");
		}
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>(map);
//		for(Entry<Integer, String> e:tmap.entrySet()){
//			System.out.println(e.getKey()+", "+e.getValue());
//		}
		System.out.println("*****************************************************************");
		System.out.println("The first and last element of the treeMap are :");
		System.out.println(tmap.firstEntry());
		System.out.println(tmap.lastEntry());
	}

}
