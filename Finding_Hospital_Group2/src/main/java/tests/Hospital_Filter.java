
package tests;

//import java.util.ArrayList;

//import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import POM_Pages.HomePage;
import POM_Pages.HospitalsInBanglorePage;
import Utility.DriverSetup;
import Utility.ExtentReportManager;
import Utility.TakeScreenShot;
//import Utility.ExtentReportManager;
import Configuration.ConfigReader;
import DataDriven.WriteDiagnostics;
import DataDriven.WriteHospitalFilter;

/********************************* FINDING HOSPITAL IN BANFLORE WITH SPECEFIED FILTERS ********************************************/

public class Hospital_Filter {

	//Creating Global Variables
	
	private static WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	ConfigReader reader = new ConfigReader();
	
	
	//Setting instance of webdriver , Extent Report and creating Extent test

	@BeforeTest
	public void setup() {
		driver = DriverSetup.getWebDriver();
		report=ExtentReportManager.getReportInstance();
		test = report.createTest("Finding hospital in bangalore with specified filter");
	}

	//Opening practo website
	
	@Test(priority = 1)
	public void openURL() {
		
		driver.get(ConfigReader.prop.getProperty("Url"));
		driver.manage().deleteAllCookies();
		test.log(Status.INFO, "opening practo website");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.pass("Website opened");
	}

	
	//Entering the Location
		
	@Test(priority=2)
	public void setLocation() throws InterruptedException {

		test.log(Status.INFO, "Entering location");
		HospitalsInBanglorePage obj = PageFactory.initElements(driver, HospitalsInBanglorePage.class);
		obj.locationBox(ConfigReader.prop.getProperty("location"));
		test.pass("location entered");

	}

	//Entering Service 
	
	@Test(priority=3)
	public void setHospital() throws InterruptedException {

		test.log(Status.INFO, "Entering service");
		HospitalsInBanglorePage obj = PageFactory.initElements(driver, HospitalsInBanglorePage.class);
		obj.ServiceBox(ConfigReader.prop.getProperty("hospital"));
		test.pass("service entered");
	}
	
	//Selecting 24*7 open filter

	@Test(priority=4)
	public void allTimeOpen() throws InterruptedException {

		test.log(Status.INFO, "selecting hospital which is open 24*7");
		HospitalsInBanglorePage obj = PageFactory.initElements(driver, HospitalsInBanglorePage.class);
		obj.allTimeOpen();
		test.pass("selected hospital which are open 24*7");
	}

	//Selecting has parking filter
	
	@Test(priority=5)
	public void hasParking() throws InterruptedException {

		test.log(Status.INFO, "selecting hospital which has parking");
		HospitalsInBanglorePage obj = PageFactory.initElements(driver, HospitalsInBanglorePage.class);
		obj.hasParking();
		test.pass("selected hospital with parking facility");

	}

	//Selecting hospitals with ratings above 3.5 
	
	@Test(priority = 6)
	public void StarRatings() throws Exception {

		test.log(Status.INFO, "taking hospitals with more than 3.5 ratings and displaying them");
		HospitalsInBanglorePage obj = PageFactory.initElements(driver, HospitalsInBanglorePage.class);
		obj.display();
		test.pass("result displayed in console");

	}
	
	//Writing hospital names and Ratings in Excel sheet

	@Test(priority = 7)
	public void WriteInExcel() throws Exception {

		test.log(Status.INFO, "Writing hospital names and ratings in Excel sheet");
		WriteHospitalFilter obj = new WriteHospitalFilter();
		obj.Output();
		test.pass("Writing done");

	}

	//Closing the driver and flusing the Extent report
	
	@AfterTest
	public void flush() {
		report.flush();
		driver.close();
	}

}
