package Assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReplaceWord {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "nikhil.txt";
		String path = System.getProperty("user.dir");
		String fullPath = path + File.separator + fileName;
		FileReader fr = new FileReader(fullPath);
		BufferedReader br = new BufferedReader(fr);
		String text="";
		String temp="";
		try {
			while((temp=br.readLine())!=null){
				System.out.println(temp);
				text = temp;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		text = text.replaceAll(" is ", " is(changed) ");
		System.out.println("Replaced the text 'is' with 'is(changed)' : ");
		System.out.println(text);
	}

}
