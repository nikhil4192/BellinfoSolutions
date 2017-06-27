package Assignment2;

public class PassByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//java allows pass by value
		Nikhil n = new Nikhil();
		System.out.println(n.myName);
		n.add(n);
		System.out.println("Hi "+n.myName);
		
		Vemula ve = new Vemula();
		System.out.println(ve.nyName);
		ve.add("Hello");
		System.out.println(ve.nyName);
	}

}

class Nikhil{
	String myName = "nikhil";
	
	public void add(Nikhil name){
	myName = myName+ " kumar";
	System.out.println("Inside the method: "+myName);
	}
	
}

class Vemula{
	String nyName ="vemula";
	public void add(String nyName){
		nyName = nyName+" Kumar";
		System.out.println("Inside the method : "+nyName);
	}
}