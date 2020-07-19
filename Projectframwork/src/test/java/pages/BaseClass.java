package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentHtmlReporter reporter;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupsuite()
	{
		//
		Reporter.log("Setting up reports & test started", true);
		 excel = new ExcelDataProvider();
		 config= new ConfigDataProvider();
		 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Report"+Helper.dateformate()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 
		 
		 Reporter.log("Setting done - test can be started", true);
		 
		 
		 
	}
	
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Setting up browser", true);
		driver = BrowserFactory.StartApplication(driver, config.getbrowser(), config.geturl());
		Reporter.log("Browser setting Done", true);
	}
	
	@AfterClass
	public void teardown()
	{
		BrowserFactory.browserquit(driver);	
	}
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.capturescreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		Reporter.log("Test compleated", true);
		
		report.flush();
		
		Reporter.log("Report is generated", true);
	}
	
}
