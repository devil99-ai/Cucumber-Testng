package StepDefinations;

import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Hooks.Hooks;
import PageObjectModel.EditProfileElement;
import PageObjectModel.HomePageElement;
import PageObjectModel.LoginAndSignUpElement;
import PageObjectModel.afterLoginElements;
import PageObjectModel.bookingElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps  {
	WebDriver driver = Hooks.driver;
	
	@Given("user is in flyaway home page")
	public void user_is_in_flyaway_home_page() {
	    driver.get("http://localhost:8083/FlyAwayForCucumber");
	}

	@Then("user clicks on login\\/signup")
	public void user_clicks_on_login_signup() {
		driver.findElement(Hooks.home.login_or_signUp_btn).click();
	}

	@Then("user clicks on register")
	public void user_clicks_on_register() {
	    driver.findElement(Hooks.signUp_login.Not_a_member_Signup).click();
	}

	@Then("user fill details and click on signup")
	public void user_fill_details_and_click_on_signup() {
	    driver.findElement(Hooks.signUp_login.input_emailid_for_signUp).sendKeys("jhonny@gmail.com");
	    driver.findElement(Hooks.signUp_login.input_name_for_signUp).sendKeys("souvik");
	    driver.findElement(Hooks.signUp_login.input_passwd_for_signUp).sendKeys("Souvik99@");
	    driver.findElement(Hooks.signUp_login.input_confirm_passwd_for_signUp).sendKeys("Souvik99@");
	    driver.findElement(Hooks.signUp_login.input_address_for_signUp).sendKeys("A.C.Road");
	    driver.findElement(Hooks.signUp_login.input_city_for_signUp).sendKeys("Berhampore");
	    driver.findElement(Hooks.signUp_login.signup_btn_after_fill_details).click();
	}

	@Then("user gets successfully registered page")
	public void user_gets_successfully_registered_page() {
	    Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8083/FlyAwayForCucumber/signupaction");
	}

	

}
