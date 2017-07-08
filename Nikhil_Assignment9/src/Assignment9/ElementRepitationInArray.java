package Assignment9;


import java.util.Scanner;

public class ElementRepitationInArray {

	public static void main(String[] args) {
		// TODO Auto-generated, method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of values you want to enter :");
		int n = scan.nextInt();
		int[] num =new int[n];
		System.out.println("enter the values :");
		for(int i=0;i<n;i++){
			num[i] = scan.nextInt();
		}
		int temp,count=0,maxCount=0,maxValue=0;
		//Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i=0;i<num.length;i++){
			temp = num[i];
			count=0;
			for(int j=0;j<num.length;j++){
				if(num[i]==num[j]){
					count++;
				}
				if(count>maxCount){
					maxCount = count;
					maxValue = temp; 
				}
			}
			//map.put(temp, count);
		}
//		for(Entry<Integer, Integer> i:map.entrySet()){
//			System.out.println(i.getKey()+" "+i.getValue());
//		}
		System.out.println("The most repeated value is "+maxValue+" and it is repeated for "+maxCount+" times.");
	scan.close();
	}
}
