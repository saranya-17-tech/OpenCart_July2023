package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass
{
	
   @Test
   void test_account_Registration() throws InterruptedException
   {
	   logger.info("***starting C_001_AccountRegistrationTest");
	   try
	   {
	HomePage hp=new HomePage(driver);
	hp.clickMyaccount();
	hp.clickRegistration();
	
	
	RegistrationPage rp=new RegistrationPage(driver);
	
	logger.info("provinding user data");
	rp.setUsename(randomeString().toUpperCase());
	
	rp.setLastname(randomeString().toUpperCase());
	
	rp.setEmail(randomeString()+"@gmail.com");
	
	rp.setPassword(randomeAlphaNumber());
	
	rp.rabtnYes();
	
	rp.chkbxagree();
	
	rp.btnclickcontinue();
	
	logger.info("Clicked on Continue");
	String msg=rp.validatemsg();
	
	Assert.assertEquals(msg, "Your Account Has Been Created!");
	   }
	   catch(Exception e)
	   {
		   Assert.fail();
	   
	   }
	
   }
	
}
