package pageObjects;


//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;

import org.openqa.selenium.WebDriver;

//import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.interactions.Actions;

public class RegistrationPage extends BasePage
{

	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	// Element
	
	@FindBy(id="input-firstname")
	WebElement txtfirstname;
	
	@FindBy(id="input-lastname")
	WebElement txtlastname;
	
	@FindBy(id="input-email")
	WebElement txtemail;
	
	@FindBy(id="input-password")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-newsletter-yes']")
    WebElement rabtn_yes;
    
    @FindBy(xpath="//input[@id='input-newsletter-no']")
    WebElement rabtn_no;
	
    @FindBy(name="agree")
    WebElement chkboxagree;
    
    @FindBy(xpath="//button[normalize-space()='Continue']")
    WebElement btncontinue;
    
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
    
    public void setUsename(String username)
    {
    	txtfirstname.sendKeys(username);
    }
    public void setLastname(String lastname)
    {
    	txtlastname.sendKeys(lastname);
    }
    public void setEmail(String email)
    {
    	txtemail.sendKeys(email);
    }
    public void setPassword(String password)
    {
    	txtpassword.sendKeys(password);
    }
    public void rabtnYes()
    {
    	rabtn_yes.click();
    }
    public void rabtnNo()
    {
    	rabtn_no.click();
    }
    public void chkbxagree()
    {
    	chkboxagree.click();
    }
    public void btnclickcontinue()
    {
    	//btncontinue.click();
    	
    	// btncontinue.submit();
//    	
        //  btncontinue.sendKeys(Keys.RETURN);
//    	 Thread.sleep(2000);
//    	 Actions act=new Actions(driver);
//		 act.moveToElement(btncontinue).click().perform();
//		 Thread.sleep(2000);
//
//    	 
    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", btncontinue);
//	    
//	    WebDriverWait mywait = new WebDriverWait(driver , Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();


    }
    public String validatemsg()
    {
    	try
    	{
    		return (msgConfirmation.getText());
    	}
    	catch(Exception e)
    	{
    		return (e.getMessage());
    	}
    }
    
}
