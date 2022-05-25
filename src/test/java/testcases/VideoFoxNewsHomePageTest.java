package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import driver.DriverManager;
import pages.VideoFoxNewsHomePage;
import utilities.TestUtil;

public class VideoFoxNewsHomePageTest extends TestBase {

	private final String URL = "https://video.foxnews.com/v/6136630188001#sp=show-clips%2Fdigital-originals";
	final boolean isEnabled = true;
	VideoFoxNewsHomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		DriverManager.getDriver().get(URL);
		homePage = new VideoFoxNewsHomePage();

	}
	
	@Test(priority=1, enabled=isEnabled, description="Advertisement displayed check")
	public void isAdDisplayedTest() {
		Assert.assertTrue(homePage.AdPresenceCheck(),"Advertisement Not Displayed");
	}
	
	@Test(priority=2, enabled=isEnabled, description="Advertisement URL Redirection and progressBar status Check")
	public void AdUrlRedirectTest() {
		String currentWindow = TestUtil.getCurrentWindow();
		int OldProgress = homePage.getCurrentProgressStatus();
		System.out.println("Old Progress = " +OldProgress);
		homePage.switchToDefaultContent();
		homePage.clickOnAdvertisement();
		Assert.assertTrue(homePage.validateAdURL(), "No URL Present");
		//homePage.closeAdvertisementWindow();
		TestUtil.switchDriverToWindow(currentWindow);
		homePage.switchToDefaultContent();
		int newProgress = homePage.getCurrentProgressStatus();
		System.out.println("New Progress = " +newProgress);
		boolean progress = OldProgress < newProgress;
		Assert.assertTrue(progress,"Current Progress Status should be greater");
		homePage.switchToDefaultContent();
		homePage.clickOnBackButton();
		homePage.switchToDefaultContent();
		int ProgressAfterRewind = homePage.getCurrentProgressStatus();
		System.out.println("Progress After Rewind= " +ProgressAfterRewind);
		boolean latestProgress = ProgressAfterRewind < newProgress;          
		Assert.assertTrue(latestProgress, "Latest Progress should be less"); /*Not asserting Equals here for the expected difference of -10, because sometimes due to delay
		 																	   the difference was coming as -9 or -8, Hence using '<' Operator*/
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverManager.quit();
	}
}
