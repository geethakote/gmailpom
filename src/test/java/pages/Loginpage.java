package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
//Element locator
	@FindBy(name = "password")
	public WebElement password;
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	public WebElement loginNext;

	// constructor method
	public Loginpage(RemoteWebDriver driver) {
		// connect "driver"object to above defined locator
		PageFactory.initElements(driver, this);
	}

	// Operational and observation method
	public void fillPassword(String x) {
		password.sendKeys(x);
	}

	public void clickLoginNext() throws Exception {
		loginNext.click();
		Thread.sleep(5000);
	}

}
