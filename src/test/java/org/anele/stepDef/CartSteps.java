package org.anele.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.anele.base.BaseCore;
import org.anele.pages.CartPage;
import org.anele.pages.ProductsPage;
import org.testng.Assert;

public class CartSteps {
    protected BaseCore baseCore;
    protected ProductsPage productsPage;
    protected CartPage cartPage;

    public CartSteps() {
        this.baseCore = new BaseCore();
        this.productsPage = new ProductsPage();
        this.cartPage = new CartPage();
    }

    @When("^the user clicks on the cart icon$")
    public void the_user_clicks_on_the_cart_icon() {
        productsPage.click_cart_icon();
    }

    @And("^the user click on the checkout button$")
    public void theUserClickOnTheCheckoutButton() {
        cartPage.click_checkout_button();
    }

    @And("^\"([^\"]*)\" text is displayed$")
    public void yourCartTextIsDisplayed(String expected) {
        Assert.assertEquals(cartPage.verify_your_cart_header(expected), expected,
                "Expected and actual text do not match");
    }
}


