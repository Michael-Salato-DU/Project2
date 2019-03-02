package behaviortests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		//feature is the outline for the test
		features = {"src/test/resources/UserExperience.feature"},
		//is where our actual code/step implementations are
		glue = {"behaviortests"}
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {
	
}