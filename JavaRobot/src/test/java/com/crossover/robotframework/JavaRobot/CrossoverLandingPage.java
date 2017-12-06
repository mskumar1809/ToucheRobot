package com.crossover.robotframework.JavaRobot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class CrossoverLandingPage {
 
	WebDriver driver;
	
	
	By Spain = By.xpath("//span[contains(.,'Spain (España)')]");
	
	By LoginNavigation = By.xpath("//*[@id='top-nav']/ul/li[8]/a");
	
	By LoginButton = By.xpath(".//*[@id='main-view']/section/div/div[2]/a/div[2]/button");
	
	By Mobile = By.xpath(".//*[@id='main-view']/section/div/div/div[1]/form/div[1]/div[1]/ul/li[2]/span");
	
	By CountryCode = By.xpath("//div[@class='selected-dial-code']");
	
	By PhoneNumber = By.xpath("//input[@name='phone']");
	
	By Password = By.xpath("//input[@name='password']");
	
	By LoginSubmit = By.xpath("//button[@type='submit']");
	
	By Payment = By.xpath("//div[contains(.,'$ 9.90')]");
  
	public CrossoverLandingPage(WebDriver driver)
 
	{
 
		this.driver = driver;
	}
	
	
	public void NavigatetoLoginPage()  {
		driver.findElement(LoginNavigation).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(LoginButton).click();
	}
	
	public void SelectTheMobileOption()  {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(Mobile).click();
	}
	
	public void EnterMobileNumber(String countryCode, String phoneNumber)  {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(CountryCode).click();
		driver.findElement(Spain).click();
		driver.findElement(PhoneNumber).sendKeys(phoneNumber);
	}
	
	public void EnterPassword(String password)  {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(Password).sendKeys(password);
	}
	
	public void LoginIntoTheApplication()  {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(LoginSubmit).click();
	}
	
	public void assertPaymentsList()  {
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		String PaymentText = driver.findElement(Payment).getText();
		Assert.assertTrue(PaymentText.contains("9.90"));
		
	}
	
}


	  


