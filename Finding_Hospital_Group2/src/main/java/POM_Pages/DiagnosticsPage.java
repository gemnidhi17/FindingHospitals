package POM_Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import Utility.TakeScreenShot;

public class DiagnosticsPage {

	WebDriver driver;
	TakeScreenShot pic = new TakeScreenShot();

	//Constructor to initialize driver
	
	public DiagnosticsPage(WebDriver driver) {
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Diagnostics']")
	WebElement diagnostics;

	@FindBy(xpath = "//div[@class='u-padb--dbl']")
	WebElement background;

	@FindBy(xpath = "//input[@id='locationInput']")
	WebElement location;

	@FindBy(xpath = "//input[@id='omniSearch']")
	WebElement testSearch;

	@FindBy(xpath = "//div[@class='c-qc__qc-button hollow u-marginr--std'][contains(.,'Add to Cart')]")
	WebElement addToCart;

	@FindBys(@FindBy(xpath = "//div[@class='u-margint--standard o-f-color--primary']"))
	public static List<WebElement> topCity = new ArrayList<WebElement>();


	//Displaying top Cities names in Diagnostics
	
	public void displayNames() {

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println();
		System.out.println("Top City Names");
		pic.takeScreenShot();
		for (int i = 0; i < topCity.size(); i++)
			System.out.println(topCity.get(i).getText());

	}

}
