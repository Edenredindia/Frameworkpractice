package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extendreportspractice {
	@Test
	public void loginTest()
	
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/samplelatest.html");
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("Extent reports sample test");
		
		logger.log(Status.INFO, "Login to test");
		logger.log(Status.FAIL, "yogin sucess full");
		extent.flush();
		
			
	}
		//ss

}
