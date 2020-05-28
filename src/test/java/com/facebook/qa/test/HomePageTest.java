package com.facebook.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.facebook.qa.base.BaseClass;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class HomePageTest {
	Properties prop;
	WebDriver driver;

	BaseClass basePage;
	LoginPage loginPage;
	HomePage homepage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BaseClass();
		prop = basePage.init_prop();
		driver = basePage.setup(prop);
		loginPage = new LoginPage(driver);
		homepage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=2)
	public void verifyHomePageTitleTest() {
		String title = homepage.getTitleMethod();
		System.out.println("Hompage title is : " + title);
		Assert.assertEquals(title,"Facebook - Log In or Sign Up" );
	}
	@Test(priority=1)
	public void verifyUserNameTest()
	{
		String title1= homepage.verifyUserName();
		System.out.println("username is "+title1);
		Assert.assertEquals(title1, "Nagaraju");
	}

@AfterTest
public void tearDown()
{
	driver.quit();
}
}
