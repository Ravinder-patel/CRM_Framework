package DDT_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteBackTheDataToExcel {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.out.println("Main Started");
		
		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Excel files\\ReadExcelBasedOnCondition.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cellData = row.createCell(4); // specify the cell index
		cellData.setCellType(CellType.STRING); // specify the cell data type
		cellData.setCellValue("PASS");	// Enter the data into the cell
		
		FileOutputStream fos = new FileOutputStream("E:\\Softwares\\DDT Excel files\\ReadExcelBasedOnCondition.xlsx");
		wb.write(fos); // write() Open the workbook in write mode to save the changes
		wb.close();

		System.out.println("Executed");
		System.out.println("Main Ended");

	}

}
