package assignmentHotel;
import java.lang.reflect.Array;
import java.util.*;

public class DestinationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Destinations informations
				//1st Destination
//				String[] d1Hotels = {"Hyat","Prestige","Raheja"};
//				double[] d1Cost = {200.00,350.50,500.60};
//				int[] d1Days = {3,5,8};
//				Destinations hydDest = new Destinations("Hyd", "TG",d1Hotels ,d1Cost ,d1Days);
//				//2nd Destination
//				String[] d2Hotels = {"Amaravati","Sagar","Tripta"};
//				double[] d2Cost = {280.00,550.50,600.60};
//				int[] d2Days = {2,5,10};
//				Destinations AmarDest = new Destinations("Amaravati", "AP",d2Hotels ,d2Cost ,d2Days);
//				//3rd Destination
//				String[] d3Hotels = {"Hyatt1","ALLInONE","Extended"};
//				double[] d3Cost = {210.00,750.50,590.60};
//				int[] d3Days = {3,5,8};
//				Destinations goaDest = new Destinations("Goa", "MT",d3Hotels ,d3Cost ,d3Days);
//				
				// Hyd in TG and Pakage Details:
				 //     1. Hyat - 200 - 3 days package
				//      2. Prestigate - 350.50 5 days package
				
//				Destinations[] holidaySpots = new Destinations[3];
//				holidaySpots[0] = hydDest;
//				holidaySpots[1] = AmarDest;
//				holidaySpots[2] = goaDest;
//				
				// Let the customer enter his destination, so that we display the package avaliable.
				
//				System.out.println("Welcome to our website, Please enter your destination ?");
//				Scanner scan = new Scanner(System.in);
//				String customerDest = scan.next();
//				boolean found = false;
//				for(int i=0; i<holidaySpots.length;i++){
//					Destinations d = holidaySpots[i];
//					if(customerDest.equals(d.getName())){
//						found  = true;
//						System.out.println("Good News...we found your destination with awesome package. Here are the details");
//						System.out.println(d.toString());
//						break;
//					}
//				}
//
//				if(!found){
//					System.out.println("Ohh...Sorry, We couldn't find your destination. Please check beck.");
//				}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many destination do you want to enter:");
		int destCount = scan.nextInt();
		Destinations[] dest = new Destinations[destCount];
		for(int i=0; i<dest.length; i++){
		System.out.println("Please enter the Destination name:");
		String name = scan.next();
		System.out.println("Please enter the Destination location:");
		String location = scan.next();
		System.out.println("Please enter the number of hotel available at the Destination location:");
		int destHotelCount = scan.nextInt();
		System.out.println("please enter the hotel name:");
		String hotelName[]=new String[destHotelCount];
		for(int h=0; h<destHotelCount; h++){
			hotelName[h]= scan.next(); 
		}
		System.out.println("please enter the Package details name:");
		double packageCost[]= new double[destHotelCount];
		for(int p=0; p<destHotelCount; p++){
			packageCost[p]= scan.nextDouble(); 
		}
		System.out.println("please enter the number of days:");
		int packageDays[]= new int[destHotelCount];
		for(int d=0; d<destHotelCount; d++){
			packageDays[d]= scan.nextInt();
		}
		 Destinations des = new Destinations(name, location, hotelName, packageCost, packageDays);
		 dest[i] = des;

		}
		
		System.out.println("Welcome to our website, Please enter your destination ?");
		String customerDest = scan.next();
		boolean found = false;
		for(int i=0; i<dest.length;i++){
			Destinations d = dest[i];
			if(customerDest.equals(d.getName())){
				found  = true;
				System.out.println("Good News...we found your destination with awesome package. Here are the details");
				System.out.println(d.getName() + " is in " + d.getLocation()+ " and Packages Detail are:\n"+d.toString());
				break;
			}
		}

		if(!found){
			System.out.println("Ohh...Sorry, We couldn't find your destination. Please check beck.");
		}
				
	}

}

class Destinations {
	private String name;
	private String location;
	private String[] hotels;
	private double[] packageCost;
	private int[] noOfDays;
	
	Destinations(){
		
	}
	
	Destinations(String name, String location, String[] hotels, double[] cost, int[] days){
		this.name = name;
		this.location = location;
		this.hotels = hotels;
		packageCost = cost;
		noOfDays = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String[] getHotels() {
		return hotels;
	}

	public void setHotels(String[] hotels) {
		this.hotels = hotels;
	}

	public double[] getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double[] packageCost) {
		this.packageCost = packageCost;
	}

	public int[] getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int[] noOfDays) {
		this.noOfDays = noOfDays;
	}
	// Hyd in TG and Pakage Details:
	 //     1. Hyat - 200 - 3 days package
	//      2. Prestigate - 350.50 5 days package
	@Override
	public String toString() {
			
		String ret = "";
		int count =1;
		for(int i=0;i<hotels.length;i++){
			
			 ret =  ret + count+". Hotel :"+hotels[i] +" - Package Cost : " +Double.toString(packageCost[i]) +
					 " - Number of Days:"+Integer.toString(noOfDays[i])+"\n";
				 count++;
	}
		return ret;
			
	}
	}
	
	
	
	