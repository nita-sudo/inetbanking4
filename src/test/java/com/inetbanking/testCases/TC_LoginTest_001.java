package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.ReadConfig;
import com.inetbanking.pageObjects.LoginPage;




public class TC_LoginTest_001 extends Baseclass{


	
	@Test
	public void login()
	{
		LoginPage loginpg = new LoginPage(driver);
		
		loginpg.setUsername(username);
		logger.info("user name is entered");
		loginpg.setPassword(password);
		logger.info("password is entered");
		loginpg.submit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("test is passed");
		}
		else
		{
			try {
				captureScreen(driver, "Login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("test is failed");
		}
	}
}
