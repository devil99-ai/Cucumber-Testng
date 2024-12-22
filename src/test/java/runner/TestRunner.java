package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"C:/Users/svksh/eclipse-workspace/CucumberFrameworkForFlyAway/src/test/java/Features"},
		glue= {"StepDefinations","Hooks"},
		plugin= {"pretty","html:C:/Users/svksh/eclipse-workspace/CucumberFrameworkForFlyAway/target/extendReport"})

public class TestRunner extends AbstractTestNGCucumberTests {
	 
}
