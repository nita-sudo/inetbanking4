package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage
{
	WebDriver ldriver;
	public NewCustomerPage(WebDriver rdriver) {
	
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.XPATH, using="//a[text()=\"New Customer\"]")
	WebElement NewCusomerLink;
	
	@FindBy(how=How.NAME, using="name")
	WebElement cusomerName;
	
	@FindBy(how=How.XPATH,using="//input[@type=\"radio\" and @value=\"m\"]")
	WebElement male;
	
	@FindBy(how=How.XPATH,using="//input[@type=\"radio\" and @value=\"f\"]")
	WebElement female;
	
	@FindBy(how=How.NAME, using="city")
	WebElement city;
	
	@FindBy(how=How.NAME, using="addr")
	WebElement address;
	
	@FindBy(how=How.NAME, using="state")
	WebElement state;
	
	
	@FindBy(how=How.NAME, using="pinno")
	WebElement pin;
	
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement mobileno;
	
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement email;
	
	
	@FindBy(how=How.NAME, using="password")
	WebElement password;
	
	@FindBy(how=How.NAME, using="sub")
	WebElement submit;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;
	
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	
	public void clickNewCusomerLink()
	{
		NewCusomerLink.click();
	}
	
	public void submit()
	{
		submit.click();
	}
	
	public void selectGenderMale()
	{
		male.click();
	}
	
	public void selectGenderFeMale()
	{
		female.click();
	}
	
	
	public void setCustomerName(String custName)
	{
		cusomerName.sendKeys(custName);
	}
	
	public void setCityName(String rcity)
	{
		city.sendKeys(rcity);
	}
	
	public void setPin(String rpin)
	{
		pin.sendKeys(rpin);
	}
	
	public void setState(String rstate)
	{
		state.sendKeys(rstate);
	}
	
	public void setMobileNo(String rmobileno)
	{
		mobileno.sendKeys(rmobileno);
	}
	
	public void setPassword(String rpassword)
	{
		password.sendKeys(rpassword);
	}
	
	public void setEmail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void setAddress(String raddress)
	{
		address.sendKeys(raddress);
	}

}
