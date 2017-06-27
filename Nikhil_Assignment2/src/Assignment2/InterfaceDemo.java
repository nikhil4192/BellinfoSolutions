package Assignment2;

public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dell d = new Dell();
		d.type();
		d.model();
		
		Lenovo l = new Lenovo();
		l.type();
		l.model();

	}

}
interface Computer{
	public void type();
	public void model();
}

abstract class Desktop implements Computer{
	public void type(){
		System.out.println("This is a Desktop");
	}
	
	abstract public void model();
}

abstract class Laptop implements Computer{
	public void type(){
		System.out.println("This is Laptop");
	}
	
	abstract public void model();
}

class Dell extends Desktop{
	
	public void model(){
		System.out.println("This is Dell Desktop");
	}
}

class Lenovo extends Laptop{
	public void model(){
		System.out.println("This is Lenovo Laptop");
	}
}