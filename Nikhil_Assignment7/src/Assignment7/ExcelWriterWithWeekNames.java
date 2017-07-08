package Assignment7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelWriterWithWeekNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] week = new String[]{"Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		String fileName = "week1.xls";
		String path = System.getProperty("user.dir");
		String fullpath = path + File.separator + fileName;
		File f = new File(fullpath);
		try {
			WritableWorkbook myExcel = Workbook.createWorkbook(f);
			WritableSheet mySheet = myExcel.createSheet("mySheet", 0);
			Week[] wk = Week.values();
				for(int j=0; j<wk.length;j++){
					String s = (wk[j].toString());
					Label lj = new Label(0, j, s);
					mySheet.addCell(lj);
			}
			
			myExcel.write();
			myExcel.close();
			
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
		
		
		
		
	}

}

enum Week{
	SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
	Week(){
		
	}
}
