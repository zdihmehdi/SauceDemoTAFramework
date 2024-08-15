package de.beQualified.pages.Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

/**
 * This class represents the item cards on the https://www.saucedemo.com/inventory.html page.
 */
public class InventoryItemProduct {

    /**
     * Represents the container of each product
     */
    @FindBy(css = "[data-test='inventory-list']")
    private WebElement parentElement;

    /**
     * Represents the description of product cards
     */
    @FindBy(css = "[data-test='inventory-list'] [data-test='inventory-item-desc']")
    private WebElement descriptionElement;

    /**
     * Represents the price of the product
     */
    @FindBy(css = "[data-test='inventory-list'] [data-test='inventory-item-price']")
    private WebElement priceElement;

    /**
     * Represents the remove button in a product card
     */
    @FindBy(css = "[data-test='inventory-list'] button")
    private WebElement addRemoveButton;

    /**
     * Represents the name if the product
     */
    @FindBy(css = "[data-test='inventory-list'] [data-test='inventory-item-name']")
    private WebElement itemName;

    /**
     * click add/remove button
     */
    public void clickAddRemoveButton() {
        addRemoveButton.click();
    }

    /**
     * Get product price
     *
     * @return double the product price
     */
    public double getPrice() {
        return Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
    }

    /**
     * Get add/remove button text
     *
     * @return String the text of add/remove button
     */
    public String getAddRemoveButtonText() {
        return addRemoveButton.getText();
    }

    /**
     * Get add/remove button web element
     *
     * @return WebElement the button web element
     */
    public WebElement getAddRemoveButton() {
        return addRemoveButton;
    }

    /**
     * Verifies if the product is available by checking the visibility of its name WebElement.
     *
     * @return true if the product name is visible, false otherwise
     */
    public boolean isProductVisible() {
        return getItemNameWebElement().isDisplayed();
    }

    /**
     * Get product name web element
     *
     * @return WebElement product name web element
     */
    public WebElement getItemNameWebElement() {
        return itemName;
    }

    /**
     * Get product name
     *
     * @return String product name
     */
    public String getItemName() {
        return itemName.getText();
    }

    public InventoryItemProduct(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }
}
