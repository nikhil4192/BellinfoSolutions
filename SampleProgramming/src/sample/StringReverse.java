package sample;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Nikhil Kumar";
		StringBuffer s1 = new StringBuffer();
		s1.append(s);
		s1 = s1.reverse();
		System.out.println(s1);
		
		String[] s2 = s.split("");
		for(int i=s2.length-1; i>=0; i--){
			System.out.print(s2[i]);
		}

	}

}
