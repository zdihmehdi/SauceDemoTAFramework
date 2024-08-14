package de.beQualified.pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.net.MalformedURLException;
import java.util.List;

import static de.beQualified.utilities.WebDriverFactory.waitForCondition;

public class InventoryItemProduct {

    @FindBy(css = "[data-test='inventory-list']")
    private WebElement parentElement;

    @FindBy(css = "[data-test='inventory-list'] [data-test='inventory-item-desc']")
    private WebElement descriptionElement;

    @FindBy(css = "[data-test='inventory-list'] [data-test='inventory-item-price']")
    private WebElement priceElement;

    @FindBy(css = "[data-test='inventory-list'] button")
    private WebElement addRemoveButton;

    @FindBy(css = "[data-test='inventory-list'] [data-test='inventory-item-name']")
    private WebElement itemName;

    public void clickAddRemoveButton() {
        addRemoveButton.click();
    }

    public double getPrice() {
        return Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", ""));
    }

    public boolean checkAddRemoveButtonTitle(String title) {
        return addRemoveButton.getText().equals(title);
    }

    public String getAddRemoveButtonTitle() {
        return addRemoveButton.getText();
    }

    public WebElement getAddRemoveButton() {
        return addRemoveButton;
    }

    public boolean isProductVisible() {
        return getItemNameWebElement().isDisplayed();
    }

    public WebElement getItemNameWebElement() {
        return itemName;
    }

    public String getItemName() {
        return itemName.getText();
    }

    public InventoryItemProduct(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }
}
