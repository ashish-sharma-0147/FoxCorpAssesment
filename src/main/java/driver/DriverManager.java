package driver;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager 
{
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); /* using this only for getter and setter*/
   
	public WebDriver createInstance() {
		
		return WebDriverManager.chromedriver().create();
	}
	
	public static WebDriver getDriver() {

		return driver.get();

	}

	public static void setWebDriver(WebDriver driver) {

		DriverManager.driver.set(driver);
	}
	
	public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }
}
