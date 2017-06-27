package Assignment2;

public class AccessSpecifiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.meth1();
		a.meth2();
		a.meth3();
		//a.meth4(); We can't access the meth4 because it is private method. Private can be accessed with in the same class

	}

}
class A{
	int c =10;
	public int a=10;
	protected int b = 10;
	private int d= 10;
	
	void meth1(){
		c = c+1;
		System.out.println(c);
	}
	public void meth2(){
		a += 2;
		System.out.println(a);
	}
	protected void meth3(){
		b += 3;
		System.out.println(b);
	}
	private void meth4(){
		d +=4;
		System.out.println(d);
	}
}