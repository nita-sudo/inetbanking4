package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewCustomerPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends Baseclass {
	
	@Test
	public void addNewCustomer()
	{
		LoginPage lpage = new LoginPage(driver);
		lpage.setUsername(username);
		logger.info("entered username");
		lpage.setPassword(password);
		logger.info("password entered");
		lpage.submit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		NewCustomerPage page = new NewCustomerPage(driver);
		
		page.clickNewCusomerLink();
		logger.info("adding new customer...");
		page.setCustomerName("Nita");
		
		page.setPassword(password);
		
		page.selectGenderFeMale();
		
		page.setCityName("Mumbai");
		
		String email=randomestring()+"@gmail.com";
		page.setEmail(email);
		page.setAddress("airoli");
		page.setState("MH");
		
		page.setMobileNo("1234557867");
		
		page.setPin("400708");
		page.custdob("10", "31", "1989");
		page.submit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else {
			
			logger.info("test case failed....");
			try {
				captureScreen(driver, "addnewCust");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			
			
		}
			
	
	}
	
	 

}
