package de.beQualified.pages.Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

/**
 * This class represents the item cards on the https://www.saucedemo.com/cart.html page.
 */
public class InventoryItemCart {

    /**
     * Represents the container for item cards
     */
    @FindBy(css = "[data-test='inventory-item']")
    private WebElement parentElement;

    /**
     * Represents the title of item cards
     */
    @FindBy(css = "[data-test='inventory-item'] a")
    private WebElement itemTitleElement;

    /**
     * Represents the description of item cards
     */
    @FindBy(css = "[data-test='inventory-item'] [data-test='inventory-item-desc']")
    private WebElement descriptionElement;

    /**
     * Represents the quantity of each item
     */
    @FindBy(css = "[data-test='inventory-item'] [data-test='item-quantity']")
    private WebElement productsQuantity;

    /**
     * Represents the price of each item
     */
    @FindBy(css = "[data-test='inventory-item'] [data-test='inventory-item-price']")
    private WebElement priceElement;

    /**
     * Represents remove button
     */
    @FindBy(css = "[data-test='inventory-item'] button")
    private WebElement removeButton;

    /**
     *  Represents the name of the item card
     */
    @FindBy(css = "[data-test='inventory-item'] [data-test='inventory-item-name']")
    private WebElement cartItemName;

    /**
     *  Click card remove button
     */
    public void clickRemoveButton() {
        removeButton.click();
    }

    /**
     *  Get item price
     *
     * @return double the price of the product
     */
    public double getPrice() {
        return Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
    }

    /**
     * Gets the quantity of each item in the shopping cart.
     *
     * @return int the quantity of the specified item in the shopping cart
     */
    public int getProductQuantity() {
        return Integer.parseInt(productsQuantity.getText());
    }

    /**
     * Gets th name of the item
     *
     * @return String item name
     */
    public String getCartItemName() {
        return cartItemName.getText();
    }

    public InventoryItemCart(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }
}