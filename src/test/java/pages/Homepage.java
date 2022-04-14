package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
//Element locators
	@FindBy(how = How.NAME, using = "identifier")
	public WebElement Username;
	@FindBy(xpath = "//span[text()='Next']/..")
	public WebElement HomeNext;

	// constructor method
	public Homepage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// operational and observation method
	public void fillUserName(String x) {
		Username.sendKeys(x);
	}

	public void clickHomeNext() throws Exception {
		HomeNext.click();
		Thread.sleep(5000);
	}
}
