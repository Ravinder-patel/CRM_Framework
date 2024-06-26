package Tasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromFilesWriteIntoExcel {
	public static void main(String[] args) throws IOException {
		System.out.println("Main started");
		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Properties Files\\task.txt");
		Properties pObj = new Properties();
		pObj.load(fis);
		// get properties file objects
		String KEY1 = pObj.getProperty("key1");
		String KEY2 = pObj.getProperty("key2");
		String KEY3 = pObj.getProperty("key3");
		String KEY4 = pObj.getProperty("key4");

		// get excel file objects
		FileInputStream fis2 = new FileInputStream("E:\\Softwares\\DDT Excel files\\ReadExcelBasedOnCondition.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("Task");
		// int rowCount = sh.getLastRowNum();
		Cell KEY5 = sh.getRow(0).getCell(0);
		Cell KEY6 = sh.getRow(1).getCell(0);
		Cell KEY7 = sh.getRow(2).getCell(0);
		Cell KEY8 = sh.getRow(3).getCell(0);
		Cell KEY9 = sh.getRow(4).getCell(0);
		
		Cell cellVal1 = sh.getRow(0).createCell(1);
		cellVal1.setCellType(CellType.STRING);
		cellVal1.setCellValue(KEY1);
		Cell cellVal2 = sh.getRow(1).createCell(1);
		cellVal2.setCellType(CellType.STRING);
		cellVal2.setCellValue(KEY2);
		Cell cellVal3 = sh.getRow(2).createCell(1);
		cellVal3.setCellType(CellType.STRING);
		cellVal3.setCellValue(KEY3);
		Cell cellVal4 = sh.getRow(3).createCell(1);
		cellVal4.setCellType(CellType.STRING);
		cellVal4.setCellValue(KEY4);
//		Cell cellVal5 = sh.getRow(4).createCell(1);
//		cellVal5.setCellType(CellType.STRING);
//		cellVal5.setCellValue(KEY5);
//		Cell cellVal6 = sh.getRow(5).createCell(1);
//		cellVal6.setCellType(CellType.STRING);
//		cellVal6.setCellValue(KEY6);
//		Cell cellVal7 = sh.getRow(6).createCell(1);
//		cellVal7.setCellType(CellType.STRING);
//		cellVal7.setCellValue(KEY7);
//		Cell cellVal8 = sh.getRow(7).createCell(1);
//		cellVal8.setCellValue(KEY8);
//		Cell cellVal9 = sh.getRow(8).createCell(1);
//		cellVal9.setCellValue(KEY9);
		
		FileOutputStream fos=new FileOutputStream("E:\\Tek Pyramid\\Tasks\\task.xlsx");
		wb.write(fos);
		wb.close();
		
		System.out.println("Data inserted succesfully");
		
		System.out.println("Main Ended");

	}

}
