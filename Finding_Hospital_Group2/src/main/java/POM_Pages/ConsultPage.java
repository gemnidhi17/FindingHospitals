package POM_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utility.TakeScreenShot;

public class ConsultPage {

	WebDriver driver;
	TakeScreenShot pic = new TakeScreenShot();

	//Constructor to initialize driver
	
	public ConsultPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Consult']")
	WebElement Consult;

	@FindBy(xpath = "//a[@class='link primary-button cta'][contains(.,'Consult Now')][1]")
	WebElement consultNow;

	@FindBy(xpath = "//textarea[@id='detailed-description']")
	WebElement issueDescription;

	@FindBy(xpath = "//label[contains(@for,'problemArea_22')]")
	WebElement generalPhysician;

	@FindBy(xpath = "//a[@class='link cta'][contains(.,'Consult now')][3]")
	WebElement Physician;

	@FindBy(id = "name")
	WebElement Name;

	@FindBy(id = "mobile")
	WebElement Phone;

	@FindBy(xpath = "//button[@class='btn-blue continue-btn'][contains(.,'Continue')]")
	WebElement Continue;

	//method to book the consultation of Doctor
	
	public void consultDoctor(String issue, String phone) {
		Consult.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		pic.takeScreenShot();
		consultNow.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		issueDescription.sendKeys(issue);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		generalPhysician.click();
		Phone.sendKeys(phone);
		pic.takeScreenShot();
		Continue.click();

	}

}
