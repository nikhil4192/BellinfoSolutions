package Assignment6;

import java.io.EOFException;

public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "This is a java class";
		
		
		//How many words in a String?
		String[] word = s.split(" +");
		System.out.println("Number of words in the String are : "+word.length);
		
		//Length of the String?
		System.out.println("Length of the String is : "+s.length());
		
		//How many single character words in the String?
		int n=0;
		for(int i=0;i<word.length;i++){
			if(word[i].length() == 1){
				n++;
			}
		}
		System.out.println("Number of single character words in the String are : "+ n);
		
		//Reverse each word ?
		System.out.print("The Reverse of each word is : ");
		String revWord;
		String[] revLetter; 
		for(int i=0;i< word.length;i++){
			revWord = word[i];
			revLetter = revWord.split("");
			for(int j =revLetter.length-1; j>-1; j--){
				System.out.print(revLetter[j]);
			}
			System.out.print(" ");
		}
		System.out.println();
		
		
		//Reverse entire String
		System.out.print("The Reverse entire String is : ");
		for(int i=word.length-1; i>-1; i--){
			revWord = word[i];
			revLetter = revWord.split("");
			for(int j=revLetter.length-1;j>-1;j--){
				System.out.print(revLetter[j]);
			}
			System.out.print(" ");
		}
		System.out.println();
		
		
		//Replace java with SQL
		System.out.println("The string after Replacing java with SQL is : "+s.replace("java", "sql"));
		
		//Letter at the center
		System.out.println("The Letter at the center is :"+ s.charAt(s.length()/2));
		
		//Index of j at center
		System.out.println("The Index of j at center is : "+s.indexOf("j"));
		
		//Number of times each letter repeated
		System.out.println("Number of times each letter repeated is:");
		revLetter = (s.replaceAll(" ", "")).split("");
		String[] temp = revLetter;
		for(int i=0;i<revLetter.length;i++){
			int count =0;
			for(int j=0;j<temp.length; j++){
			if(revLetter[i].equals(temp[j])){
				count++;
			}	
		}
		System.out.println(revLetter[i]+" repeats "+count);
	}
		
		//Identify a letter which is not repeated
		System.out.print("letter which is not repeated is : ");
		revLetter = (s.replaceAll(" ", "")).split("");
		String[] temp1 = revLetter;
		for(int i=0;i<revLetter.length;i++){
			int count =0;
			for(int j=0;j<temp1.length; j++){
			if(revLetter[i].equals(temp1[j])){
				count++;
			}	
		}
			if(count==1){
				System.out.print(revLetter[i]+"  ");
			}
	}
		System.out.println();
		
		//Identify the index of each word
		System.out.print("The index of each word is : ");
		int k =0;
		for(int i =0; i<word.length; i++){
			revWord = word[i];
			System.out.print(s.indexOf(revWord, k)+" ");
			k +=revWord.length();
		}
		System.out.println();
		
		
		//Convert the entire String in to upper case ?
		System.out.println("The Upper caese of String is : "+s.toUpperCase());
		
		
		
		}
	
		

}
