package org.anele.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.anele.base.BaseCore;
import org.anele.utils.ConfigManager;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    protected static ConfigManager configManager;
    protected static BaseCore baseCore;

    public Hooks() {
        configManager = new ConfigManager();
        //ensure properties are loaded correctly
        configManager.loadProperties();
        baseCore = new BaseCore();
    }

    @Before
    public void setup() {
        //initialize browser
        baseCore.initBrowser("edge");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            //get method name
            String screenshotName = scenario.getName().replaceAll("\\s", "_");

            // Convert WebDriver object to TakeScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) baseCore.getDrivers();

        }
        baseCore.tearDown();
    }
}
