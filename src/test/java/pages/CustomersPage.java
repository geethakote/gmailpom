package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
//Element locator
	@FindBy(xpath = "//span[text()='Customers']/ancestor::a")
	public WebElement customer;
	@FindBy(xpath = "//span[text()='Add customer']/ancestor::button")
	public WebElement addcustomer;
	@FindBy(xpath = "//input[contains(@name,'name')]")
	public WebElement name;
	@FindBy(name = "email")
	public WebElement email;
	@FindBy(name = "description")
	public WebElement description;
	@FindBy(xpath = "(//span[text()='Add customer']/ancestor::button)[2]")
	public WebElement add;
	@FindBy(xpath = "((//span[text()='Customer created']")
	public WebElement outputmsg;

//constructor method
	public CustomersPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean isCustomersDisplayed() {
		try {
			if (customer.isDisplayed()) {
				return (true);
			} else {
				return (false);
			}
		} catch (Exception ex) {
			return (false);
		}
	}

	public void clickCustomer() throws Exception {
		customer.click();
		Thread.sleep(20000);
	}

	public void clickAddCustomer() throws Exception {
		addcustomer.click();
		Thread.sleep(10000);
	}

	public void fillName(String x) {
		name.sendKeys(x);
	}

	public void fillEmail(String x) {
		email.sendKeys(x);
	}

	public void fillDiscription(String x) {
		description.sendKeys(x);
	}

	public void clickadd() throws Exception {
		add.click();
		Thread.sleep(20000);
	}

	public boolean isOutputMsgDisplayed() {
		try {

			if (outputmsg.isDisplayed()) {
				return (true);
			} else {
				return (false);
			}
		} catch (Exception ex) {
			return (false);
		}
	}
}
