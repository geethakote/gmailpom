package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
//Element locator
	@FindBy(xpath = "//a[starts-with(@aria-label,'Google Account')]")
	public WebElement profile;
	@FindBy(linkText = "Sign out")
	public WebElement signout;
	@FindBy(xpath = "//span[text()='Choose an account']")
	public WebElement reLogin;

	// constructor method
	public Logoutpage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Operational and observation method
	public void clickProfile() throws Exception {
		profile.click();
		Thread.sleep(5000);
	}

	public void clickSignout() throws Exception {
		signout.click();
		Thread.sleep(5000);
	}

	public boolean isLoginRedisplay() {
		if (reLogin.isDisplayed()) {
			return (true);
		} else {
			return (false);
		}
	}
}
