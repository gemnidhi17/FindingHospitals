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
//import POM_Pages.HomePage;
import POM_Pages.LoginPage;
import POM_Pages.PharmacyPage;
import Utility.DriverSetup;
import Utility.ExtentReportManager;
import POM_Pages.ConsultPage;
import POM_Pages.DiagnosticsPage;
import POM_Pages.DoctorsPage;
import POM_Pages.HomePage;

public class Smoke {
	
	private static WebDriver driver;
	ConfigReader reader=new ConfigReader();
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void setup() {
		
		driver = DriverSetup.getWebDriver();
		report=ExtentReportManager.getReportInstance();
		test = report.createTest("Smoke Testing");
	}

	@Test(priority = 1)
	public void openURL() {

		driver.navigate().to(ConfigReader.prop.getProperty("Url"));
		test.log(Status.INFO, "opening practo website");
		driver.manage().deleteAllCookies();
		test.pass("Website opened");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

  	//Logging in Practo website
	
	@Test(priority = 2)
	public void userLogin() {

		LoginPage obj=PageFactory.initElements(driver, LoginPage.class);
		test.log(Status.INFO, "logging in practo website");
		obj.userLogin(ConfigReader.prop.getProperty("phone"),ConfigReader.prop.getProperty("password"));
		test.pass("login done");
	}
	
	//log out in Practo Website
	 
	@Test(priority = 3)
	public void userLogout() {

		LoginPage obj=PageFactory.initElements(driver, LoginPage.class);
		test.log(Status.INFO, "logging out from practo Website");
		obj.userLogout();
		test.pass("Logout done");
	}
	
	// signing up in practo Website
	
	@Test(priority = 4)
	public void signUp() {

		LoginPage obj=PageFactory.initElements(driver, LoginPage.class);
		test.log(Status.INFO, "Signing up in  practo website");
		obj.signUp(ConfigReader.prop.getProperty("signupName"),ConfigReader.prop.getProperty("signupPhone"),ConfigReader.prop.getProperty("signupPass"));
		test.pass("Sign up done");
	}
	

	//Booking appointment of a doctor
	
	@Test(priority= 5)
	public void bookAppointment() throws InterruptedException
	{
		driver.get(ConfigReader.prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		DoctorsPage obj=PageFactory.initElements(driver, DoctorsPage.class);
		test.log(Status.INFO, "Booking Appointment of a Doctor");
		obj.bookAppointment(ConfigReader.prop.getProperty("location"), ConfigReader.prop.getProperty("doctor"),ConfigReader.prop.getProperty("phone"));
		test.pass("Appointment Booked");
	}
	
	//booking a Consultation
	
	@Test(priority= 6)
	public void ConsultDoctor()
	{
		driver.get(ConfigReader.prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ConsultPage obj=PageFactory.initElements(driver, ConsultPage.class);
		test.log(Status.INFO, "Booking Consultation of a Doctor for illness");
		obj.consultDoctor(ConfigReader.prop.getProperty("illness"),ConfigReader.prop.getProperty("phone"));
		test.pass("Consultation done");
	}
	
	//Buying medicine from practo
	
	@Test(priority= 7)
	public void BuyMedicine() throws InterruptedException
	{
		driver.get(ConfigReader.prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PharmacyPage obj=PageFactory.initElements(driver, PharmacyPage.class);
		test.log(Status.INFO, "Buying a medicine from practo website");
		obj.buyMedicine(ConfigReader.prop.getProperty("medicine"));
		test.pass("Medicine Baught");
	}
	
	//Reaching Diagnostics page
	
	@Test(priority= 8)
	public void reachingDiagnostics() throws InterruptedException {
		HomePage obj = PageFactory.initElements(driver, HomePage.class);
		test.log(Status.INFO, "opening Diagnostics page");
		obj.diagnostics();
		test.pass("Diagnostics Page opened");
	}

	//Displaying Top cities in Diagnostics page
	
	@Test(priority= 9)
	public void displayNames() {
		DiagnosticsPage obj = PageFactory.initElements(driver, DiagnosticsPage.class);
		test.log(Status.INFO, "Displaying Top Cities");
		obj.displayNames();
		test.pass("Top cities Displayed");
	}
	
	//Flusing the extent report 
	
	@AfterTest
	public void flush() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		report.flush();
		driver.quit();
	}
	

}
