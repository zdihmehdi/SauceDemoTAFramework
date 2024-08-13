package de.beQualified.pages;

import de.beQualified.utilities.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;

    @FindBy(css = "[data-test='inventory-item-price']")
    List<WebElement> prices;

    @FindBy(css = "[data-test='inventory-item-name']")
    List<WebElement> names;

    @FindBy(css = "[data-test='product-sort-container']")
    WebElement filterDropdownElement;

    @FindBy(css = "[data-test='shopping-cart-link']")
    WebElement shoppingCart;

    public boolean isProductPageVisible() {
        return inventoryContainer.isDisplayed();
    }

    public void chooseFilterDropDownByValue(String visibleText) {
        Select filterDropdown = new Select(filterDropdownElement);
        filterDropdown.selectByValue(visibleText);
    }

    public void chooseFilterDropDownByIndex(int index) {
        Select filterDropdown = new Select(filterDropdownElement);
        filterDropdown.selectByIndex(index);
    }

    public boolean arePricesAscending() {
        System.out.println(HelperMethods.getSortedListOfPrices(prices).get("ascending"));
        return HelperMethods.isAscendingOrder(HelperMethods.getSortedListOfPrices(prices).get("ascending"));
    }

    public boolean arePricesDescending() {
        System.out.println(HelperMethods.getSortedListOfPrices(prices).get("descending"));
        return HelperMethods.isDescendingOrder(HelperMethods.getSortedListOfPrices(prices).get("descending"));
    }

    public boolean areNamesAscending() {
        System.out.println(HelperMethods.getSortedListOfNames(names).get("ascending"));
        return HelperMethods.isAscendingOrder(HelperMethods.getSortedListOfNames(names).get("ascending"));
    }

    public boolean areNamesDescending() {
        System.out.println(HelperMethods.getSortedListOfNames(names).get("descending"));
        return HelperMethods.isDescendingOrder(HelperMethods.getSortedListOfNames(names).get("descending"));
    }

    public void clickFilterDropdown() {
        filterDropdownElement.click();
    }
}