package DataDriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Configuration.ConfigReader;
import POM_Pages.DiagnosticsPage;
//import POM_Pages.HospitalsInBanglorePage;

public class WriteDiagnostics {
	
	ConfigReader reader = new ConfigReader();
		XSSFWorkbook wb;
		XSSFSheet sheet;
		XSSFCell cell;

		//method to write Top cities in Excel Sheets
		
		public void Output() throws Exception {
			
			File src=new File(System.getProperty("user.dir") + "/ExcelFiles/Excel output/writeD.xlsx/");

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

			sheet = wb.getSheet("Sheet1");
			
			sheet.createRow(0).createCell(0).setCellValue("TOP CITIES");
			
			for(int i=0; i <DiagnosticsPage.topCity.size(); i++) {
				sheet.createRow(i+1).createCell(0).setCellValue(DiagnosticsPage.topCity.get(i).getText());
			}
			
	        FileOutputStream fout = new FileOutputStream(src);
			
			wb.write(fout);
			
			wb.close();

		}

	}


