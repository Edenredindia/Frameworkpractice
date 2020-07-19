package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
	
	WebDriver driver;
	//this is new comment dsd 
	public Loginpage(WebDriver ldriver)
	{
		this.driver= ldriver;
	}
	@FindBy (id = "user-name1") WebElement username;
	@FindBy (id = "password") WebElement Password;
	@FindBy (id = "login-button") WebElement LoginButton;
	
	public void logintoapp(String uname,String Upass) 
	{
		
		
		username.sendKeys(uname);	
		Password.sendKeys(Upass);
		
		LoginButton.click();
	}

}
