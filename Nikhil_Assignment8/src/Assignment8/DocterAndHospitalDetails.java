package Assignment8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class DocterAndHospitalDetails {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doctor d1= new Doctor(1, "Nikhil", "Heart");
		Address ha1 = new Address("Legacy Circle", "Apt #C", "Herndon", "VA", 20171);
		Hospital h1 = new Hospital("Care", d1, ha1);
		Doctor d2= new Doctor(2, "Siva", "Kidney");
		Address ha2 = new Address("Point at Dulls", "Apt 11", "Ash Burn", "VA", 20172);
		Hospital h2 = new Hospital("Care", d2, ha2);
		Doctor d3= new Doctor(3, "Santhosh", "Lungs");
		Address ha3 = new Address("College Drive", "Harizons Appart", "Maryville", "MO", 64468);
		Hospital h3 = new Hospital("Aarogya", d3, ha3);
		List<Hospital> lh = new ArrayList<Hospital>();
		lh.add(h1);
		lh.add(h2);
		lh.add(h3);
 		for(Hospital h:lh){
			System.out.println(h);
		}
 		System.out.println("******************************************************************************");
 		eliminateDuplicateHsptls(lh);
 		System.out.println("******************************************************************************");
		nearByHospital(lh);
		System.out.println("******************************************************************************");
		nearBySpcHsptl(lh);
		System.out.println("******************************************************************************");
		hospitalDoctorList(lh);
		
		}

	public static void eliminateDuplicateHsptls(List<Hospital> lh){
		//Addind new hospitals
		Scanner scan = new Scanner(System.in);
				System.out.println("Please enter the hospital details you want to enter :");
				System.out.println("Please Enter the hospital name :");
				String hName = scan.nextLine();
				System.out.println("Enter the address1 of the hospital :");
				String add1 = scan.nextLine();
				System.out.println("Enter the address2 of the hospital :");
				String add2 = scan.nextLine();
				System.out.println("Enter the city in which the hospital lies :");
				String cty = scan.nextLine();
				System.out.println("Enter the State where the hospital is :");
				String st = scan.nextLine();
				System.out.println("Enter the zip code of the hospital :");
				int zp = scan.nextInt();
				Address a1 = new Address(add1, add2, cty, st, zp);
				Doctor ds1= new Doctor();
				
				Hospital hs1 = new Hospital(hName, ds1, a1);
				if(lh.contains(hs1)){
					System.out.println("Yes, we have this hospital in our list. Thank you for the information.");
				}
				else{
					System.out.println("Sorry, We don't have this hospital detail. Thank you for updation :");
					System.out.println("Please enter the remaining details about the doctor :");
					System.out.println("Enter the doctor Id :");
					int did= scan.nextInt();
					System.out.println(scan.nextLine());
					System.out.println("Enter the doctor name :");
					String dname = scan.nextLine();
					System.out.println("Enter the doctor specialization :");
					String dSpec = scan.nextLine();
					Doctor doc1 = new Doctor(did, dname, dSpec);
					Hospital newHos = new Hospital(hName, doc1, a1);
					lh.add(newHos);
					System.out.println("New Hospital is added sucessfully.");
				}
	}
	
	public static void nearByHospital(List<Hospital> lh){
		Scanner scan = new Scanner(System.in);
		//Near by hospital
				System.out.println("Identify the Hospital near by location.");
				System.out.println("Please enter the zip code to identify the nearest Hospital :");
				int zip = scan.nextInt();
				int a = zip;
				Hospital near = null;
				for(Hospital h:lh){
					if(Math.abs(zip-h.hospitalAddress.getZipCode())< a){
						a = Math.abs(zip-h.hospitalAddress.getZipCode());
						System.out.println(a);
						near = new Hospital(h.getHospitalName(), h.doc, h.hospitalAddress);
					}
				}
				System.out.println("The nearest hospital from the entered zip code is : "+near);
				
		}
	public static void nearBySpcHsptl(List<Hospital> lh){
		Scanner scan = new Scanner(System.in);
		//Near by specialist hospitals
		
				System.out.println("Let us check the near by hosiptal with required specialist doctor :");
				System.out.println("Enter the Zip :");
				int zip = scan.nextInt();
				System.out.println("Enter the illness :");
				String ill = scan.next();
				int a= zip;
				Hospital near = null;
				for(Hospital h:lh){
					if(ill.equals(h.doc.getSpecialization())){
						if(Math.abs(zip-h.hospitalAddress.getZipCode())< a){
							a = Math.abs(zip-h.hospitalAddress.getZipCode());
							System.out.println(a);
							near = new Hospital(h.getHospitalName(), h.doc, h.hospitalAddress);
						}
					}	
				}
				System.out.println("The nearest hospital from the entered zip code is : "+near);	
	}
	public static void hospitalDoctorList(List<Hospital>lh){
		Scanner scan = new Scanner(System.in);
		HashMap<String, List> hm = new HashMap<String, List>();
		for(Hospital h:lh){
//			Doctor d = h.doc;
//			Address a = h.hospitalAddress;
//			Hospital hptl = new Hospital(d, a);
			List<Hospital> kum = new ArrayList<Hospital>();
			for(String s:hm.keySet()){
				if(s.equals(h.getHospitalName())){
					kum = hm.get(s);
					kum.add(h);
				}
			}
			Set<String> set=hm.keySet();
			if(!(set.contains(h.getHospitalName())))
				kum.add(h);
			
			hm.put(h.getHospitalName(), kum);
			}
		
		
		System.out.println("Please enter the hospital name :");
		String hptlName = scan.next();
		for(String h:hm.keySet()){
			if(h.equals(hptlName)){
				System.out.println(hm.get(h));
		}
		}
	
	}
	public static void spcialHospitals(List<Hospital> lh){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the sepcialist required :");
		String illName = scan.next();
		for(Hospital h:lh){
			if(illName.equals(h.doc.getSpecialization())){
				System.out.println(h.getHospitalName());
			}
		}
		scan.close();
	}
}

class Hospital{
	
	private String hospitalName;
	Doctor doc;
	Address hospitalAddress;

	public Hospital(Doctor doc, Address hospitalAddress) {
		this.doc = doc;
		this.hospitalAddress = hospitalAddress;
	}

	public Hospital(String hospitalName, Doctor doc, Address hospitalAddress) {
		this.hospitalName = hospitalName;
		this.doc = doc;
		this.hospitalAddress = hospitalAddress;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hospitalAddress == null) ? 0 : hospitalAddress.hashCode());
		result = prime * result
				+ ((hospitalName == null) ? 0 : hospitalName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (hospitalAddress == null) {
			if (other.hospitalAddress != null)
				return false;
		} else if (!hospitalAddress.equals(other.hospitalAddress))
			return false;
		if (hospitalName == null) {
			if (other.hospitalName != null)
				return false;
		} else if (!hospitalName.equals(other.hospitalName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", doc=" + doc
				+ ", hospitalAddress=" + hospitalAddress + "]";
	}
	
}

class Doctor{
	
	private int docId;
	private String name;
	private String Specialization;
	
	public Doctor() {
		
	}

	public Doctor(int docId, String name, String specialization) {
		this.docId = docId;
		this.name = name;
		this.Specialization = specialization;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Specialization == null) ? 0 : Specialization.hashCode());
		result = prime * result + docId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (Specialization == null) {
			if (other.Specialization != null)
				return false;
		} else if (!Specialization.equals(other.Specialization))
			return false;
		if (docId != other.docId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", name=" + name
				+ ", Specialization=" + Specialization + "]";
	}
	
	
}

class Address{
	
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zipCode;

	public Address(String address1, String address2, String city, String state,
			int zipCode) {
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + zipCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode + "]";
	}
	
}