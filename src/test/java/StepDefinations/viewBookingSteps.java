package StepDefinations;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class viewBookingSteps {
	WebDriver driver = Hooks.driver;
	@Then("user is on fflyaway home page")
	public void user_is_on_fflyaway_home_page() {
	   driver.get("http://localhost:8083/FlyAwayForCucumber");
	   driver.findElement(By.xpath("/html/body/a[2]")).click();
	   driver.findElement(Hooks.signUp_login.input_emailid_for_login).sendKeys("jhonny@gmail.com");
	   driver.findElement(Hooks.signUp_login.input_password_for_login).sendKeys("Souvik99@");
	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/button")).click();
	   
	}

	@When("user clicks on your bookings")
	public void user_clicks_on_your_bookings() {
	   driver.findElement(Hooks.afterLogin.your_booking_btn).click();
	}

	@Then("user able to see bookings")
	public void user_able_to_see_bookings() {
	    Assert.assertEquals("Total 1 bookings", driver.findElement(By.xpath("/html/body/text()[5]")));
	}


}
