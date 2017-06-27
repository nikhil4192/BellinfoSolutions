package Assignment2;

public class ConstOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Yes we can override the constructor in because to do so we need to inherit the super class with the 
		//sub class and constructor will be called with the same name of class and we can only override a methods 
		//only if we can duplicate the signature of the method which can't be possible.
		
		// So the solution for this is we can use the Super key word to overcome the problem.
		Vehicle v = new Vehicle();
		Vehicle v1 = new Vehicle(2);
		Type t = new Type(); 
	}

}

class Vehicle{
	
	int wheels;
	
	Vehicle(){
		System.out.println("This empty constructor");
	}
	
	Vehicle(int a){
		this.wheels = a;
		System.out.println("This is argument contructor and ovrridden by empty constructor");
	}

}
class Type extends Vehicle{
	
	String name;
	Type() {
		super();
		// TODO Auto-generated constructor stub
	}
}
