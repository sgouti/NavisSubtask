import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Mainpage {

	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		
		File file=new File("StorydetailsJiraAutoTask.xls");
		 Workbook Wb=Workbook.getWorkbook(file);
//		public Sheet TcSheet;
		Sheet sht=Wb.getSheet(0);
		int totalTc=sht.getRows();
		System.out.println(totalTc);
		for(int i=1;i<totalTc;i++)
		{
			String name=sht.getCell(0,i).getContents();
			System.out.println(name);
		}
		
	}	
	

}
