package Assignment7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferWritererDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String text = "I'm Nikhil Kumar. This is My first assignment regarding the files. ";
		System.out.println("please enter the text you want to add in the file :");
		if(scan.hasNext()){
			text += scan.nextLine();
		}
		String fileName = "nikhil.txt";
		String path = System.getProperty("user.dir");
		String fullPath = path + File.separator + fileName;
		FileWriter fw = new FileWriter(fullPath);
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(text);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
