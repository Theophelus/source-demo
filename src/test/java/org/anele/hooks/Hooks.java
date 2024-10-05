package org.anele.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.anele.base.BaseCore;
import org.anele.utils.ConfigManager;

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
    public void tearDown() {
        baseCore.tearDown();
    }
}
