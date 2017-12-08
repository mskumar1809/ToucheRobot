package com.Touche.robotframework.Automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ToucheLandingPage {

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
	
	By EmailIcon = By.xpath("//span[contains(.,'Email')]");
	
	By EmailTextField = By.xpath("//input[@name='email']");
			
	public ToucheLandingPage(WebDriver driver)

	{

		this.driver = driver;
	}

	public void navigateToLoginPage() {
		driver.findElement(LoginNavigation).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(LoginButton).click();
	}

	public void enterMobileNumber(String countryCode, String phoneNumber) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(CountryCode).click();
		driver.findElement(Spain).click();
		driver.findElement(PhoneNumber).sendKeys(phoneNumber);
	}

	public void enterPassword(String password) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(Password).sendKeys(password);
	}

	public void loginIntoTheApplication() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(LoginSubmit).click();
	}

	public void assertPaymentsList() {
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		String PaymentText = driver.findElement(Payment).getText();
		Assert.assertTrue(PaymentText.contains("9.90"));

	}

	public void selectTheLoginOption(String loginOption) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (loginOption.equals("Mobile")) 
			driver.findElement(Mobile).click();
		else 
			driver.findElement(EmailIcon).click();	
	}

	public void enterEmail(String email) {
		driver.findElement(EmailTextField).sendKeys(email);
		
	}

}
