package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.TestUtil;

public class SignInPage extends PageBase {
	
@FindBy(name="email")
private WebElement TextBox_email;

@FindBy(xpath="//input[@class='foxid-input-password']")
private WebElement TextBox_password;

@FindBy(xpath="//button[contains(@class,'login')]")
private WebElement Button_Login;

@FindBy(xpath="//button[contains(@class,'create-account')]")
private WebElement Button_createAccount;

private final String CreateAccountURL = "https://my.foxnews.com/?p=create-account";

public CreateAccountPage clickOnCreateAccount() {
	TestUtil.wait.until(ExpectedConditions.visibilityOf(Button_createAccount));
	Button_createAccount.click();
	TestUtil.wait.until(ExpectedConditions.urlToBe(CreateAccountURL));
	return new CreateAccountPage();
}
}
