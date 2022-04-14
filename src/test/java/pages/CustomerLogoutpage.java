package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLogoutpage {
	@FindBy(xpath = "//*[name()='svg' and @aria-controls='menu7']")
	public WebElement profile;
	@FindBy(xpath = "//span[text()='Sign out']/ancestor::button")
	public WebElement signout;
	@FindBy(xpath = "//span[text()='Sign in to your account']")
	public WebElement relogin;

//Constructor method
	public CustomerLogoutpage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Operational and observation method
	public void clickProfile() throws Exception {
		profile.click();
		Thread.sleep(10000);
	}

	public void clickSignout() throws Exception {
		signout.click();
		Thread.sleep(15000);
	}

	public boolean isLoginRedisplayed() {
		try {
			if (relogin.isDisplayed()) {
				return (true);
			} else {
				return (false);
			}
		} catch (Exception ex) {
			return (false);
		}
	}
}
