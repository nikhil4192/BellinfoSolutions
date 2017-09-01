package sample;

import java.util.ArrayList;
import java.util.List;

public class PowerOfTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {10,0,2,160,1};
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<num.length; i++){
			
			
			if(num[i]==1 || num[i] == 10){
				list.add(num[i]);
			}
			else if(num[i]!=0 && num[i]%10 == 0){
				list.add(num[i]);
			}
			
		}
		for(int n:list){
		System.out.println(" "+n);
		
		}
	}
}
