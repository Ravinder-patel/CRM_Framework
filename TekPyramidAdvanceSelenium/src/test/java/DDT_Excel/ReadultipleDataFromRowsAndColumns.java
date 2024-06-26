package DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadultipleDataFromRowsAndColumns {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Excel files\\VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Mobiles = wb.getSheet("Mobiles");
		int lastRow = Mobiles.getLastRowNum();

		for (int i = 1; i <= lastRow; i++) 
			{
			Row row = Mobiles.getRow(i);
			
			short lastCell = row.getLastCellNum();
			for(int j=0;j<lastCell;j++)
				{
				Cell cellData = row.getCell(j);
				System.out.print(cellData+"\t");
				}
			System.out.println();
		}
		wb.close();
	}
}
