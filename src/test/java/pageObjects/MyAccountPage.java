package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msg_MyAccount;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	
	
	public boolean isAccountPageExists()
	{
		try
		{
			return (msg_MyAccount.isDisplayed());
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	public void click_logout()
	{
		lnkLogout.click();
	}
	
	

}
