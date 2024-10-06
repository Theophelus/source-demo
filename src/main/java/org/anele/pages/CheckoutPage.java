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


}
