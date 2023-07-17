package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass 
{
	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass()); // Logging 
		
		rb=ResourceBundle.getBundle("config"); // load config.properties file
//		ChromeOptions options=new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		if(br.equals("chrome"))
		{
		   driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
		   driver=new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get("https://demo.opencart.com/index.php");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	public String randomeString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring);
	}
	public String randomeNumber()
	{
		String generatedstring2= RandomStringUtils.randomNumeric(10);
		return (generatedstring2);
	}
	public String randomeAlphaNumber()
	{
		String str1= RandomStringUtils.randomAlphabetic(4);
		String str2= RandomStringUtils.randomNumeric(3);
		return (str1+"@"+str2);
	}
	
	public String captureScreen(String tname) throws IOException 
	{

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try
		{
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e)
		{
			e.getMessage();
		}
		return destination;

	}

	
}
