package com.Touche.robotframework.Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.Assert;

import com.Touche.robotframework.Automation.ToucheLandingPage;

@RobotKeywords

public class KeywordImplementations {
	static WebDriver driver;
	ToucheLandingPage objToucheLandingPage;

	

	@RobotKeyword("Set Up")
	public void setUp(){
	 driver = new ChromeDriver();
	 objToucheLandingPage = new ToucheLandingPage(driver);
	}
	
	@RobotKeyword("I am at the Touche Login Screen")
	@ArgumentNames({ "URL" })
	public void iAmAtTheToucheLoginScreen(String url) {
		driver.get(url);
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
		maximizeBrowser();
		navigateToLoginPage();

	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void navigateToLoginPage() {
		objToucheLandingPage.navigateToLoginPage();

	}
	

	@RobotKeyword("I Select the Option to login")
	@ArgumentNames({ "EMAIlLOGINOPTION" })
	public void iSelectTheOptionToLogin(String loginOption) {
		objToucheLandingPage.selectTheLoginOption(loginOption);

	}


	@RobotKeyword("I Enter mobile number")
	@ArgumentNames({ "COUNTRYCODE", "PHONENUMBER" })
	public void iEnterMobileNumber(String countryCode, String phoneNumber) {
		objToucheLandingPage.enterMobileNumber(countryCode, phoneNumber);

	}
	
	
	@RobotKeyword("I Enter Email")
	@ArgumentNames({ "Email" })
	public void iEnterEmail(String email) {
		objToucheLandingPage.enterEmail(email);

	}

	@RobotKeyword("I Enter password")
	@ArgumentNames({ "PASSWORD" })
	public void iEnterPassword(String password) {
		objToucheLandingPage.enterPassword(password);

	}

	@RobotKeyword("I Login into the application")
	public void iLoginIntoTheApplication() {
		objToucheLandingPage.loginIntoTheApplication();

	}

	@RobotKeyword("I should see the payments list")
	public void iShouldSeeThePaymentsList() {
		objToucheLandingPage.assertPaymentsList();

	}
	
	@RobotKeyword("Tear Down")
	public void tearDown() {
		driver.quit();
	}

}
