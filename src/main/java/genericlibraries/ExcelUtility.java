package genericlibraries;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	/*
	 * this class contains reusable methods perform operation on excel
	 */

	private Workbook workbook;
	public void excelunit(String excelpath) {
		/* this methid use to iniatilize excel file 
		 */
		
		FileInputStream fis = null;
				try {
					fis = new FileInputStream(excelpath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getdatafromexcel(String sheetName, int rownum, int cellnum) {
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(workbook.getSheet(sheetName).getRow(rownum)
				      .getCell(cellnum));
		return data;
	}
	public Map<String, String>  getdatafromexcel(String sheetName) {
/* this method is used to fetch multiple data from excel
 */
		DataFormatter df = new DataFormatter();
		Map<String, String> map = new HashMap<>();
		Sheet sheet=workbook.getSheet(sheetName);
		
		for (int i = 0; i <=sheet.getLastRowNum(); i++) {
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			String value = df.formatCellValue(sheet.getRow(i).getCell(1));
			map.put(key, value);
			
		}
		return map;
	}
	
	public void writeexcel(String sheetName, int rownum, int cellnum, String data, String excelpath){
/*this method is used to write data from excel		
 */
	
		Cell cell=workbook.getSheet(sheetName).getRow(rownum).createCell(cellnum);
		cell.setCellValue(data);
		
		FileOutputStream fos= null;
		try {
			fos = new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeExcel() {
		/*this method used to close excel
		 */
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

