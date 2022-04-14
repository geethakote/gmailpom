package automation;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CustomerLoginpage;
import pages.CustomerLogoutpage;
import pages.CustomersPage;
import pages.Recaptchapage;
import pages.VerificationPage;

public class CustomerStepdef {
	public RemoteWebDriver driver;
	public CustomerLoginpage obj1;
	public CustomersPage obj2;
	public CustomerLogoutpage obj3;
	public Recaptchapage obj4;
	public VerificationPage obj5;

	@Given("open a {string} browser")
	public void method1(String bn) {

		if (bn.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (bn.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		obj1 = new CustomerLoginpage(driver);
		obj2 = new CustomersPage(driver);
		obj3 = new CustomerLogoutpage(driver);
		obj4 = new Recaptchapage(driver);
		obj5 = new VerificationPage(driver);
	}

	@Given("launch a site using {string}")
	public void method2(String url) throws Exception {
		driver.get(url);
		;
		Thread.sleep(5000);
	}

	@When("do login using {string} and {string}")
	public void method3(String uid, String pwd) throws Exception {
		obj1.fillUsername(uid);
		obj1.fillPassword(pwd);
		obj1.clickContinue();
		obj4.clickIamNotRobot(driver);
		obj5.clickSkipforNow();
	}

	@Then("customer tab should be displayed")
	public void methd4() {
		if (obj2.isCustomersDisplayed()) {
			System.out.println("tab is displayed");
		} else {
			System.out.println("tab is not displayed");
			System.exit(0);
		}
	}

	@When("add customer and verify")
	public void method5(DataTable dt) throws Exception {
		List<Map<String, String>> l = dt.asMaps();
		for (int i = 0; i < l.size(); i++) {

			obj2.clickCustomer();
			obj2.clickAddCustomer();

			obj2.fillName(l.get(i).get("name"));
			obj2.fillEmail(l.get(i).get("email"));
			obj2.fillDiscription(l.get(i).get("discription"));
			obj2.clickadd();

			if (obj2.isOutputMsgDisplayed()) {
				System.out.println("successful adding a customer");
			} else {
				System.out.println("unsuccessful adding a customer");
				// System.exit(0);
			}

		}
	}

	@When("do a logout")
	public void method7() throws Exception {
		obj3.clickProfile();
		obj3.clickSignout();
	}

	@Then("login page should be displayed")
	public void method8() {
		if (obj3.isLoginRedisplayed()) {
			System.out.println("successful logedout");
		} else {
			System.out.println("unsuccessful logedout");
			System.exit(0);
		}
	}

	@When("clouse browser")
	public void method9() {
		driver.close();
	}
}
