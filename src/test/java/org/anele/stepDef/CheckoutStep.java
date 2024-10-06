package org.anele.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.anele.base.BaseCore;
import org.anele.pages.CheckoutPage;
import org.testng.Assert;

public class CheckoutStep {

    protected BaseCore baseCore;
    protected CheckoutPage checkoutPage;

    public CheckoutStep() {
        this.baseCore = new BaseCore();
        this.checkoutPage = new CheckoutPage();
    }

    @And("^the user fills in the Checkout information form$")
    public void theUserFillsInCheckoutInformationForm() {
        checkoutPage.fill_checkout_info();
    }

    @And("^the user clicks on the Continue button from checkout page$")
    public void theUserClicksOnTheContinueButtonFromCheckoutPage() {
        checkoutPage.click_continue();
    }

//    @Then("^\"([^\"]*)\" text is displayed$")
//    public void checkoutOverviewTextIsDisplayed(String expectedValue) {
//        Assert.assertEquals(checkoutPage.checkout_overview(expectedValue),
//                expectedValue, "Expected and actual text do not match");
//    }

    @And("^the user clicks on the Finish button$")
    public void theUserClicksOnTheFinishButton() {
        checkoutPage.click_finish();
    }


    @Then("^\"([^\"]*)\" message is displayed$")
    public void thankYouForYourOrderMessageIsDisplayed(String expectedValue) {
        Assert.assertTrue(checkoutPage.verify_order_header(expectedValue), "Thank you for your order! message is not displayed");
    }
}
