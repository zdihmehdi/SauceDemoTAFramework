package de.beQualified.pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class InventoryItemProduct {
    WebDriver driver;

    @FindBy(css = "[data-test='inventory-list']")
    private WebElement parentElement;

    @FindBy(css = "[data-test='inventory-list'] a")
    private WebElement itemTitleElement;

    @FindBy(css = "[data-test='inventory-list'] [data-test='inventory-item-desc']")
    private WebElement descriptionElement;

    @FindBy(css = "[data-test='inventory-list'] [data-test='inventory-item-price']")
    private WebElement priceElement;

    @FindBy(css = "[data-test='inventory-list'] button")
    private WebElement addRemoveButton;

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

    public InventoryItemProduct(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }
}
