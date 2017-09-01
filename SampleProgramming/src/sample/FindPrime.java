package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num ={1,2,25,13,6,91};
		 ArrayList<Integer> list = new ArrayList<Integer>();

	        // loop through the numbers one by one
	        for (int n = 0; n < num.length; n++) {
	            boolean prime = true;
	            // analyzes if n is prime

	            for (int j = 2; j < num[n]/2; j++) {
	                if (num[n] % j == 0) {
	                    prime = false;
	                    break; // exit the inner for loop
	                    }
	            }
	            if (prime && num[n] != 1) {
	                list.add(num[n]);
	            }
	        }
	        for (int i : list) {
	            System.out.println(i + " ");
	        }
	}
}