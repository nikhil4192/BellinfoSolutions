package Assignment9;

import java.util.Arrays;
import java.util.Scanner;

public class StockArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] stock = new double[30];
		double maxProfit=Double.MIN_VALUE;
		double minIndex =0,maxIndex=0;
		double d = Double.MAX_VALUE;
		double m = Double.MIN_VALUE;
		for(int i=0;i<30;i++){
			stock[i] = Math.ceil(Math.random()*150+1);
		}
		for(int i=0;i<30;i++){
			System.out.print(stock[i]+" ");
		}
//		for(int i=0;i<stock.length-1;i++){
//			if(stock[i]<d){
//				d=stock[i];
//			}
//		}
//		for(int i =0;i<stock.length;i++){
//			minIndex++;
//			if(stock[i]==d){
//				break;
//			}
//		}
//		for(int i=minIndex;i<stock.length;i++){
//			if(stock[i]>m){
//				m=stock[i];
//			}
//		}
//		for(int i =minIndex;i<stock.length;i++){
//			maxIndex++;
//			if(stock[i]==m){
//				break;
//			}
//		}
//		System.out.println();
//		System.out.println("Maximum selling value of the share is : "+m);
//		System.out.println("Minimum buying value of the share is : "+d);
//		maxProfit = m-d;
//		System.out.println("We can gain maximum profit if we can buy at "+d+" and sell at "+m+" by which we can gain a profit of "+maxProfit);
//	
		
	for(int i=0;i<stock.length-1;i++){
		for(int j=i;j<stock.length;j++){
			if((stock[j]-stock[i])>maxProfit){
				maxProfit=stock[j]-stock[i];
				m=stock[j];
				d=stock[i];
			}
			
		}
	}
	System.out.println();
	System.out.println("Maximum selling value of the share is : "+m);
	System.out.println("Minimum buying value of the share is : "+d);
	maxProfit = m-d;
	System.out.println("We can gain maximum profit if we can buy at "+d+" and sell at "+m+" by which we can gain a profit of "+maxProfit);
	}

}
