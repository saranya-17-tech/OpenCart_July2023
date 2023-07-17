package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String email,String password,String exp)
	{
		try
		{
		logger.info("*****Starting TC_002_LoginTest starting******");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on My account");
		hp.click_login();
		
		LoginPage lp=new LoginPage(driver);
		lp.setLoginEmail(email);
		//Thread.sleep(2000);
		lp.setLoginPassword(password);
		//Thread.sleep(2000);
		logger.info("Clicked on Login");
		lp.click_login();
		
		logger.info("****Successfully logged in***");
		MyAccountPage mp=new MyAccountPage(driver);
		boolean status=mp.isAccountPageExists();
		
		if(exp.equals("valid"))
		{
			if(status==true)
			{
				mp.click_logout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	    if(exp.equals("Invalid"))
		{
			if(status==true)
			{
				mp.click_logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
		  Assert.fail();
		}
		logger.info("****TC_002_LoginTest completed***");
		
	}
	

}
