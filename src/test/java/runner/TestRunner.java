package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/Features"},
		glue= {"src/test/java/StepDefinations"},
		tags = "@viewBooking",
		plugin= {"pretty","html:target/extendReport"})

public class TestRunner {

}
