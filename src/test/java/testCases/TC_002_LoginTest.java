package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass
{
	@Test
	public void login_Test()
	{
		try
		{
		logger.info("*****Starting TC_002_LoginTest starting******");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on My account");
		hp.click_login();
		
		LoginPage lp=new LoginPage(driver);
		lp.setLoginEmail(rb.getString("email"));
		Thread.sleep(2000);
		lp.setLoginPassword(rb.getString("password"));
		Thread.sleep(2000);
		logger.info("Clicked on Login");
		lp.click_login();
		
		logger.info("****Successfully logged in***");
		MyAccountPage mp=new MyAccountPage(driver);
		Assert.assertEquals(mp.isAccountPageExists(), true,"Invalid login data");
		}
		catch(Exception e)
		{
		  Assert.fail();
		}
		logger.info("****TC_002_LoginTest completed***");
		
	}
	

}
