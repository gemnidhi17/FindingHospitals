package POM_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utility.TakeScreenShot;

public class PharmacyPage {

	WebDriver driver;
	TakeScreenShot pic = new TakeScreenShot();

	//Constructor to initialize driver
	
	public PharmacyPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Pharmacy']")
	WebElement Pharmacy;

	@FindBy(xpath = "//input[@tabindex='0']")
	WebElement SearchProduct;

	@FindBy(xpath = "//div[@class='text-charcoal-grey-two heading-delta text-epsilon'][contains(.,'Alovent 5 Mg Tablet')]")
	WebElement medicineList;

	@FindBy(xpath = "//span[text()='ADD TO CART']")
	WebElement addtoCart;
	
	//method to buy a medicine from practo website

	public void buyMedicine(String medicine) throws InterruptedException {
		Pharmacy.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		SearchProduct.sendKeys(medicine);
		SearchProduct.click();
		Thread.sleep(3000);
		medicineList.click();
		pic.takeScreenShot();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		addtoCart.click();
		pic.takeScreenShot();
	}

}
