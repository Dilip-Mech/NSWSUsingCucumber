package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
glue = "com.dilip.step_definition",
dryRun = false,
monochrome = false,
plugin = {"rerun:target/failed_scenario.txt","html:target/cucumber-reports/report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class TestRunner {
	
	
}
