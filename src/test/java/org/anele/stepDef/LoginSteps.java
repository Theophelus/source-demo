package org.anele.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.anele.base.BaseCore;
import org.anele.pages.LoginPage;
import org.anele.utils.ConfigManager;
import org.testng.Assert;

public class LoginSteps {
    //define objects to be used
    LoginPage loginPage;
    BaseCore baseCore;
    ConfigManager configManager;

    public LoginSteps() {
        this.baseCore = new BaseCore();
        this.configManager = new ConfigManager();
        this.configManager.loadProperties(); // Ensure properties are loaded
        this.loginPage = new LoginPage();
    }



}
