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

                //add to cart button to be clicked
                WebElement add_to_cart_button = baseCore.find(By.xpath("//button[contains(text(),'Add to cart')]"));
                //click add to cart button
                add_to_cart_button.click();

                //get cart size after adding the item
                WebElement cart_size = baseCore.find(cart_index);
                int cart_length = Integer.parseInt(cart_size.getText());
                System.out.println("Cart size: " + cart_length);

                //if the cart has 2 0r more items click cart icon and break the loop
                if (cart_length >= 2) {
                    //cart icon
                    WebElement click_cart_icon = baseCore.find(add_to_cart_icon);
                    click_cart_icon.click();
                    isFound = true;
                    break;
                }


            }
            //if provided item is not found, fail the test
            if (!isFound) throw new NoSuchElementException("Provided items not found in the product list");
        }


    }

}
