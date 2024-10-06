package org.anele.pages;

import org.anele.base.BaseCore;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    protected BaseCore baseCore;
    protected By product_name = By.xpath("//div[@class=\"inventory_item_name \"]");
    protected By cart_index = By.xpath("//span[@class=\"shopping_cart_badge\"]");
    protected By add_to_cart_icon = By.xpath("//div[@id=\"shopping_cart_container\"]");

    public ProductsPage() {
        this.baseCore = new BaseCore();
    }

    public void add_items_to_cart(String item) {
        List<WebElement> elementList = baseCore.finds(product_name);
        boolean isFound = false;

        //if product list and item list are empty, throw an exception
        if (elementList.isEmpty()) {
            throw new NoSuchElementException("Provided lists are empty");
        }

        //loop through the list of products
        for (WebElement element : elementList) {

            //check if current product matches provided item
            if (element.getText().equalsIgnoreCase(item)) {
                System.out.println("Found");


            }
            //if provided item is not found, fail the test
            if (!isFound) throw new NoSuchElementException("Provided items not found in the product list");
        }


    }

}
