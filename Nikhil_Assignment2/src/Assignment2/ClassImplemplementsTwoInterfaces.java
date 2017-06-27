package Assignment2;

public class ClassImplemplementsTwoInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//We cannot create a object for an abstract class but we have a way to do so
		//we need to initiate an anonymous block where we have to declare the abstract methods inside the block
		//after the object declaration of the abstract class. By this we can create and use the object of 
		//abstract class.
		
		Tablet t = new Tablet() {
			
			public void features() {
				System.out.println("You can Call");
			}
			
			public void cost() {
				System.out.println("It is $400.");
			}
		};
		t.type1();
		t.model1();
		t.cost();
		t.features();
	}

}

interface Mobile1{
	public void type1();
	public void features();
}

interface Computer1{
	public void model1();
	public void cost();
}
abstract class Tablet implements Mobile1,Computer1{
	public void type1(){
		System.out.println("This is Mobile.");
	}
	public abstract void features();
	public void model1(){
		System.out.println("This is Computer");
	}
	public abstract void cost();
}