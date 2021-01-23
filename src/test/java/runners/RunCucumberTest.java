package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"resources/StepDefinitions"}, features ={"src/test/java/resources/feature"},
                plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"})
public class RunCucumberTest {
}
