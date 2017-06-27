package Assignment2;

public class ParentAndChildC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		P p = new C();
		// We can access the scope of all the parent class variables and methods by the parent reference variable
		//but when we override the method of parent class by the child class then the method of child class will
		//be executed
		p.method1();
		p.method2();
		System.out.println(p.age);
		System.out.println(p.name);
		//We cannot access this method because we dont have the reference variable of child class so the methods which
		//are not overriden by the super/parent class will not be available.
		//p.method3();
	}

}

class P{
	int age = 10;
	String name = "Nikhil";
	
	public void method1(){
		System.out.println("I'm a parent class");
	}
	public void method2(){
		System.out.println("I'm older class");
	}
}

class C extends P{
	int age=15;
	String nmae= "Vemula";
	
	public void method1(){
		System.out.println("I'm Child class");
	}
	
	public void method3(){
		System.out.println("I'm Younger class");
	}
}