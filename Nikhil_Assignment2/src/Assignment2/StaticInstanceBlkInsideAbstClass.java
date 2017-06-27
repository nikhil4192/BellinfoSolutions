package Assignment2;

public class StaticInstanceBlkInsideAbstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotels4 h = new StarHotels();
		h.hotels(25);
		h.fiveStarHotels(10);	
	}

}

interface Hyd4{
	public int hotels(int a);
	public int fiveStarHotels(int a);
}

abstract class Hotels4{
	int a = 10;
	static int b =10;
	{
		a+= 10;
		System.out.println("a incremented by 10");
	}
	static {
		b+= 10;
		System.out.println("Ststic value b incremented by 10");
	}
	public int hotels(int a){
		System.out.println("Number of hotels in Hyderabad are: "+a);
		return a;
	}
	abstract int fiveStarHotels(int a);
	
}

class StarHotels extends Hotels4{
	public int fiveStarHotels(int a){
		System.out.println("Number of Five Stars Hotels in hyderabad are: "+a);
		return a;
	}
}



