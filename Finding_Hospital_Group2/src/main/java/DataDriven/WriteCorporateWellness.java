package DataDriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Configuration.ConfigReader;
import tests.CorporateWellness;

public class WriteCorporateWellness {
	
	ConfigReader reader = new ConfigReader();
		XSSFWorkbook wb;
		XSSFSheet sheet;
		XSSFCell cell;

		//Method to write alert messages in Excel sheests
		
		public void Output() throws Exception {

			
			File src=new File(System.getProperty("user.dir") + "/ExcelFiles/Excel output/writeCW.xlsx/");
			
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

			sheet = wb.getSheet("Sheet1");

			sheet.createRow(0).createCell(0).setCellValue("Alert Messages");

			for (int i = 0; i < CorporateWellness.alerttext.size(); i++) {
				sheet.createRow(i + 1).createCell(0).setCellValue(CorporateWellness.alerttext.get(i));
			}

			FileOutputStream fout = new FileOutputStream(src);

			wb.write(fout);

			wb.close();

		}
	}

