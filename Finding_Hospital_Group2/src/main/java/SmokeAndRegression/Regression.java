package SmokeAndRegression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Configuration.ConfigReader;
import POM_Pages.HomePage;
import Utility.DriverSetup;
import Utility.ExtentReportManager;

public class Regression{
	
	ExtentReports report;
	ExtentTest test;
	private static WebDriver driver;
	ConfigReader reader=new ConfigReader();
	
	@BeforeTest
	public void setup() {
		
		driver = DriverSetup.getWebDriver();
		report=ExtentReportManager.getReportInstance();
		test = report.createTest("Regression Testing");
	}

	@Test(priority = 1)
	public void openURL() {

		driver.navigate().to(ConfigReader.prop.getProperty("Url"));
		driver.manage().deleteAllCookies();
		test.log(Status.INFO, "opening practo website");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.pass("website opened");
	}

	//Buying plus Membership of practo website 
	
	@Test(priority = 2)
	public void buyPlusMembership() throws InterruptedException {

		HomePage obj=PageFactory.initElements(driver, HomePage.class);
		test.log(Status.INFO, "Buying plus Membership of Practo");
		obj.buyPlusMembership(ConfigReader.prop.getProperty("name"),ConfigReader.prop.getProperty("phone"),ConfigReader.prop.getProperty("email"));
		test.pass("Membership bought");
	}
	
	//Handelling I frame in plus membership page
	
	@Test(priority = 3)
	public void handleIFrame() throws InterruptedException {

		HomePage obj=PageFactory.initElements(driver, HomePage.class);
		test.log(Status.INFO, "Handelling IFrame");
		obj.LoginIFrame(ConfigReader.prop.getProperty("otp"));
		test.pass("IFrame handeled");
	}
	
	@AfterTest
	public void flush() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		report.flush();
		driver.quit();
	}

}
