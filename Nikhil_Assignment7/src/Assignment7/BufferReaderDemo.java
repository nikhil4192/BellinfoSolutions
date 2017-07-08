package Assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BufferReaderDemo {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "nikhil.txt";
		String path = System.getProperty("user.dir");
		String fullPath = path + File.separator + fileName;
		FileReader fr = new FileReader(fullPath);
		BufferedReader br = new BufferedReader(fr);
		String text="";
		String doc = "";
		try {
			while((text=br.readLine()) != null){
				doc = text;
				System.out.println(text);
				//text = br.readLine(); 
			}
			//System.out.println(siva);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{ try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println();
		//System.out.println(siva);
		List< String> slist = Arrays.asList(doc.split("\\s+"));
		System.out.println(slist.size());
		
		

	}

}
