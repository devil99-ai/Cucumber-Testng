package Hooks; 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModel.EditProfileElement;
import PageObjectModel.HomePageElement;
import PageObjectModel.LoginAndSignUpElement;
import PageObjectModel.afterLoginElements;
import PageObjectModel.bookingElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    public static WebDriver driver;
    public static HomePageElement home = new HomePageElement();
    public static LoginAndSignUpElement signUp_login = new LoginAndSignUpElement();
    public static afterLoginElements afterLogin = new afterLoginElements();
    public static bookingElement book = new bookingElement();
    public static EditProfileElement edit = new EditProfileElement();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
    }
   

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
