/**
 * 
 */
package Utility;

import java.net.URL;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author HP
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Configuration.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This program is to get specified driver object of different drivers.
 */
public class DriverSetup {
	public static WebDriver driver;
	// public static RemoteWebDriver drivergrid;
	ConfigReader reader = new ConfigReader();

	public static WebDriver getWebDriver() {

		if (ConfigReader.prop.getProperty("browser").equalsIgnoreCase("mozila")) {
			// defining path for fire-fox driver
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (ConfigReader.prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			// defining path for chrome driver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (ConfigReader.prop.getProperty("browser").equalsIgnoreCase("edge")) {
			// defining path for edge driver.
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

}
