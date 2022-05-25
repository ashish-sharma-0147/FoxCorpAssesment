package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.TestUtil;

public class CreateAccountPage extends PageBase{
	
@FindBy(xpath="//button[contains(@class,'create')]")
private WebElement Button_Create;

@FindBy(xpath="//span[@class='error']")
private List<WebElement> Text_ErrorList;

public void clickOnCreateButton() {
	TestUtil.wait.until(ExpectedConditions.visibilityOf(Button_Create));
	Button_Create.click();
}

public int getTotalNumberOfErrors() {
	TestUtil.printWebElementListText(Text_ErrorList);
	return Text_ErrorList.size();
}
}
