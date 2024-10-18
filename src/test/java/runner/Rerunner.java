package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed_scenario.txt",
glue = "com.dilip.step_definition",
dryRun = false

)
public class Rerunner {

}
