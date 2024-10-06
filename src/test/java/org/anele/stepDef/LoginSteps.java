package org.anele.stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.anele.base.BaseCore;
import org.anele.pages.LoginPage;
import org.anele.pages.ProductsPage;
import org.anele.utils.ConfigManager;
import org.testng.Assert;

import java.util.List;

public class LoginSteps {
    //define objects to be used
    LoginPage loginPage;
    BaseCore baseCore;
    ConfigManager configManager;

    ProductsPage productsPage;

    public LoginSteps() {
        this.baseCore = new BaseCore();
        this.configManager = new ConfigManager();
        this.configManager.loadProperties(); // Ensure properties are loaded
        this.loginPage = new LoginPage();
        this.productsPage = new ProductsPage();
    }


    @Given("^the user lands on Sauce Demo Landing page$")
    public void the_user_lands_on_source_demo_landing_page() {
        //navigate into the Sauce Demo Page
        String base_url = configManager.getBaseUrl();
        baseCore.getDrivers().get(base_url);
    }

    @When("^the user enter valid credentials$")
    public void the_user_enter_valid_credentials() {
        //type login credentials
        loginPage.login_credentials();
    }

    @When("^the user clicks on the \"([^\"]*)\" button$")
    public void the_user_clicks_on_the_button(String login_button) {
        //click on the login button
        loginPage.click_login_button(login_button);
    }

    @Then("^the user is logged in and \"([^\"]*)\" page is displayed$")
    public void the_user_is_logged_in_and_page_is_displayed(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean products_header_text = loginPage.verify_products_page(value);
        Assert.assertTrue(products_header_text, "Provided product text do not match");
    }

    @When("^the user enter invalid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserEnterInvalidCredentialsAnd(String username, String password) {
        loginPage.provide_login_credentials(username, password);
    }

    @Then("^the error message \"([^\"]*)\" is displayed$")
    public void theErrorMessageIsDisplayed(String error_message) {
        String actual_error_message = loginPage.verify_error_messages();
        Assert.assertEquals(actual_error_message, error_message, "Provided values do not match");
    }

}
