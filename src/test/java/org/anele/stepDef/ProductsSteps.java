package org.anele.stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.anele.base.BaseCore;
import org.anele.pages.ProductsPage;
import org.anele.utils.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductsSteps {

    ProductsPage productsPage;
    BaseCore baseCore;
    ConfigManager configManager;

    public ProductsSteps() {
        this.productsPage = new ProductsPage();
        this.baseCore = new BaseCore();
        this.configManager = new ConfigManager();
        this.configManager.loadProperties(); // Ensure properties are loaded
    }

    @And("^the user adds these two items to the cart:$")
    public void theUserTheUserAddsTheseTwoItemsToTheCart(DataTable dataTable) {
        List<String> list_of_items = dataTable.asList();

        for (String elements : list_of_items) {
            productsPage.add_items_to_cart(elements);
            // Wait for the cart to update after each item is added
//            WebDriverWait wait = new WebDriverWait(baseCore.getDrivers(), Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".shopping_cart_badge"), String.valueOf(elements.indexOf(elements) + 1)));
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Then("^the the cart icon should have two items$")
    public void theTheCartIconShouldHaveTwoItems() {
        int cart_counter = productsPage.cart_count();
        Assert.assertTrue(cart_counter >= 2, "Count size is not greater than or equals 2");

    }
}
