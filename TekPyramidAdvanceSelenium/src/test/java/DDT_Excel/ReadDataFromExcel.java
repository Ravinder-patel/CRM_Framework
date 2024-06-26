package DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1: Get the excel physical file location or the path of the java object file
		FileInputStream fis=new FileInputStream("E:\\Softwares\\DDT Excel files\\VTigers.xlsx");
		// Open Work Book in read mode
		Workbook wb = WorkbookFactory.create(fis);
		// Get the controll of the sheet
		Sheet sh = wb.getSheet("Sheet1");
		// Get the controll of the "2nd" Row
		Row row = sh.getRow(1); //index 1 row 2
		// Get the controll of the "3rd" Cell
		Cell cell = row.getCell(2);
	
		// return the object in the cell
		String cellValue=cell.getStringCellValue();
		System.out.println(cellValue); //printing cell value
//		double cellValue2 = cell.getNumericCellValue();	//IlligalStateException
//		System.out.println(cellValue2);
		Cell cell1 = row.getCell(1);
		String cellValue1 = cell1.toString();
		System.out.println(cellValue1);
		
		// METHOD CHAINING
		//System.out.println(wb.getSheet("Sheet1").getRow(3).getCell(1).getNumericCellValue());
		
		// close the workbook
		wb.close();

	}

}
