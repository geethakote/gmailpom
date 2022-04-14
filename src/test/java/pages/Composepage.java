package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Composepage {
//Element locator
	@FindBy(xpath = "//div[text()='Compose']")
	public WebElement compose;
	@FindBy(name = "to")
	public WebElement to;
	@FindBy(name = "subjectbox")
	public WebElement subject;
	@FindBy(xpath = "//div[@aria-label='Message Body']")
	public WebElement body;
	@FindBy(name = "Filedata")
	public WebElement attachment;
	@FindBy(xpath = "//div[text()='Send']")
	public WebElement send;
	@FindBy(xpath = "//div[@role='alert']/descendant::span[2]")
	public WebElement outputMsg;

//Constructor method
	public Composepage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// operational and observation methods
	public boolean isComposeDisplayed() {
		if (compose.isDisplayed()) {
			return (true);
		} else {
			return (false);
		}
	}

	public void clickCompose() throws Exception {
		compose.click();
		Thread.sleep(5000);
	}

	public void fillTo(String x) {
		to.sendKeys(x);
	}

	public void fillSubject(String x) {
		subject.sendKeys(x);
	}

	public void fillBody(String x) {
		body.sendKeys(x);
	}

	public void fillFilepath(String x) throws Exception {
		attachment.sendKeys(x);
		Thread.sleep(5000);
	}

	public void clickSend() throws Exception {
		send.click();
		Thread.sleep(5000);
	}

	public String getOutputMsg() {
		String x = outputMsg.getText();
		return (x);

	}
}
