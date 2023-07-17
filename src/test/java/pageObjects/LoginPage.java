package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_loginemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_loginpassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btn_loginclick;
	
	public void setLoginEmail(String email)
	{
		txt_loginemail.sendKeys(email);
	}
	
	public void setLoginPassword(String password)
	{
		txt_loginpassword.sendKeys(password);
	}
	
	public void click_login()
	{
		//btn_loginclick.submit();
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", btn_loginclick);
	}
   
	
	
}
