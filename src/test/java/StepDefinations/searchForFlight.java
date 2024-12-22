package StepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchForFlight {
	WebDriver driver = Hooks.driver;
	@Then("user click on from dropdown and select place")
	public void user_click_on_from_dropdown_and_select_place() {
	    driver.get("http://localhost:8083/FlyAwayForCucumber/home");
	    driver.findElement(Hooks.home.From_dropDown).click();
	    WebElement from_dropdown = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/select"));
	    Select city = new Select(from_dropdown);
	    city.selectByIndex(2);
	    
	}

	@And("user click on to dropdown and select place")
	public void user_click_on_to_dropdown_and_select_place() {
	    driver.findElement(Hooks.home.To_dropdown).click();
	    WebElement to_dropdown = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/select"));
	    Select city = new Select(to_dropdown);
	    city.selectByIndex(3);
	    
}

	@When("user click on submit")
	public void user_click_on_submit() {
	   driver.findElement(Hooks.home.submit_to_search_flight).click();
	}

	@Then("user able to see flight in provided src to dest path")
	public void user_able_to_see_flight_in_provided_src_to_dest_path() {
	    boolean flight_availability=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]")).isDisplayed();
	    Assert.assertEquals(flight_availability, true);
	}


}
