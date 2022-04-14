package automation;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;
import pages.Logoutpage;

public class Stepdef {
	public RemoteWebDriver driver;
	public Homepage obj1;
	public Loginpage obj2;
	public Composepage obj3;
	public Logoutpage obj4;

	@Given("open {string} browser")
	public void method1(String bn) {
		if (bn.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// define objects
			driver = new ChromeDriver();
			obj1 = new Homepage(driver);
			obj2 = new Loginpage(driver);
			obj3 = new Composepage(driver);
			obj4 = new Logoutpage(driver);
		}
	}

	@Given("launch site using {string}")
	public void method2(String url) throws Exception {
		driver.get(url);
		Thread.sleep(5000);
	}

	@When("do login using {string} and {string} credentials")
	public void method3(String un, String pwd) throws Exception {
		obj1.fillUserName(un);
		obj1.clickHomeNext();
		obj2.fillPassword(pwd);
		obj2.clickLoginNext();
	}

	@Then("compose is displayed")
	public void method4() {
		if (obj3.isComposeDisplayed()) {
			System.out.println("Compose is displayed");
		} else {
			System.out.println("Compose is not displayed");
		}
	}

	@When("click on compose ,fill fildes ,send mail and check responce")
	public void method5(DataTable dt) throws Exception {
		// Take data from date table
		List<Map<String, String>> l = dt.asMaps();
		for (int i = 0; i < l.size(); i++) {
			obj3.clickCompose();
			obj3.fillTo(l.get(i).get("to"));
			obj3.fillSubject(l.get(i).get("subject"));
			obj3.fillBody(l.get(i).get("body"));
			obj3.fillFilepath(l.get(i).get("attachment"));
			// send mail
			obj3.clickSend();
			System.out.println(obj3.getOutputMsg());
		}
	}

	@When("do logout")
	public void method6() throws Exception {
		obj4.clickProfile();
		obj4.clickSignout();
	}

	@Then("login page should be redisplayed")
	public void method7() {
		if (obj4.isLoginRedisplay()) {
			System.out.println("successful logout");
		} else {
			System.out.println("unsuccessful logout");
			System.exit(0);
		}
	}

	@When("close site")
	public void method8() {
		driver.close();
	}
}
