package Assignment3;

import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number of Students:");
		int num = scan.nextInt();
		int id,count=1;
		String name;
		double fee;
		char sec;
		Students[] stud = new Students[num];
		for(int i =0; i< num; i++){
			
			System.out.println("Enter student "+count+" ID:");
			id= scan.nextInt();
			scan.nextLine();
			System.out.println("Enter student "+count+" name:");
			name= scan.nextLine();
			System.out.println("Enter student "+count+" fee:");
			fee = scan.nextDouble();
			System.out.println("Enter student "+count+" section+:");
			sec = scan.next().charAt(0);
			count++;
			Students st = new Students(id, name, fee, sec);
			stud[i] = st;
		}
		System.out.println("****** Result*********\nId Name Fee Section");
		for(int i=0; i<num; i++){
			System.out.println(stud[i]);
		}	
		scan.close();
	}

}

class Students{
	
	int id;
	String name;
	double fee;
	char sec;
	
	Students(){
		
	}
	Students(int id, String name, double fee, char sec){
		this.id = id;
		this.name = name;
		this.fee = fee;
		this.sec = sec;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public char getSec() {
		return sec;
	}
	public void setSec(char sec) {
		this.sec = sec;
	}
	@Override
	public String toString() {
		return id +" " +name+" " +fee+" "+  sec;
	}
	
}
