package StepDefinations;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class editProfileSteps {
	WebDriver driver = Hooks.driver;
	@Then("user clicks on edit profile option")
	public void user_clicks_on_edit_profile_option() throws InterruptedException {
		driver.get("http://localhost:8083/FlyAwayForCucumber");
		driver.findElement(Hooks.signUp_login.Login_to_continue_checking_flights).click();
		Thread.sleep(5000);
		driver.findElement(Hooks.signUp_login.input_emailid_for_login).sendKeys("jhonny@gmail.com");
		driver.findElement(Hooks.signUp_login.input_password_for_login).sendKeys("Souvik99@");
		driver.findElement(Hooks.signUp_login.submit_login_btn);
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/button")).click();
	    driver.findElement(Hooks.edit.edit_profile_btn);
	}
	@And("user navigated to edit profile page")
	public void user_navigated_to_edit_profile_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8083/FlyAway/editprofile");
	    
	}

	@Then("user change details")
	public void user_change_details() {
		driver.findElement(Hooks.edit.address).sendKeys("A.C.Road(north)");
	}

	@Then("user provided passwords")
	public void user_provided_passwords() {
		driver.findElement(Hooks.edit.password).sendKeys("Souvik98@");
		driver.findElement(Hooks.edit.confirm_passwd).sendKeys("Souvik98@");
	}

	@Then("user clicks on update")
	public void user_clicks_on_update() {
	    driver.findElement(Hooks.edit.update_btn).click();
	}

	@Then("user successfully edited profile")
	public void user_successfully_edited_profile() {
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl= "http://localhost:8083/FlyAway/dashboard";
	    Assert.assertEquals("user successfully edited profile",actualUrl,expectedUrl);
	}


}
