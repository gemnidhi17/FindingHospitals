package Utility;

//package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

	// helps to generate the logs in test report
	// public static ExtentReports report;

	public static ExtentReports getReportInstance() {
		ExtentReports report;

		
		String reportName = TakeScreenShot.getTimeStamp() + ".html";
		report = new ExtentReports();
		// initialize the HtmlReporter
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Extent Reports/" + reportName);

		// initialize ExtentReports and attach the HtmlReporter
		
		report.attachReporter(htmlReporter);
		return report;
	}

}
