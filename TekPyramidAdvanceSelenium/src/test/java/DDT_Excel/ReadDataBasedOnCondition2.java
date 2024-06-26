package DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.out.println("Main Started");
		String expectedTestId = "tc_108";
		boolean flag = false;
		String Cell1 = ""; //or else we can give null
		String Cell2 = "";
		String Cell3 = "";
		String Cell4 = "";

		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Excel files\\ReadExcelBasedOnCondition.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet testCases = wb.getSheet("Sheet1");
		int lastRow = testCases.getLastRowNum();

		for (int i = 0; i <= lastRow; i++) {
			String rowData = "";

			try {
				rowData = testCases.getRow(i).getCell(0).toString(); // read data from 1st cell in every row
				if (rowData.equals(expectedTestId)) // compare values in every row with excpected value----if true
												
				{
					flag = true;	//initialize flag as true if the condition is true
					Cell1 = testCases.getRow(i).getCell(0).toString();
					Cell2 = testCases.getRow(i).getCell(1).toString();
					Cell3 = testCases.getRow(i).getCell(2).toString();
					Cell4 = testCases.getRow(i).getCell(3).toString();
				}
			} catch (Exception e) {
			}
		}
		if (flag == true) {
			System.out.println(Cell1 + "\t" + Cell2 + "\t" + Cell3 + "\t" + Cell4);
		} else {
			System.out.println(expectedTestId + " is not available in Excel");
		}

		wb.close();
		System.out.println("Main Ended");

		/*
		 * for (int i = 1; i <= lastRow; i++) { Row row = TestCases.getRow(i);
		 * 
		 * short lastCell = row.getLastCellNum(); for(int j=0;j<lastCell;j++) { String
		 * cellData = row.getCell(j).toString(); if(cellData.equals(expectedTestId)) {
		 * short lastCellInRow = row.getLastCellNum(); for(int k=0;k<lastCellInRow;k++)
		 * { Cell oneCell = row.getCell(k); System.out.print(oneCell+"\t"); } } } }
		 * wb.close(); System.out.println("Main Ended");
		 * if we we write this every time else block will execute
		 */

	}
}
