package StepDefinations;

import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Hooks.Hooks;
import io.cucumber.java.en.Then;

public class secondSearchForFlight {
	
	WebDriver driver = Hooks.driver;
	
	@Then("user select place from FROM dropdown")
	public void user_select_place_from_from_dropdown() {
		driver.get("http://localhost:8083/FlyAwayForCucumber");
		driver.findElement(Hooks.home.From_dropDown).click();
		WebElement from_dropdown = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/select"));
		Select city = new Select(from_dropdown);
		city.selectByIndex(1);
		 
	}

	@Then("user select place from TO dropdown")
	public void user_select_place_from_to_dropdown() {
		 driver.findElement(Hooks.home.To_dropdown).click();
		 WebElement to_dropdown = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/select"));
		 Select city = new Select(to_dropdown);
		 city.selectByIndex(4);
		      
		    
	}

	@Then("user clicks on submit")
	public void user_clicks_on_submit() {
		driver.findElement(Hooks.home.submit_to_search_flight).click();
	}

	@Then("user see empty list")
	public void user_see_empty_list() {
		boolean flight_availability=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]")).isDisplayed();
	    Assert.assertEquals(flight_availability, false);
	}

}
