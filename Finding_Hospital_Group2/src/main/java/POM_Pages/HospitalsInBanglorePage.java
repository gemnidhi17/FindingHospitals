package POM_Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utility.TakeScreenShot;

public class HospitalsInBanglorePage {

	//public static List<WebElement> ratings = new ArrayList<WebElement>();
	//public static List<WebElement> names = new ArrayList<WebElement>();
	public static List<String> nameList = new ArrayList<String>();
	public static List<Double> ratingList = new ArrayList<Double>();
	
	TakeScreenShot pic = new TakeScreenShot();

	WebDriver driver;

	//Constructor to initialize driver
	
	public HospitalsInBanglorePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-locality']")
	WebElement placeBox;

	@FindBy(xpath = "//input[@data-input-box-id='omni-searchbox-locality']")
	WebElement Place;

	@FindBy(xpath = "//div[@data-qa-id='omni-suggestion-main'][contains(.,'Bangalore')]")
	WebElement placeBoxList;

	@FindBy(xpath = "//input[@data-input-box-id='omni-searchbox-keyword']")
	WebElement serviceSearchBox;


	@FindBy(xpath = "//div[@data-qa-id='omni-suggestion-main'][text()='Hospital']")
	WebElement serviceSearchList;

	@FindBy(xpath = "//div[@data-qa-id='Open_24X7_checkbox']")
	WebElement allTimeOpen;

	@FindBy(xpath = "//span[@data-qa-id='all_filters']")
	WebElement allFilter;

	@FindBy(xpath = "//div[@data-qa-id='Has_Parking_checkbox']")
	WebElement hasParking;

	
	@FindBys(@FindBy(xpath = "//h2[@data-qa-id='hospital_name']"))
	public static List<WebElement> names = new ArrayList<WebElement>();

	@FindBys(@FindBy(how = How.XPATH, using = "//span[@class='common__star-rating__value']"))
	public static List<WebElement> ratings = new ArrayList<WebElement>();

	//entering in location box
	
	public void locationBox(String place) throws InterruptedException {
		// placeBox.click();
		// placeBox.clear();
		Place.click();
		Place.clear();
		Place.sendKeys(place);
		// Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		placeBoxList.click();
	}
	
	//entering in Service box

	public void ServiceBox(String service) throws InterruptedException {
		// serviceSearchBox.click();
		serviceSearchBox.sendKeys(service);
		Thread.sleep(3000);
		serviceSearchList.click();
		pic.takeScreenShot();
	}

	//selecting 24*7 open hospital
	
	public void allTimeOpen() throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		allTimeOpen.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		pic.takeScreenShot();
	}

	//selecting hospital with parking facility
	
	public void hasParking() throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		allFilter.click();
		Thread.sleep(3000);
		hasParking.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		pic.takeScreenShot();
	}

	//Displaying Hospital with specified Filters
	
	public void display() throws Exception {

		Thread.sleep(3000);
		JavascriptExecutor x = (JavascriptExecutor) driver;
		x.executeScript("window.scrollTo(0,4000)");
		Thread.sleep(3000);
		pic.takeScreenShot();
		x.executeScript("window.scrollTo(0,6000)");

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		for (int i = 0; i < names.size()-1; i++) {
			String name1 = names.get(i).getText();

			double d = Double.parseDouble(ratings.get(i).getText());
			if (d > 3.5) {
				System.out.println(name1 + "  " + d);
				nameList.add(name1);
				ratingList.add(d);

			}

		}

	}

}
