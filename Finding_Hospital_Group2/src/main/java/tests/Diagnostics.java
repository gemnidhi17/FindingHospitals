/**
 * 
 */
package tests;

/**
 * @author HP
 *
 */
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Configuration.ConfigReader;
import DataDriven.WriteDiagnostics;
import POM_Pages.DiagnosticsPage;
import POM_Pages.HomePage;
import Utility.DriverSetup;
import Utility.ExtentReportManager;

/*********************************** Fetching top cities from Diagnostics ***********************************************************/


public class Diagnostics {

	
	
	private static WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	ConfigReader reader = new ConfigReader();
	
	@BeforeTest
	public void setup() {
		driver = DriverSetup.getWebDriver();
		report = ExtentReportManager.getReportInstance();
		test = report.createTest("Diagnostics page");
	}

	@Test(priority = 1)
	public void openURL() {

		driver.navigate().to(ConfigReader.prop.getProperty("Url"));
		driver.manage().deleteAllCookies();
		test.log(Status.INFO, "opening practo website");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.pass("Website opened");
	}

	//opening Diagnostics page
	
	@Test(groups = { "find" }, priority = 2)
	public void reachingDiagnostics() throws InterruptedException {
		HomePage obj = PageFactory.initElements(driver, HomePage.class);
		test.log(Status.INFO, "opening Diagnostics page");
		obj.diagnostics();
		test.pass("Diagnostics page opened");
	}

	//displaying Top cities
	
	@Test(dependsOnGroups = { "find" }, priority = 3)
	public void displayNames() {
		DiagnosticsPage obj = PageFactory.initElements(driver, DiagnosticsPage.class);
		test.log(Status.INFO, "Display Top cities");
		obj.displayNames();
		test.pass("Displayed Top cities");
	}

	//Writing top cities in Excel
	
	@Test(priority = 4)
	public void WriteInExcel() {

		WriteDiagnostics obj = new WriteDiagnostics();
		test.log(Status.INFO, "Writing Top cities in Excel");
			try {
				obj.Output();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		test.pass("Writing done");
	}

	@AfterTest
	public void flush() {
		report.flush();
		driver.quit();

	}

}