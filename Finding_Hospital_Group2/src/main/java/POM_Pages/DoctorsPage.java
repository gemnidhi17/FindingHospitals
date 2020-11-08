package POM_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Utility.TakeScreenShot;

public class DoctorsPage {
	
	WebDriver driver;
	TakeScreenShot pic = new TakeScreenShot();
	
	//Constructor to initialize driver
	
	public DoctorsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//div[@class='product-tab__title'][text()='Doctors']")
	WebElement Doctors;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	WebElement location;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main'][text()='Bangalore']")
	WebElement locationlistBox;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement searchBox;
	
	//@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main'][text()='Doctor']")
	@FindBy(xpath = "(//div[@data-qa-id='omni-suggestion-main'][contains(.,'Doctor')])")
	WebElement doctorlistBox;
	
	@FindBy(xpath="//span[text()='Book Appointment'][1]")
	WebElement bookAppointment;
	
	@FindBy(xpath="//div[@class='u-t-capitalize'][text()='tomorrow']")
	WebElement tomorrow;
	
	@FindBy(xpath="//div[@data-qa-id='slot_time']/span")
	WebElement timeslot;
	
	@FindBy(name="phone")
	WebElement Phone;
	
	@FindBy(xpath="//button[@class='c-btn--dark '][text()='Continue']")
	WebElement Continue;
	
	//Book doctor's appointment
	
	public void bookAppointment(String place,String search,String phone) throws InterruptedException
	{
		Doctors.click();
		Thread.sleep(3000);
		location.clear();
		location.sendKeys(place);
		Thread.sleep(3000);
		locationlistBox.click();
		searchBox.sendKeys(search);
		pic.takeScreenShot();
		Thread.sleep(3000);
		doctorlistBox.click();
		Thread.sleep(3000);
		bookAppointment.click();
		Thread.sleep(3000);
		tomorrow.click();
		Thread.sleep(3000);
		timeslot.click();
		pic.takeScreenShot();
		Thread.sleep(3000);
		Phone.sendKeys(phone);
		pic.takeScreenShot();
		Continue.click();
		
	}
	
	

}
