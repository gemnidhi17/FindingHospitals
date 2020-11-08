/**

 * 
 */
package tests;

/**
 * @author HP
 *
 */
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Configuration.ConfigReader;
import DataDriven.WriteCorporateWellness;
import DataDriven.WriteDiagnostics;
import POM_Pages.CorporateWellnessPage;
import POM_Pages.HomePage;
import Utility.DriverSetup;
import Utility.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;




import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


/*************************** Capturing Alert messages after Entering invalid data in Corporate Wellness Page *************************/


public class CorporateWellness {
	static WebDriver driver;
	static ConfigReader reader=new ConfigReader();
	public static List<String> alerttext= new ArrayList<String>();
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void setup() {
		driver = DriverSetup.getWebDriver();
		report=ExtentReportManager.getReportInstance();
		test = report.createTest("Corporate Wellness page");
	}

	
	@Test(priority = 0)
	public void openURL() {

		driver.navigate().to(ConfigReader.prop.getProperty("Url"));
		driver.manage().deleteAllCookies();
		test.log(Status.INFO, "opening practo website");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.pass("website opened");
	}

	//Opening Corporate wellness page
	
	@Test(priority = 2)
	public void openingCorporateWellness() throws InterruptedException {

        HomePage obj=PageFactory.initElements(driver, HomePage.class);
        test.log(Status.INFO, "opening corporate wellness");
        obj.corporate_wellness();
        test.pass("Corporate wellness opened");
	}
	
    //Switching to corprate Wellness page
	
	@Test(priority = 3)
	public void switchingWindow() {
		Set<String> w = driver.getWindowHandles();
		Iterator<String> i = w.iterator();
		String parentwindow = i.next();
		String childwindow = i.next();
		test.log(Status.INFO, "Switching window");
		driver.switchTo().window(childwindow);
		test.pass("Window switched");
	}

	//Dataprovider for passing values in Form 
	
	 
	@DataProvider(name = "dataprovider")
	public Object[][] dpMethod() {
		return new Object[][] { { "cc", "dd", "sss", "sss" }, { "cc", "dd", "shag123@gmail.com", "sss" },
			{ "", "dd", "shag123@gmail.com", "9876543210" }, { "ss", "", "shag123@gmail.com", "9876543210" },
			{ "ss", "dd", "", "9876543210" }, { "ss", "dd", "shag123@gmail.com", "" }};
	}

	//Handelling and Capturing Alert message after invalid input
	
	@Test(dataProvider = "dataprovider", priority = 4)
	public void givingInputs(String n1,String org,String email,String phn) throws InterruptedException {
		CorporateWellnessPage obj=PageFactory.initElements(driver, CorporateWellnessPage.class);
		test.log(Status.INFO, "Entering set of invalid input");
		obj.Result(n1,org,email,phn);
		test.pass("Values entered");
		driver.findElement(By.xpath("//button[@id='button-style']")).click();
		test.log(Status.INFO, "Switching to Alert");
		Alert alert=driver.switchTo().alert();
		test.pass("Switched to alert");
		System.out.println(alert.getText());
		//Thread.sleep(3000);
		alerttext.add(alert.getText());
		test.log(Status.INFO, "accepting alert");
		alert.accept();
		test.pass("url opened");
		Thread.sleep(3000);
		test.log(Status.INFO, "clearing the given input");
		obj.clear();
		test.pass("Input cleared");
		Thread.sleep(3000);
	}
	
	//Navigating back to home page
	
	@Test(priority = 5)
	public void Backtohomepage() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.log(Status.INFO, "navigating back to home page");
		driver.navigate().back();
		test.pass("navigated back");
		driver.close();
	}
	
	//Writing Alert messages in Excel sheet
	
	@Test( priority = 6)
	public void WriteInExcel() {
		WriteCorporateWellness obj = new WriteCorporateWellness();
		test.log(Status.INFO, "Writing the alert messages in Excel sheet");
		try {
			obj.Output();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.pass("writing done");

	}

	
	@AfterTest
	public void flush() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		report.flush();
		driver.quit();
	}

}
