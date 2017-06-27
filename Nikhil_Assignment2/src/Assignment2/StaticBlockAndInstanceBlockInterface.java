package Assignment2;

public class StaticBlockAndInstanceBlockInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel2 h2 = new Hotel2();
		h2.hotel(15);

	}

}

interface Hyd2{
	
	static int a = 10;
// We cannot create a instance block inside a interface because interface only accept
// a method stubs, with return type and arguments but not the methods.
//	{
//	int a=10;
//	a+=10;
//	System.out.println(a);
//	}
	
// We cannot create a Static block inside a interface because interface only accept
// a method stubs, with return type and arguments but not the methods.
//	static{
//		a+= 10;
//		System.out.println(a);
//	}
}

interface Vizag2{
	public double hotel(double a);
}

class Hotel2 implements Hyd2,Vizag2{


	@Override
	public double hotel(double a) {
		System.out.println("Hotels in Vizag are: "+a);
		return a;
	}
	
}