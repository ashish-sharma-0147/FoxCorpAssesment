package utilities;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import driver.DriverManager;

public class TestUtil 
{
	public static Faker faker = new Faker();
	private static final String underscore = "_";
	private static final String atTheRate = "@";
	private static final String dotCom = ".com";
	private static final String White_Space = " ";
	private static final String blank_string = "";
	public static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(50));
	public static Actions action = new Actions(DriverManager.getDriver());
	
	public static String getRandomEmail(String Domain) {
		return faker.lorem().word().trim() + faker.number().randomDigit() + underscore
				+ faker.animal().name().trim().replace(White_Space, blank_string) + underscore
				+ faker.number().randomDigit() + atTheRate + Domain + dotCom;
	}
	
	public static void switchToFrame(String frameName) {
		DriverManager.getDriver().switchTo().frame(frameName);
	}
	
	public static void printWebElementListText(List<WebElement> elements) {
		for(WebElement e: elements) {
			System.out.println(e.getText());
		}
	}
	
	// GetCurrentWindowHandle
	public static String getCurrentWindow() {
		return DriverManager.getDriver().getWindowHandle();
	}

	// Get All Active Windows
	private static Set<String> getAllActiveWindows(String frameName) {
		Set<String> ActiveTabs = DriverManager.getDriver().getWindowHandles();
		return ActiveTabs;
	}

	// switch driver to new window
	public static WebDriver switchDriverToWindow(String windowHandle) {
		return DriverManager.getDriver().switchTo().window(windowHandle);
	}

	// Switch to new tab
	public static void switchToNewTab() {
		String parentWindow = TestUtil.getCurrentWindow();
		Set<String> windowSet = TestUtil.getAllActiveWindows(parentWindow);
		for (String child : windowSet) {
			if (!parentWindow.equals(child)) {
				TestUtil.switchDriverToWindow(child);
			}
		}
	}
}
