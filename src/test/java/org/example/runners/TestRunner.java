package org.example.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\resources\\features",
        glue = "org/example",
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"
        },
        dryRun = false,
        tags = "@regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
