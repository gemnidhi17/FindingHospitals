package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {

	WebDriver driver1 = DriverSetup.driver;

	public TakeScreenShot() {
		driver1 = DriverSetup.driver;
	}

	public static String getTimeStamp() {
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}

	public void takeScreenShot() {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver1;
		// Call getScreenshotAs method to create image file
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File destFile = new File(System.getProperty("user.dir") + "/Utils/Screenshots/" + getTimeStamp() + ".jpg");
		try {
			// Copy file at destination
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
