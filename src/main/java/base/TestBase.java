package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import driver.DriverManager;

public class TestBase 
{

	@BeforeMethod(alwaysRun = true)
	public void setUpBase() 
	{
		DriverManager driverManager  = new DriverManager();
		WebDriver driver = driverManager.createInstance();
		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		//DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
}
