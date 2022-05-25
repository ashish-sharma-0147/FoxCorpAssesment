package base;

import org.openqa.selenium.support.PageFactory;

import driver.DriverManager;



public class PageBase {
	
	protected PageBase() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

}
