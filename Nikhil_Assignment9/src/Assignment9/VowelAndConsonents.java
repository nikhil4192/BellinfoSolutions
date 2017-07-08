package Assignment9;

import java.util.Scanner;

public class VowelAndConsonents {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a String :");
		String s =scan.nextLine();
		int vowel=0,con=0;
		String[] st = (s.replaceAll(" ", "")).split("");
		for(int i=0;i<st.length;i++){
			if(st[i].equals("a")||st[i].equals("e")||st[i].equals("i")||st[i].equals("o")||st[i].equals("u")||
					st[i].equals("A")||st[i].equals("E")||st[i].equals("I")||st[i].equals("O")||st[i].equals("U")){
				vowel++;
			}
			else{
				con++;
			}
		}
		System.out.println("Number of vowels in the String are : "+vowel);
		System.out.println("Number of Consonents in the String are : "+con);
		scan.close();
	}

}
