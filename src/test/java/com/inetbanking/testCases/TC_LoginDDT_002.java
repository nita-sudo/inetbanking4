package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.XLUtils;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends Baseclass {
	
	
	@Test(dataProvider="Logindata")
	public void loginDDT(String usr,String pwd)
	{
	
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(usr);
		logger.info("user name is passed");
		lp.setPassword(pwd);
		logger.info("password is passed");
		lp.submit();
		logger.info("Logged in");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	if (isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		try {
			captureScreen(driver, "LoginDDTtest");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(false);
		logger.warning("Login failed");
		
	}
	else
	{
		
		Assert.assertTrue(true);
		logger.info("Login suceess");
		lp.logout();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Logout suceess");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}		
	}
	
	@DataProvider(name="Logindata")
	public String[][]getData() throws IOException
	{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int row = XLUtils.getRowCount(path, "Sheet1");
		int column = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[row][column];
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<column ;j++)
			{
				 logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
