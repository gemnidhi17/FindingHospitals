package POM_Pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utility.TakeScreenShot;

public class CorporateWellnessPage {
	
	WebDriver driver;
	TakeScreenShot pic = new TakeScreenShot();
	
	//Constructor to initialize driver
	
	public CorporateWellnessPage(WebDriver driver)
	{
		this.driver=driver;
	}
   
    
    @CacheLookup
    @FindBy(id="name")
    WebElement name_txtbox;
    
    @CacheLookup
    @FindBy(id="organization_name")
    WebElement org_txtbox;
    
    @CacheLookup
    @FindBy(id="official_email_id")
    WebElement email_txtbox;
    
    @CacheLookup
    @FindBy(id="official_phone_no")
    WebElement phn_txtbox;
    
    @CacheLookup
    @FindBy(xpath="//button[@id='button-style']")
    WebElement button;
    
    //Giving invalid input in form and Capturing alert messages
    
    public  void Result(String name,String org_name,String emailid,String phone)throws InterruptedException {
    	
    	 name_txtbox.sendKeys(name);
		
		 org_txtbox.sendKeys(org_name);
		
		 email_txtbox.sendKeys(emailid);
		
		 phn_txtbox.sendKeys(phone);
		 
		 pic.takeScreenShot();
    }
    
    //Clearing the data from input fields
    
    public void clear() {
    	name_txtbox.clear();
    	org_txtbox.clear();
    	email_txtbox.clear();
    	phn_txtbox.clear();
    	pic.takeScreenShot();
    }
}
