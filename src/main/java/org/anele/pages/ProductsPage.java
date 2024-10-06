package org.anele.pages;

import org.anele.base.BaseCore;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    protected BaseCore baseCore;
    protected By product_list = By.xpath(".//following-sibling::div//div[@class=\"inventory_item_name \"]");
    protected By cart_index = By.xpath("//span[@class=\"shopping_cart_badge\"]");
//    protected By add_to_cart_icon = By.xpath("//div[@id=\"shopping_cart_container\"]");

    public ProductsPage() {
        this.baseCore = new BaseCore();
    }

    public void add_items_to_cart(String item) {
        List<WebElement> elementList = baseCore.finds(product_list);
        boolean isFound = false;
        int index = 0;

        //if product list and item list are empty, throw an exception
        if (elementList.isEmpty()) {
            throw new NoSuchElementException("Provided lists are empty");
        }

        //loop through the list of products
        for (WebElement element : elementList) {
            index++;
            //check if current product matches provided item
            if (element.getText().equalsIgnoreCase(item)) {
                System.out.println("Item found: " + element.getText());
                //add to cart button to be clicked
                WebElement add_to_cart_button =
                        baseCore.find(By.xpath(".//following-sibling::div//button[contains(text(),'Add to cart')]['" + index + "']"));

                add_to_cart_button.click();

                //get cart size after adding the item
                WebElement cart_size = baseCore.find(cart_index);
                int cart_length = Integer.parseInt(cart_size.getText());
                System.out.println("Cart size: " + cart_length);

                //if the cart has 2 0r more items click cart icon and break the loop
                if (cart_length == 2) {
                    break;
                }
            }
        }
    }

    //track cart size
    public int cart_count() {
        String text = baseCore.find(cart_index).getText();
        return Integer.parseInt(text);
    }

}
