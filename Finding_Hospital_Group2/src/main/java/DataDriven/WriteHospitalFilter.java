package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Configuration.ConfigReader;
import POM_Pages.HospitalsInBanglorePage;

public class WriteHospitalFilter {
	ConfigReader reader = new ConfigReader();
	
	//method to write Hospiatal names and Ratings in Excel Sheets
	
	public void Output() throws Exception{
		
		try {
			
			File src=new File(System.getProperty("user.dir") + "/ExcelFiles/Excel output/writeHF.xlsx/");
			FileOutputStream fis = new FileOutputStream(src);
			XSSFWorkbook wbook = new XSSFWorkbook();
			XSSFSheet wsheet = wbook.createSheet("Hospital_details");

			wsheet.createRow(0);
			wsheet.getRow(0).createCell(0).setCellValue("Hospital_Name");
			wsheet.getRow(0).createCell(1).setCellValue("Ratings");

			for (int i = 0; i < HospitalsInBanglorePage.nameList.size(); i++) {
				wsheet.createRow(i + 1);
				wsheet.getRow(i + 1).createCell(0).setCellValue(HospitalsInBanglorePage.nameList.get(i));
				wsheet.getRow(i + 1).createCell(1).setCellValue(HospitalsInBanglorePage.ratingList.get(i));

			}
			wbook.write(fis);

			fis.close();
			wbook.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
