package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-report/cucumber.json",
		"html:target/cucumber-report/cucumber.html" }, features = {
				"src/test/resources/features/" }, glue = { "com.amazon.steps" })
public class TestRunner {
}