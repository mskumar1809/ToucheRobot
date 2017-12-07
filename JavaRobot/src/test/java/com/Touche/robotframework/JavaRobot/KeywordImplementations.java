package com.Touche.robotframework.JavaRobot;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.PageFactory;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Touche.robotframework.JavaRobot.ToucheLandingPage;

@RobotKeywords

public class KeywordImplementations {
	static WebDriver driver;
	ToucheLandingPage objcrossoverlandingpage;

	

	@RobotKeyword("Set Up")
	public void SetUp(){
	 driver = new ChromeDriver();
	 objcrossoverlandingpage = new ToucheLandingPage(driver);
	}
	
	@RobotKeyword("I am at the Touche Login Screen")
	@ArgumentNames({ "URL" })
	public void IAmAtTheToucheLoginScreen(String url) {
		driver.get(url);
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
		MaximizeBrowser();
		NavigatetoLoginPage();

	}
	
	public void MaximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void NavigatetoLoginPage() {

		objcrossoverlandingpage.NavigatetoLoginPage();

	}

	@RobotKeyword("I Select the Mobile Option to login")
	@Test
	public void ISelectTheMobileOptionToLogin() {

		objcrossoverlandingpage.SelectTheMobileOption();

	}
	

	@RobotKeyword("I Select the Option to login")
	@ArgumentNames({ "MOBILELOGINOPTION" })

	public void ISelectTheOptionToLogin(String loginOption) {

		objcrossoverlandingpage.SelectTheLoginOption(loginOption);

	}


	@RobotKeyword("I Enter mobile number")
	@ArgumentNames({ "COUNTRYCODE", "PHONENUMBER" })

	public void IEnterMobileNumber(String countryCode, String phoneNumber) {

		objcrossoverlandingpage.EnterMobileNumber(countryCode, phoneNumber);

	}
	
	
	@RobotKeyword("I Enter Email")
	@ArgumentNames({ "Email" })

	public void IEnterEmail(String email) {

		objcrossoverlandingpage.EnterEmail(email);

	}

	@RobotKeyword("I Enter password")
	@ArgumentNames({ "PASSWORD" })

	public void IEnterPassword(String password) {

		objcrossoverlandingpage.EnterPassword(password);

	}

	@RobotKeyword("I Login into the application")

	public void ILoginIntoTheApplication() {

		objcrossoverlandingpage.LoginIntoTheApplication();

	}

	@RobotKeyword("I should see the payments list")
	public void IShouldSeeThePaymentsList() {

		objcrossoverlandingpage.assertPaymentsList();

	}
	
	@RobotKeyword("Tear Down")
	public void TearDown() {

		driver.quit();
	}

}
