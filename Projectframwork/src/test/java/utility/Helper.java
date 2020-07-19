package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.utils.FileUtil;

public class Helper {
	
	
	public static String capturescreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/"+dateformate()+".png";
		
		try {
			FileHandler.copy(src, new File (screenshotpath));
		} catch (Exception e) {
			
			System.out.println("unable to capture screenshot"+e.getMessage());
		}
		return screenshotpath;
		
		
	}
	
	public static String dateformate()
	{
	    DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");	
	  Date curruntdate= new Date();
	  return customformat.format(curruntdate);
	}
	

		

}
