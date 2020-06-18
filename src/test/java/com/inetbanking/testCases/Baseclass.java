package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

public class Baseclass {
	
	ReadConfig readprop = new ReadConfig() ;
	public static WebDriver driver;
	public static Logger logger;
	public  String username =readprop.getUsername();
	public  String password =readprop.getPassword();
	public  String baseurl =readprop.getURL();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger =logger.getLogger("ebanking");
		 PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		
		System.setProperty("webdriver.chrome.driver", readprop.getChrome());
		 driver = new ChromeDriver();
		}
		else if(br.equals("ie"))
		{
		
		System.setProperty("webdriver.ie.driver", readprop.getIe());
		 driver = new InternetExplorerDriver();
		}
		
		else if(br.equals("Firefox"))
		{
		
		System.setProperty("webdriver.gecko.driver", readprop.getFirefox());
		 driver = new FirefoxDriver();
		}
		
		driver.get(baseurl);
		logger.info("Navigated to url");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 
	}
	
	@AfterClass
	public void teardown()
	{
	driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	}
