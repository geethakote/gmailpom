package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginpage {
//Define Element locators
	@FindBy(name = "email")
	public WebElement uid;
	@FindBy(name = "password")
	public WebElement pwd;
	@FindBy(xpath = "//span[text()='Continue']/ancestor::button")
	public WebElement signin;

	public CustomerLoginpage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void fillUsername(String x) {
		uid.sendKeys(x);
	}

	public void fillPassword(String x) {
		pwd.sendKeys(x);
	}

	public void clickContinue() throws Exception {
		signin.click();
		Thread.sleep(10000);
	}

}