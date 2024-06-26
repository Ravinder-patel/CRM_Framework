package DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Create the object of java physical file by using FIS
		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Excel files\\VTigers.xlsx");
		// Open Work Book in read mode
		Workbook wb = WorkbookFactory.create(fis);
		// Get the control of the sheet
		Sheet Mobiles = wb.getSheet("Mobiles");
		// Get the last row number
		int lastRow = Mobiles.getLastRowNum();

		for (int i = 1; i <= lastRow; i++) {
			// Get the control over the Row
			Row row = Mobiles.getRow(i);
			// Get the control over the Cell
			Cell brand = row.getCell(0);
			Cell model = row.getCell(1);
			System.out.println(brand + "\t" + model); // for tab space we use "\t"
		}

		// close the workbook
		wb.close();
	}

}
