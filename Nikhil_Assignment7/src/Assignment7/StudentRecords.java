package Assignment7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class StudentRecords {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String fileName = "students.xls";
		String path = System.getProperty("user.dir");
		String fullpath = path + File.separator + fileName;
		File f = new File(fullpath);
		System.out.println("Enter the number student you want to enter :");
		int num = scan.nextInt();
		String[] id = new String[num];
		String[] name = new String[num];
		String[] marks = new String[num];
		String[] fee = new String[num];
		Student s1 =new Student();
		for(int n=0;n<num;n++)
		{
		System.out.println("Enter the ID of the Student :");
		id[n] = scan.next();
		scan.nextLine();
		System.out.println("Enter the name of the Student :");
		name[n] = scan.nextLine();
		System.out.println("Enter the Marks of the Student :");
		marks[n]= scan.next();
		System.out.println("Enter the fee details of the Student :");
		fee[n] = scan.next();
		}
			WritableWorkbook wb = Workbook.createWorkbook(f);
			try {
				
				WritableSheet ws = wb.createSheet("Stud", 0);
				
				for(int i =0; i<num; i++){
					int c=0;	
						Label l1 = new Label(c, i, id[i]);
						Label l2 = new Label(c+1, i, name[i]);
						Label l3 = new Label(c+2, i, marks[i]);
						Label l4 = new Label(c+3, i, fee[i]);
						ws.addCell(l1);
						ws.addCell(l2);
						ws.addCell(l3);
						ws.addCell(l4);
					c++;
				}
				wb.write();
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					wb.close();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
			
		}
			
		
		
		


class Student{
	
	private int id;
	private String name;
	private double fee;
	
	
	public Student() {
	}

	public Student(int id, String name, double fee) {
		this.id = id;
		this.name = name;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
	
	
}
