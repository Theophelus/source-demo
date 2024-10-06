package org.anele.pages;

import org.anele.base.BaseCore;
import org.openqa.selenium.By;

public class CartPage {

    protected BaseCore baseCore;

    protected By cart_header = By.xpath("//div[@class=\"header_secondary_container\"]/span");
    protected By checkout_button = By.id("checkout");

    public CartPage() {
        this.baseCore = new BaseCore();
    }

    //verify cart header text
    public String verify_your_cart_header(String value) {

        String cart_header_text = baseCore.find(cart_header).getText();
        if (cart_header_text.equalsIgnoreCase(value))
            return cart_header_text;
        else
            throw new AssertionError("Expected header text: '" + value + "'" + " " + "but found: '" + cart_header_text + "' ");
    }

    //click check out button
    public void click_checkout_button() {
        baseCore.click(checkout_button);
    }
}
