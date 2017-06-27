package Assignment2;

public class ConstOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//We can overload the constructor.
		Vehicle v = new Vehicle();
		Vehicle v1 = new Vehicle(2);
	}

}
class Vehicle1{
	
	int wheels;
	
	Vehicle1(){
		System.out.println("This empty constructor");
	}
	
	Vehicle1(int a){
		this.wheels = a;
		System.out.println("This is argument contructor and ovrridden by empty constructor");
	}

}