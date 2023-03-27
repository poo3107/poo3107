package testUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFiles {
	static String data;
	
	public static String fetchDataFromExcel( int row, int cell) throws EncryptedDocumentException, IOException 
	{
		//String path = "src/test/resources/Files/ExcelData.xlsx";
		
		String path = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"Files"+File.separator+"ExcelData.xlsx";
		FileInputStream file = new FileInputStream(path);
		Cell c= WorkbookFactory.create(file).getSheet("login").getRow(row).getCell(cell);
		CellType type = c.getCellType();    // to read the type of cell
		
		if (type==CellType.STRING)
		{
			data = c.getStringCellValue();
		}
		else if (type==CellType.NUMERIC)
		{
			double d= c.getNumericCellValue();   //1111
			data = Double.toString(d);        //"1111"
		}
		
		else if(type==CellType.BLANK)
		{
			System.out.println("you are trying to get the data from empty cell");
		}
		return data;
	}
		


}
