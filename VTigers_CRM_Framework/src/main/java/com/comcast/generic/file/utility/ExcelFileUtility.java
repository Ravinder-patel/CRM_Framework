package com.comcast.generic.file.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./resource/VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./resource/VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowNumber = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowNumber;

	}

	public short getColumnCount(String sheetName, int rowNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./resource/VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Row row = wb.getSheet(sheetName).getRow(rowNum);
		short cellCount = row.getLastCellNum();
		wb.close();
		return cellCount;

	}

	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./resource/VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./resource/VTigers.xlsx");
		wb.write(fos);
		wb.close();

	}

}
