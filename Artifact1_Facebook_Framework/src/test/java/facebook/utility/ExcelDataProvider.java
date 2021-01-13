package facebook.utility;

import java.io.File;
import java.io.FileInputStream;




import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File scr = new File("./TestData/Data.xlsx");
		try 
		{
		FileInputStream fis = new FileInputStream(scr);
		 wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e)
		{
		
			System.out.println("File Not Found"+e.getMessage());
		}
	}
	
	public String ReadValuefromfirstrowcolumn(String SheetName, int RowNumber ,int CellNumber)	
	{
		return wb.getSheet(SheetName).getRow(RowNumber).getCell(CellNumber).getStringCellValue();
	}
	
	public String ReadValuefromfirstrowcolumn(int SheetNumber, int RowNumber ,int CellNumber)	
	{
		return wb.getSheetAt(SheetNumber).getRow(RowNumber).getCell(CellNumber).getStringCellValue();
	}
}
