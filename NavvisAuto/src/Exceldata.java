

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Exceldata
{
public void readexcel() throws BiffException, IOException
{
	File file=new File("");
	 Workbook Wb=Workbook.getWorkbook(file);
//	public Sheet TcSheet;
	Sheet sht=Wb.getSheet(0);
	int totalTc=sht.getRows();
}	
		
	
}
