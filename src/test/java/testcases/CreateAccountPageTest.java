package testcases;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import driver.DriverManager;
import pages.CreateAccountPage;
import pages.MainPage;
import pages.SignInPage;

public class CreateAccountPageTest extends TestBase{
	
	MainPage 			mainPage;
	SignInPage 			signInPage;
	CreateAccountPage	createAccountPage;
	private final int ExpectedCount = 5;
	private final String URL = "https://www.foxnews.com";
	final boolean isEnabled = true;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		DriverManager.getDriver().get(URL);
		mainPage = new MainPage();
		try {
		mainPage.signUpWithEmail("Yopmail");  /* Handling this with tryCatch because the SignUp popup stoped being displayed from 25th May, 
												 if it's displayed then SignUp will be performed else will be skipped*/
		mainPage.clickOnContinueReading();
		}catch(NoSuchElementException E)
		{
			System.out.println(E.getMessage());
		}catch(TimeoutException TE)
		{
			System.out.println(TE.getMessage());
		}
		signInPage			 = mainPage.clickOnLoginLink();
		createAccountPage 	 = signInPage.clickOnCreateAccount();
	}
	
	@Test(priority=1, enabled=isEnabled, description="Error count validation")
	public void getMandatoryErrorCount() {
		createAccountPage.clickOnCreateButton();
		int errorCount = createAccountPage.getTotalNumberOfErrors();
		Assert.assertEquals(errorCount, ExpectedCount, "Mismatch in Error count");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverManager.quit();
	}

}
