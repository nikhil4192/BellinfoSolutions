package sample;

public class RepeatedMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7,8,9,1,4,1,2,4,1,2,1,5,5,5,5,5,5,5};
		int repVal=0,max=0,temp =0;
		for(int i=0;i<num.length;i++){
			int count =0;
			temp = num[i];
			for(int j=0;j<num.length;j++){
				if(temp == num[j]){
					count++;
				}
			}
			if(count>max){
				max = count;
				repVal = temp;
			}
		}
		System.out.println(repVal+" "+max);
	}

}
