package POM_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.testng.annotations.BeforeSuite;

import Utility.TakeScreenShot;


public class HomePage {

	WebDriver driver;
	TakeScreenShot pic = new TakeScreenShot();

	//Constructor to initialize driver
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-locality']")
	WebElement placeBox;

	@FindBy(name = "Practo login")
	WebElement loginSignupButton;

	@FindBy(id = "name")
	WebElement Name;

	@FindBy(id = "mobile")
	WebElement Phone;

	@FindBy(id = "email")
	WebElement Email;

	@CacheLookup
	@FindBy(xpath = "//div[@data-qa-id='omni-suggestion-main'][text()='Bangalore']")
	WebElement placeBoxList;

	@CacheLookup
	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement serviceSearchBox;

	@CacheLookup
	@FindBy(xpath = "//div[@data-qa-id='omni-suggestion-main'][text()='Hospital']")
	WebElement serviceSearchList;

	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Consult']")
	WebElement Consult;

	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Pharamcy']")
	WebElement Pharmacy;

	@CacheLookup
	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Diagnostics']")
	WebElement diagnostics;

	@CacheLookup
	@FindBy(xpath = "//span[@class='u-d-item up-triangle'][text()='For Providers']")
	WebElement forProviders;

	@CacheLookup
	@FindBy(xpath = "//a[@class='nav-interact'][text()='Corporate wellness']")
	WebElement corporateWellness;

	@FindBy(xpath = "//img[@alt='plus card']")
	WebElement plusCard;

	@FindBy(xpath = "//tbody/tr[6]/td[2]/button[1]")
	WebElement plusOneMonth;

	@FindBy(xpath = "//button[@class='bg-purple u-text--bold text-epsilon text-white u-border-radius--4  width-per--70  u-p-v--12 u-cur--ptr u-m-t--20'][text()='Buy Plan'][2]")
	WebElement plusSixMonths;

	@FindBy(xpath = "//button[text()='Continue to payment']")
	WebElement payment;

	@FindBy(xpath = "//iframe[@class='login-iframe']")
	WebElement loginIframe;

	@FindBy(id = "mobile_token")
	WebElement otpText;

	@FindBy(id = "phoneMigrationOtp")
	WebElement login;

	/*
	 * public void ServiceBox() { // serviceSearchBox.click();
	 * serviceSearchBox.sendKeys("Hospital");
	 * driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 * serviceSearchList.click(); }
	 * 
	 * public void locationBox() { // placeBox.click(); placeBox.clear();
	 * placeBox.sendKeys("Bangalore");
	 * driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 * placeBoxList.click(); }
	 */
	
	//method to buy plus membership
	
	public void buyPlusMembership(String name, String phone, String email) throws InterruptedException {
		plusCard.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		JavascriptExecutor x = (JavascriptExecutor) driver;
		x.executeScript("window.scrollTo(0,4000)");
		Thread.sleep(3000);
		pic.takeScreenShot();
		plusOneMonth.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Name.sendKeys(name);
		Phone.sendKeys(phone);
		Email.sendKeys(email);
		pic.takeScreenShot();
		payment.click();
	}

	//method to handle IFrame
	
	public void LoginIFrame(String otp) {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.switchTo().frame(loginIframe);
		pic.takeScreenShot();
		otpText.sendKeys(otp);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		login.click();
	}
	
	//reaching Diagnostics page
	
	public void diagnostics() {

		diagnostics.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	//opening Corporate wellness
	
	public void corporate_wellness() throws InterruptedException {

		forProviders.click();
		Thread.sleep(3000);
		pic.takeScreenShot();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		corporateWellness.click();

	}
}
