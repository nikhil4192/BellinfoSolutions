package sample;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "madam1";
		String rev ="";
		

			for(int j=s.length()-1;j>-1;j--){
			rev +=s.charAt(j);
			}
		if(s.equals(rev)){
			System.out.println("palindrome");
		}
		else{
			System.out.println("Not pal");
		}
	}

}
