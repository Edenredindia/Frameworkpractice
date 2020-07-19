package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	//
	public ExcelDataProvider()
	{
		File src = new File("./TestData/Testdata.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel data"+e.getMessage());
		}
	}
	
	public String getstringdata(int sheetindex,int row,int cell)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public double getnumericgdata(int sheetindex,int row,int cell)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(cell).getNumericCellValue();
	}
	

}
