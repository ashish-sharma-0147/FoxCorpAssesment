package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import driver.DriverManager;
import utilities.TestUtil;


public class MainPage extends PageBase{
    
@FindBy(xpath="//label[text()='FOX Nation']")
private WebElement RadioButton_FoxNation;

@FindBy(id="email")
private WebElement TextBox_Widget_Email;

@FindBy(tagName="button")
private WebElement Button_Widget_Submit;

@FindBy(xpath="//button[contains(@class,'close')]")
private WebElement Button_Widget_Close;

@FindBy(xpath="//button[text()='Continue reading']")
private WebElement Button_Widget_ContinueReading;

@FindBy(linkText="Login")
private WebElement Button_Link_Login;

@FindBy(partialLinkText="ogi")
private WebElement Button_Link_Login_PartialLink;

@FindBy(xpath="//a[@class='login']")
private WebElement Button_Link_Login2;
private final String SignInPageURL = "https://my.foxnews.com/";

public void signUpWithEmail(String domain) {
	TestUtil.wait.until(ExpectedConditions.visibilityOf(RadioButton_FoxNation));
	((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.stop();");
	RadioButton_FoxNation.click();
	TextBox_Widget_Email.sendKeys(TestUtil.getRandomEmail(domain));
	Button_Widget_Submit.click();
}

public void clickOnContinueReading() {
	if(Button_Widget_ContinueReading.isDisplayed()) {   //This If condition is to handle the Button which is not frequently displayed. If displayed then click else nothing happens.
	TestUtil.wait.until(ExpectedConditions.visibilityOf(Button_Widget_ContinueReading));
	Button_Widget_ContinueReading.click();
	}
}

public SignInPage clickOnLoginLink(){
	TestUtil.wait.until(ExpectedConditions.visibilityOf(Button_Link_Login_PartialLink));
	Button_Link_Login.click();
	TestUtil.wait.until(ExpectedConditions.urlToBe(SignInPageURL));
	return new SignInPage();
}
}
