package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
                glue ={"stepDefinitions"},
                tags = "@regression",
                monochrome = true,
                dryRun = false,
                plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
        //komentar
)
public class MainRuner extends AbstractTestNGCucumberTests {
}
