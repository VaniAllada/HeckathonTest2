package com.mven.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.hssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	private static ReadExcelFile file = null;
	public XSSFWorkbook  workBook;
	
	public Object[][] ReadExcelFile(String filePath, String fileName, String sheetName) throws IOException {
		
		File file = new File(filePath+"\\"+fileName);
		
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		System.out.println(fileExtensionName);
		
		if(fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		}else if(fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
			
		}
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		System.out.println(sheet);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		Object[][]data = new Object[rowCount][2];
		
		for(int i=0; i<rowCount; i++) {
			
			Row row = sheet.getRow(i);
			for(int j=0; j< row.getLastCellNum(); j++) {
				data[i][j] = row.getCell(j).getStringCellValue();
		//	System.out.println(data[i][j]);
			}
			//System.out.println();
		}
		
		return data;
		
	}
	
	public static ReadExcelFile  getFile() throws Exception{
		if(file != null) {
			file= new ReadExcelFile();		
			//file.ReadExcelFile("C:\\Users\\LENOVO\\eclipse-workspace\\HackathonTest2\\Excelsheets", "Book2.xlsx", "Sheet1")
		}
		return file;
	}
	
	
	

}
