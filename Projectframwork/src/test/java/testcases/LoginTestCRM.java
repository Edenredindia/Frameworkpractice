package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.Loginpage;
import utility.BrowserFactory;
import utility.ExcelDataProvider;
import utility.Helper;

public class LoginTestCRM extends BaseClass {
	
	//ExcelDataProvider excel = new ExcelDataProvider();
	
	//new comment sdd
	
	@Test
	public void loginApp() 
	{
		
		logger	 = report.createTest("Login to app");
		
		String Username  = excel.getstringdata(0, 0, 0);
		String Password  = excel.getstringdata(0, 0, 1);
		
		
		Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);
		logger.info("Starting application");
		loginpage.logintoapp(Username,Password);
		Helper.capturescreenshot(driver);
		logger.pass("log success");
		
		
		
		
	}

}
