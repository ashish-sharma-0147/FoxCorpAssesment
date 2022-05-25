package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import driver.DriverManager;
import utilities.TestUtil;

public class VideoFoxNewsHomePage extends PageBase{
	
@FindBy(xpath="//iframe[contains(@title,'ad content')]")
private WebElement Advertisement_frame;
	
@FindBy(xpath="//*[local-name()='html']")               /*Using this because of the dynamic dom inside iframe containing Ad*/
private WebElement htmlInsideFrame;  


@FindBy(xpath="//iframe[contains(@aria-label,'MVPD')]")
private WebElement VideoPlayer_iFrame;

@FindBy(xpath="//div[contains(@class,'progress')]")
private WebElement VideoPlayer_Progress;

@FindBy(xpath="//button[contains(@aria-label,'Jump Back')]")
private WebElement Button_VideoPalyer_JumpBack;

private final String AdFrameName="google_ads_iframe_/4145/fnc/desk/vid/lb1_0";

public void clickOnAdvertisement() {
	TestUtil.switchToFrame(AdFrameName);
	//TestUtil.wait.until(ExpectedConditions.elementToBeClickable(htmlInsideFrame));
	htmlInsideFrame.click();
	TestUtil.switchToNewTab();
	//TestUtil.wait.until(ExpectedConditions.urlContains("http"));	
}

public boolean validateAdURL() {
	System.out.println(DriverManager.getDriver().getCurrentUrl());
	return DriverManager.getDriver().getCurrentUrl().contains("http");
}

public void closeAdvertisementWindow() {
	DriverManager.getDriver().close();
}

public boolean AdPresenceCheck() {
	return Advertisement_frame.isDisplayed();
}

public void switchToDefaultContent() {
	DriverManager.getDriver().switchTo().defaultContent();
}

public int getCurrentProgressStatus() {
	DriverManager.getDriver().switchTo().frame(VideoPlayer_iFrame);
	return Integer.parseInt(VideoPlayer_Progress.getAttribute("aria-valuenow"));
}

public void clickOnBackButton() {
	DriverManager.getDriver().switchTo().frame(VideoPlayer_iFrame);
	Button_VideoPalyer_JumpBack.click();
}

}
