package Assignment2;

public class StaticAndInstanceBlkAndDftConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// When ever a code execute it search for the static block hence the main method is static block it comes
		//to the main method.
		//For this particular program after the entering into the main method it initalizes the object for
		//the child class and then after the variable declaration and intialization will be executed then it 
		//checks for any static blocks and executes that block and then after checks for the instance blocks
		//and then after it executes the constructor.
		Child c = new Child();
		c.method();

	}

}

class Child{
	int a;
	static int b;
	Child(){
		System.out.println("This is constructor methodx");
	}
	{
		a += 10;
		System.out.println("a is incremented by 10");
	}
	static{
		b += 10;
		System.out.println("b is incremented by 10");
	}
	public void method(){
		System.out.println("values of a & b are: "+a+" "+b);
	}
}
