package Assignment2;

public class TwoInterfacesWithSameReturnType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotels h1 = new Hotels();
		h1.hotels(12);	
	}
}

interface Hyd{
	public int hotels(int a);
}

interface Vizag{
	public int hotels(int a);
}

class Hotels implements Hyd,Vizag {
		
	public int hotels(int a){
		System.out.println("Hotels in Hyderbad & Vizag are: "+a);
		return a;

	}
}