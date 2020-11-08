package POM_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Utility.TakeScreenShot;

public class LoginPage {

	WebDriver driver;
	TakeScreenShot pic = new TakeScreenShot();

	//Constructor to initialize driver
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "Practo login")
	WebElement loginSignupButton;

	@FindBy(id = "loginLink")
	WebElement loginLink;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login")
	WebElement login;

	@FindBy(xpath = "//*[@id='root']/div/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/span[2]")
	WebElement downArrow;

	@FindBy(xpath = "//*[@id='root']/div/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/div/div[10]/a")
	WebElement logout;

	@FindBy(id = "registerLink")
	WebElement registerLink;

	@FindBy(id = "name")
	WebElement Name;

	@FindBy(id = "mobile")
	WebElement Phone;

	@FindBy(id = "email")
	WebElement Email;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "EmailRegister")
	WebElement Otp;

	//method to sign up in Website
	
	public void signUp(String name, String phone, String pass) {
		loginSignupButton.click();
		registerLink.click();
		pic.takeScreenShot();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Name.sendKeys(name);
		Phone.sendKeys(phone);
		Password.sendKeys(pass);
		pic.takeScreenShot();
		Otp.click();
	}
	
	//method to login in parcto website

	public void userLogin(String userid, String pass) {
		loginSignupButton.click();
		loginLink.click();
		pic.takeScreenShot();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		username.sendKeys(userid);
		password.sendKeys(pass);
		pic.takeScreenShot();
		login.click();
		pic.takeScreenShot();

	}
	
	//method to logout from practo website
	
	public void userLogout() {
		downArrow.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		pic.takeScreenShot();
		logout.click();
	}
}
