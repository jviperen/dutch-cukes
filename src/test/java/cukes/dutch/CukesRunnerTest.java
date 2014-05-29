package cukes.dutch;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = { "@regression" },
        format = {"pretty", "html:target/cucumber-report/",
		"json:target/cucumber-report/cucumber.json" })
public class CukesRunnerTest {
}
