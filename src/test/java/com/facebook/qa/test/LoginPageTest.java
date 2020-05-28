package com.facebook.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.facebook.qa.base.BaseClass;
import com.facebook.qa.pages.LoginPage;

public class LoginPageTest {
	Properties prop;
	WebDriver driver;

	BaseClass basePage;
	LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		basePage = new BaseClass();
		prop = basePage.init_prop();
		driver = basePage.setup(prop);
		loginPage = new LoginPage(driver);
	}

	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getTitleText();
		System.out.println("login page title is : " + title);
		//Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void verifySignupLinkTest()
	{
		Assert.assertTrue(loginPage.checkSignUpLink());
	}
	@Test(priority=3)
	public void verifyLoginTest() throws InterruptedException
	{
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
	}
	@AfterTest
	public void tearDown()
	{
		loginPage.tearDown();
	}
	

}
