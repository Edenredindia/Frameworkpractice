package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider 
{
	//
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File("./Config./Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file"+e.getMessage());
			
		}
			
	}
	public String getdatafromconfig(String Keytosearch)
	{
		return pro.getProperty(Keytosearch);
	}
	public String getbrowser()
	{
		return pro.getProperty("Browser");
	}
	public String geturl()
	{
		return pro.getProperty("qaUrl");
	}
	
	
	
	

}
