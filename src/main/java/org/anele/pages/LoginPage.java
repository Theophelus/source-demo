package org.anele.pages;

import org.anele.base.BaseCore;
import org.anele.utils.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    //define base_core object, to reuse reusable methods
    protected BaseCore baseCore;
    protected ConfigManager configManager;
    //define locator
    protected By username = By.id("user-name");
    protected By password = By.id("password");
    protected By button = By.id("login-button");
    //    protected By error_message = By.className("error-message-container error");
//    protected By error_button = By.className("error-button");
    protected By products_header_text = By.xpath("//div[@class=\"header_secondary_container\"]/span");

    //add a construct, then initialize Base Core object.
    public LoginPage() {
        baseCore = new BaseCore();
        configManager = new ConfigManager();
    }

    //login into the Source Demo login page
    public void login_credentials() {
        //get username and password from config file
        String username = configManager.getUsername();
        String password = configManager.getPassword();
        //type username and password
        baseCore.typeRequiredValue(this.username, username);
        //type username and password
        baseCore.typeRequiredValue(this.password, password);
    }

    //click on login button
    public void click_login_button(String value) {
        if (!value.isEmpty()) {
            baseCore.click(button);
        }
    }

    //verify landed successfully on products page
    public Boolean verify_products_page(String value) {
        WebElement element = baseCore.find(products_header_text);
        return element.getText().equalsIgnoreCase(value);
    }

}
