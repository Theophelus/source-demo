package org.anele.pages;

import com.github.javafaker.Faker;
import org.anele.base.BaseCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class CheckoutPage {
    protected BaseCore baseCore;
    protected Faker checkout_info = new Faker(Locale.ENGLISH);
    //define locators
    protected By firstname = By.id("first-name");
    protected By lastname = By.id("last-name");
    protected By zip_code = By.xpath("//input[@id='postal-code']");
    protected By continue_btn = By.id("continue");
    protected By overview = By.xpath("//span[@class='title']");
    protected By finish_btn = By.id("finish");
    protected By order_header = By.xpath("//h2[@class='complete-header']");

    public CheckoutPage() {
        this.baseCore = new BaseCore();
    }

    //fill the checkout information, using Faker library
    public void fill_checkout_info() {
        baseCore.typeRequiredValue(firstname, checkout_info.name().firstName());
        baseCore.typeRequiredValue(lastname, checkout_info.name().lastName());
        baseCore.typeRequiredValue(zip_code, checkout_info.address().zipCode());
    }

    //click on the continue button
    public void click_continue() {
        try {
            baseCore.click(continue_btn);
        } catch (Exception e) {
            throw new RuntimeException("Failed to click continue button", e.getCause());
        }
    }

    //click on finish button
    public void click_finish() {
        try {
            baseCore.click(finish_btn);
        } catch (Exception e) {
            throw new RuntimeException("Failed to click finish button", e.getCause());
        }
    }

    //verify Checkout overview text
    public String checkout_overview(String value) {
        String actualValue = baseCore.find(overview).getText();
        if (actualValue.equalsIgnoreCase(value))
            return actualValue;
        else
            throw new AssertionError("Expected header text: '" + value + "'" + " " + "but found: '" + actualValue + "' ");
    }

    public boolean verify_order_header(String value) {
        try {
            return baseCore.find(order_header).getText().equalsIgnoreCase(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get cart header text", e.getCause());
        }
    }

}
