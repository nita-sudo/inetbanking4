package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how= How.NAME , using="uid")
	WebElement username ;
	
	@FindBy(how= How.NAME , using="password")
	WebElement password ;
	
	@FindBy(how= How.NAME , using="btnLogin")
	WebElement login ;
	
	
	@FindBy(how= How.XPATH , using="//a[text()=\"Log out\"]")
	WebElement logout ;

	
	public void setUsername(String uname)
	{

		username.sendKeys(uname);
	}

	public void setPassword(String pwd)
	{

		password.sendKeys(pwd);
	}

	public void submit()
	{

		login.click();
	}
	
	public void logout()
	{

		logout.click();
	}

}