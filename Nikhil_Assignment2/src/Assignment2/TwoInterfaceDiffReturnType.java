package Assignment2;

public class TwoInterfaceDiffReturnType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hotel h = new Hotel();
		h.hotels(15);
		h.hotel(18);

	}

}

interface Hyd1{
	public int hotels(int a);
}

interface Vizag1{
	public double hotel(double a);
}

class Hotel implements Hyd1,Vizag1{

	public int hotels(int a) {
		System.out.println("Hotels in Hyd are: "+a);
		return a;
	}

	public double hotel(double a) {
		System.out.println("Hotels in Vizag are: "+a);
		return a;
	}
	
}