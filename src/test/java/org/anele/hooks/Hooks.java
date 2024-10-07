package org.anele.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.anele.base.BaseCore;
import org.anele.utils.ConfigManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


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
    public void tearDown(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            //get method name
            String screenshotName = scenario.getName().replaceAll("\\s", "_");

            // Convert WebDriver object to TakeScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) baseCore.getDrivers();

            File src = screenshot.getScreenshotAs(OutputType.FILE);

            // Create directory if they don't exist
            File dir = new File(System.getProperty("user.dir") + "/screenshot/");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File destination = new File(dir, screenshotName + ".png");

            try {
                FileUtils.copyFile(src, destination);
                System.out.println("Screenshot taken: " + destination.getAbsolutePath());
            } catch (IOException e) {
                throw new IOException("Failed to take a screenshot: " + e.getMessage());
            }
        }
        baseCore.tearDown();
    }
}
