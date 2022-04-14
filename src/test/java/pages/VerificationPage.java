package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationPage {
	@FindBy(xpath = "//span[text()='Skip for now']/..")
	public WebElement skip;

	public VerificationPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSkipforNow() throws Exception {
		try {
			skip.click();
			Thread.sleep(10000);
		} catch (Exception ex) {
			System.out.println("verification page does not exits");
		}
	}
}
