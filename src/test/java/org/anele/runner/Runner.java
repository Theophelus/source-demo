package org.anele.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.anele.stepDef", "org.anele.hooks"}
)
public class Runner extends AbstractTestNGCucumberTests {

}
