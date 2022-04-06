//package com.mindtree.CucumberFramework.utils;
//
//import java.io.FileInputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ReadExcelltestData extends DriverFactory2 {
//	
//	Map<String, String> testdata=new HashMap<String, String>();
//	
//	@SuppressWarnings("unlikely-arg-type")
//	public ReadExcelltestData() {
//		FileInputStream file;
//		try {
//			file = new FileInputStream("./src\\main\\java\\com\\mindtree\\CucumberFramework\\testdata\\controller.xlsx");
//		Workbook book= new XSSFWorkbook(file);
//		Sheet data = book.getSheet("Data");
//		for (Row row : data) {
//			
//			if(row.getCell(1, MissingCellPolicy.RETURN_BLANK_AS_NULL)==null && row.getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL)==null) {
//				break;
//			}
//			
//			CellType CellValue = row.getCell(1).getCellType();
//			if(CellValue.toString().equals("BLANK")) {
//				break;
//			}
//			if(CellValue.toString().equals("NUMERIC")) {
//				double value = row.getCell(1).getNumericCellValue();
//				testdata.put(row.getCell(0).getStringCellValue(), String.valueOf(value) );
//			}
//			else {
//				
//				testdata.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
//			}
//		}
//		book.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	
//	}
//	
//	
//	public String getExcelldata(String key) {
//		
//		 return testdata.get(key);
//		
//	}
//	
//	
//}