package org.anele.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.time.Duration;

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
            WEB_DRIVERS = new ThreadLocal<>();
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
}
