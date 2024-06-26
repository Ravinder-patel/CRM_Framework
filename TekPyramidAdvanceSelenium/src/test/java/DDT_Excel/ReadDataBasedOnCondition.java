package DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		String conditon="iphone-13";

		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Excel files\\VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Mobiles = wb.getSheet("Mobiles");
		int lastRow = Mobiles.getLastRowNum();	// get the last row number in a sheet

		for (int i = 1; i <= lastRow; i++) {
			Row row = Mobiles.getRow(i);

			short lastCell = row.getLastCellNum();	//Get the last cell number in a row
			for(int j=0;j<lastCell;j++)
				{
				String cellData = row.getCell(j).toString();	// Read all the Cells data in every Row
				if(cellData.equals(conditon))
				{
					short lastCellInRow = row.getLastCellNum();	// get the last cell number
					for(int k=0;k<lastCellInRow;k++) {
						Cell oneCell = row.getCell(k);
						System.out.print(oneCell + "\t"); // print the matched row data
					}
					System.out.println("");	//curser wait in new row
				}
			}
		}
		wb.close();
	}
}
