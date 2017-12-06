package com.crossover.robotframework.JavaRobot;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import com.crossover.robotframework.JavaRobot.CrossoverLandingPage;
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


@RobotKeywords

public class KeywordImplementations {
	
	static WebDriver driver  = new ChromeDriver();
	CrossoverLandingPage objcrossoverlandingpage = new CrossoverLandingPage(driver);
	
	
	@RobotKeyword("I am at the Touche Login Screen")
    @ArgumentNames({"URL", "Browser"})
	public void IAmAtTheToucheLoginScreen(String url, String Browser) {
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

public void ISelectTheMobileOptionToLogin() {
	
	objcrossoverlandingpage.SelectTheMobileOption();
 
}

@RobotKeyword("I Enter mobile number")
@ArgumentNames({ "COUNTRYCODE","PHONENUMBER" })

public void IEnterMobileNumber(String countryCode, String phoneNumber) {
	
	objcrossoverlandingpage.EnterMobileNumber(countryCode, phoneNumber);
 
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
	TearDown();
 
}


public void TearDown() {
	
	driver.quit();
 
}

	
}
