package StepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModel.EditProfileElement;
import PageObjectModel.HomePageElement;
import PageObjectModel.LoginAndSignUpElement;
import PageObjectModel.afterLoginElements;
import PageObjectModel.bookingElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlyAwayStepDefinations {
	WebDriver driver;
	HomePageElement home = new HomePageElement();
	LoginAndSignUpElement signUp_login = new LoginAndSignUpElement();
	afterLoginElements afterLogin = new afterLoginElements();
	bookingElement book = new bookingElement();
	EditProfileElement edit = new EditProfileElement();
	@Before
	public void setUp() {
        // Initialize WebDriver before each scenario
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // Close WebDriver after each scenario
        if (driver != null) {
            driver.quit();
        }
    }
	@Given("user is in flyaway home page")
	public void user_is_in_flyaway_home_page() {
		WebDriverManager.chromedriver().setup();
	    driver.get("http://localhost:8084/FlyAway");
	}

	@Then("user clicks on login\\/signup")
	public void user_clicks_on_login_signup() {
		driver.findElement(home.login_or_signUp_btn).click();
	}

	@Then("user clicks on register")
	public void user_clicks_on_register() {
	    driver.findElement(signUp_login.Not_a_member_Signup).click();
	}

	@Then("user fill details and click on signup")
	public void user_fill_details_and_click_on_signup() {
	    driver.findElement(signUp_login.input_emailid_for_signUp).sendKeys("jhonny@gmail.com");
	    driver.findElement(signUp_login.input_name_for_signUp).sendKeys("souvik");
	    driver.findElement(signUp_login.input_passwd_for_signUp).sendKeys("Souvik99@");
	    driver.findElement(signUp_login.input_confirm_passwd_for_signUp).sendKeys("Souvik99@");
	    driver.findElement(signUp_login.input_address_for_signUp).sendKeys("A.C.Road");
	    driver.findElement(signUp_login.input_city_for_signUp).sendKeys("Berhampore");
	    driver.findElement(signUp_login.signup_btn_after_fill_details).click();
	}

	@Then("user gets successfully registered page")
	public void user_gets_successfully_registered_page() {
	    Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8084/FlyAway/registerconfirm");
	}

	@Then("user navigates to login page")
	public void user_navigates_to_login_page() {
	    driver.findElement(signUp_login.Login_to_continue_checking_flights).click();
	}

	@When("user provide wrong email and password")
	public void user_provide_wrong_email_and_password() {
		driver.findElement(signUp_login.input_emailid_for_login).sendKeys("wrong@email.com");
		driver.findElement(signUp_login.input_password_for_login).sendKeys("SOuvikwrong11@");
		


	}

	@When("user clicks on login")
	public void user_clicks_on_login() {
		driver.findElement(signUp_login.submit_login_btn);
		
	}

	@Then("user gets login failed")
	public void user_gets_login_failed() {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/text()[3]")).getText(), " Login Failed ");
	}

	@When("user provide vaild email and password")
	public void user_provide_vaild_email_and_password() {
		driver.findElement(signUp_login.input_emailid_for_login).sendKeys("ssvkshrm@gmail.com");
		driver.findElement(signUp_login.input_password_for_login).sendKeys("Souvik99@");
	}

	@Then("user able to successfully login")
	public void user_able_to_successfully_login() {
		driver.findElement(signUp_login.submit_login_btn);
		Assert.assertTrue("user successfully logged in",driver.findElement(afterLogin.logout_btn).isDisplayed());
	}

	@When("user in on home page")
	public void user_in_on_home_page() {
	    driver.findElement(afterLogin.home_btn).click();
	}

	@Then("user clicks on book flight")
	public void user_clicks_on_book_flight() {
	    driver.findElement(home.blr_to_chn_book_flight).click();
	}

	@Then("user navigate to payment gateway page")
	public void user_navigate_to_payment_gateway_page() throws InterruptedException {
	    Thread.sleep(5000);
	}

	@When("user clicks on complete booking")
	public void user_clicks_on_complete_booking() {
	    driver.findElement(book.complete_booking_btn).click();
	}

	@Then("user gets confirmation of flight booking")
	public void user_gets_confirmation_of_flight_booking() {
	    String confirmation = driver.getTitle();
	    Assert.assertEquals(confirmation, "FLYAWAY - BOOKING CONFIRMATION");
	}

	@Then("user is on fflyaway home page")
	public void user_is_on_fflyaway_home_page() {
	   driver.navigate().to("http://localhost:8084/FlyAway/home");
	}

	@When("user clicks on your bookings")
	public void user_clicks_on_your_bookings() {
	   driver.findElement(afterLogin.your_booking_btn).click();
	}

	@Then("user able to see bookings")
	public void user_able_to_see_bookings() {
	    Assert.assertEquals("Total 1 bookings", driver.findElement(By.xpath("/html/body/text()[5]")));
	}

	@Then("user click on from dropdown and select place")
	public void user_click_on_from_dropdown_and_select_place() {
	    driver.navigate().to("http://localhost:8084/FlyAway/home");
	    driver.findElement(home.From_dropDown).click();
	    List<WebElement> allOptions = driver.findElements(By.cssSelector("//select Source"));
	    String option ="Bangalore";
	    for (int i = 0; i < allOptions.size(); i++) {
	    	if (allOptions.get(i).getText().contains(option)) {
	    		allOptions.get(i).click();
	    		System.out.println("clicked");
	    		
	    		break;
	    		}
	    	}
	    
	}

	@And("user click on to dropdown and select place")
	public void user_click_on_to_dropdown_and_select_place() {
	    driver.findElement(home.To_dropdown).click();
	    List<WebElement> allOptions = driver.findElements(By.cssSelector("//select Destination"));
	    String option ="Chennai";
	    for (int i = 0; i < allOptions.size(); i++) {
	    	if (allOptions.get(i).getText().contains(option)) {
	    		allOptions.get(i).click();
	    		System.out.println("clicked");
	    		
	    		break;
	    		}
	    	}
}

	@When("user click on submit")
	public void user_click_on_submit() {
	   driver.findElement(home.submit_to_search_flight).click();
	}

	@Then("user able to see flight in provided src to dest path")
	public void user_able_to_see_flight_in_provided_src_to_dest_path() {
	    boolean flight_availability=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]")).isDisplayed();
	    Assert.assertEquals(flight_availability, true);
	}

	@Then("user select place from FROM dropdown")
	public void user_select_place_from_from_dropdown() {
		 driver.findElement(home.From_dropDown).click();
		    List<WebElement> allOptions = driver.findElements(By.cssSelector("//select Source"));
		    String option ="Hydrabad";
		    for (int i = 0; i < allOptions.size(); i++) {
		    	if (allOptions.get(i).getText().contains(option)) {
		    		allOptions.get(i).click();
		    		System.out.println("clicked");
		    		
		    		break;
		    		}
		    	}
	}

	@Then("user select place from TO dropdown")
	public void user_select_place_from_to_dropdown() {
		 driver.findElement(home.To_dropdown).click();
		    List<WebElement> allOptions = driver.findElements(By.cssSelector("//select Destination"));
		    String option ="Bangalore";
		    for (int i = 0; i < allOptions.size(); i++) {
		    	if (allOptions.get(i).getText().contains(option)) {
		    		allOptions.get(i).click();
		    		System.out.println("clicked");
		    		
		    		break;
		    		}
		    	}
	}

	@Then("user clicks on submit")
	public void user_clicks_on_submit() {
		driver.findElement(home.submit_to_search_flight).click();
	}

	@Then("user see empty list")
	public void user_see_empty_list() {
		boolean flight_availability=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]")).isDisplayed();
	    Assert.assertEquals(flight_availability, false);
	}

	@Then("user clicks on edit profile option")
	public void user_clicks_on_edit_profile_option() {
	    driver.findElement(edit.edit_profile_btn);
	}

	@And("user navigated to edit profile page")
	public void user_navigated_to_edit_profile_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8084/FlyAway/editprofile");
	    
	}

	@Then("user change details")
	public void user_change_details() {
		driver.findElement(edit.address).sendKeys("A.C.Road(north)");
	}

	@Then("user provided passwords")
	public void user_provided_passwords() {
		driver.findElement(edit.password).sendKeys("Souvik98@");
		driver.findElement(edit.confirm_passwd).sendKeys("Souvik98@");
	}

	@Then("user clicks on update")
	public void user_clicks_on_update() {
	    driver.findElement(edit.update_btn).click();
	}

	@Then("user successfully edited profile")
	public void user_successfully_edited_profile() {
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl= "http://localhost:8084/FlyAway/dashboard";
	    Assert.assertEquals("user successfully edited profile",actualUrl,expectedUrl);
	}


}
