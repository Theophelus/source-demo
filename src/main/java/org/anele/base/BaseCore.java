package org.anele.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseCore {
    //define a Thread safe WebDrivers, to be able to use single thread of webDrivers a time
    protected static ThreadLocal<WebDriver> WEB_DRIVERS = new ThreadLocal<>();

    //get web drivers current instance
    public WebDriver getDrivers() {
        return WEB_DRIVERS.get();
    }

    public void initBrowser(String browser) {

        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
        } else {
            throw new RuntimeException("Provided browser not supported: " + browser);
        }
        //set a thread guard to ensure each thread is used.
        WEB_DRIVERS.set(ThreadGuard.protect(new EdgeDriver()));

        //configure drivers
        getDrivers().manage().window().maximize();
        getDrivers().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    //clean up webDriver resources
    public void tearDown() {
        if (getDrivers() != null) {
            getDrivers().quit();
            WEB_DRIVERS.remove();//remove driver thread instance after each run
        }
    }


    //findElement single element
    public WebElement find(By locator) {
        return getDrivers().findElement(locator);
    }

    //findElements multiple elements
    public List<WebElement> finds(By locator) {
        return getDrivers().findElements(locator);
    }

    //method to typeValues into text_boxes
    public void typeRequiredValue(By locator, String value) {
        WebElement element = find(locator);
        String attribute = element.getAttribute("value");

        try {
            //check if element is not empty
            if (!attribute.isEmpty()) {
                element.sendKeys(Keys.CONTROL, "a");
                element.sendKeys(Keys.BACK_SPACE);
            }
            // if empty type provided value
            element.sendKeys(value);
        } catch (Exception e) {
            System.out.println("Provided element not found: " + element.getText() + " " + e.getMessage());
        }
    }
}
