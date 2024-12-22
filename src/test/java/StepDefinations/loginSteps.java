package StepDefinations;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Hooks.Hooks;
import PageObjectModel.EditProfileElement;
import PageObjectModel.HomePageElement;
import PageObjectModel.LoginAndSignUpElement;
import PageObjectModel.afterLoginElements;
import PageObjectModel.bookingElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	WebDriver driver = Hooks.driver;
	@Then("user navigates to login page")
	public void user_navigates_to_login_page() {
		driver.get("http://localhost:8083/FlyAwayForCucumber");
	    driver.findElement(Hooks.signUp_login.Login_to_continue_checking_flights).click();
	}

	@When("user provide wrong email and password")
	public void user_provide_wrong_email_and_password() {
		driver.findElement(Hooks.signUp_login.input_emailid_for_login).sendKeys("wrong@email.com");
		driver.findElement(Hooks.signUp_login.input_password_for_login).sendKeys("SOuvikwrong11@");
		


	}

	@When("user clicks on login")
	public void user_clicks_on_login() {
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/button")).click();
		
	}

	@Then("user gets login failed")
	public void user_gets_login_failed() {
		Assert.assertEquals("Login Failed due to incorrect credential",driver.getCurrentUrl(),"http://localhost:8083/FlyAwayForCucumber/loginaction");
	}

	@When("user provide vaild email and password")
	public void user_provide_vaild_email_and_password() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(Hooks.signUp_login.input_emailid_for_login).sendKeys("jhonny@gmail.com");
		driver.findElement(Hooks.signUp_login.input_password_for_login).sendKeys("Souvik99@");
	}

	@Then("user able to successfully login")
	public void user_able_to_successfully_login() {
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/button")).click();
		Assert.assertTrue(driver.findElement(Hooks.afterLogin.logout_btn).isDisplayed(),"user successfully logged in");
	}

}
