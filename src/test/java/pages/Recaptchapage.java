package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recaptchapage {
	@FindBy(xpath = "//span[@role='checkbox']/div[1]")
	public WebElement notRobot;

	public Recaptchapage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickIamNotRobot(RemoteWebDriver driver) throws Exception {
		try {
			WebElement e = driver.findElement(By.xpath("//iframe[@tittle=reCAPTCHA'])"));
			driver.switchTo().frame(e);
			notRobot.click();
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
		}

		catch (Exception ex) {
			System.out.println("Recatch page does not exist");
		}
	}
}
