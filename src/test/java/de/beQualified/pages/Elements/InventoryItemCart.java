package de.beQualified.pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class InventoryItemCart {
    WebDriver driver;

    @FindBy(css = "[data-test='inventory-item']")
    private WebElement parentElement;

    @FindBy(css = "[data-test='inventory-item'] a")
    private WebElement itemTitleElement;

    @FindBy(css = "[data-test='inventory-item'] [data-test='inventory-item-desc']")
    private WebElement descriptionElement;

    @FindBy(css = "[data-test='inventory-item'] [data-test='item-quantity']")
    private WebElement productsQuantity;

    @FindBy(css = "[data-test='inventory-item'] [data-test='inventory-item-price']")
    private WebElement priceElement;

    @FindBy(css = "[data-test='inventory-item'] button")
    private WebElement removeButton;

    public void clickRemoveButton() {
        removeButton.click();
    }

    public double getPrice() {
        return Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
    }

    public int getProductQuantity() {
        return Integer.parseInt(productsQuantity.getText());
    }

    public InventoryItemCart(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }
}