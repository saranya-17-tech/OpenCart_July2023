package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Elements
    @FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement link_myacc;
    
    @FindBy(linkText="Register")
	WebElement link_register;
    
    @FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']")
    WebElement link_login;
    
    //Action methods
    public void clickMyaccount()
    {
    	link_myacc.click();
    }
    public void clickRegistration()
    {
    	link_register.click();
    }
    
    public void click_login()
    {
    	link_login.click();
    }
    
	
	
    

    
	
    
}
