package org.anele.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.anele.stepDef", "org.anele.hooks"},
        tags = "not @wip",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

}
