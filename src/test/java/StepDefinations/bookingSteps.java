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
import io.cucumber.messages.types.Hook;

public class bookingSteps {
	WebDriver driver = Hooks.driver;
	
	@When("user in on home page")
	public void user_in_on_home_page() throws InterruptedException {
		driver.get("http://localhost:8083/FlyAwayForCucumber");
		driver.findElement(Hooks.signUp_login.Login_to_continue_checking_flights).click();
		Thread.sleep(5000);
		driver.findElement(Hooks.signUp_login.input_emailid_for_login).sendKeys("jhonny@gmail.com");
		driver.findElement(Hooks.signUp_login.input_password_for_login).sendKeys("Souvik99@");
		driver.findElement(Hooks.signUp_login.submit_login_btn);
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/button")).click();
	    driver.findElement(Hooks.afterLogin.home_btn).click();
	}

	@Then("user clicks on book flight")
	public void user_clicks_on_book_flight() {
	    driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[6]/a")).click();
	}

	@Then("user navigate to payment gateway page")
	public void user_navigate_to_payment_gateway_page() throws InterruptedException {
	    Thread.sleep(5000);
	}

	@When("user clicks on complete booking")
	public void user_clicks_on_complete_booking() {
	    driver.findElement(Hooks.book.complete_booking_btn).click();
	}

	@Then("user gets confirmation of flight booking")
	public void user_gets_confirmation_of_flight_booking() {
	    String confirmation = driver.getTitle();
	    Assert.assertEquals("Fly Away  - Booking Confirmation",confirmation);
	}

}
