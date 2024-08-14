package de.beQualified.pages;

import de.beQualified.pages.Elements.InventoryItemProduct;
import de.beQualified.utilities.HelperMethods;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

/**
 * This page represent the https://www.saucedemo.com/inventory.html page
 */
public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;

    @FindBy(css = "[data-test='inventory-item-price']")
    private List<WebElement> prices;

    @FindBy(css = "[data-test='inventory-item-name']")
    private List<WebElement> names;

    @FindBy(css = "[data-test='product-sort-container']")
    private WebElement filterDropdownElement;

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement shoppingCart;

    @FindBy(css = "[data-test='shopping-cart-badge']")
    private WebElement shoppingCartBadge;

    @FindBy(css = "[data-test='inventory-item']")
    private List<WebElement> productItems;

    private List<InventoryItemProduct> inventoryProducts;

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

    public void clickFilterDropdown() {
        filterDropdownElement.click();
    }

    public void clickShoppingCart() {
        shoppingCart.click();
    }

    public boolean isChartBadgeVisible() {
        try {
            return shoppingCartBadge.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getChartBadgeText() {
        return shoppingCartBadge.getText();
    }

    public boolean arePricesAscending() {
        return HelperMethods.isAscendingOrder(HelperMethods.getSortedListOfPrices(prices).get("ascending"));
    }

    public boolean arePricesDescending() {
        return HelperMethods.isDescendingOrder(HelperMethods.getSortedListOfPrices(prices).get("descending"));
    }

    public boolean areNamesAscending() {
        return HelperMethods.isAscendingOrder(HelperMethods.getSortedListOfNames(names).get("ascending"));
    }

    public boolean areNamesDescending() {
        return HelperMethods.isDescendingOrder(HelperMethods.getSortedListOfNames(names).get("descending"));
    }

    public boolean areTheyProductsToBuy() {
        return getInventoryProducts().isEmpty();
    }

    public void addTheIthProductToChart(int i) {
        getInventoryProducts().get(i).clickAddRemoveButton();
    }

    public void removeTheIthProductFromChart(int i) {
        getInventoryProducts().get(i).clickAddRemoveButton();
    }

    private void initializeInventoryProducts() {
        inventoryProducts = productItems.stream()
                .map(InventoryItemProduct::new)
                .toList();
    }

    // This will cause a stale element exception (because the reference of this object should be also actualised) if the dom is actualised, that s why i commented this method
    /*public List<InventoryItemProduct> getInventoryProducts() {
        if (inventoryProducts == null) {
            initializeInventoryProducts();
        }
        return inventoryProducts;
    }*/

    public List<InventoryItemProduct> getInventoryProducts() {
        initializeInventoryProducts();
        return inventoryProducts;
    }

    public boolean productsAreAvailable(List<String> productNames) {
        return productNames.stream().allMatch(
                productName ->
                        getInventoryProducts().stream()
                                .filter(pr -> pr.getItemName().equals(productName))
                                .allMatch(InventoryItemProduct::isProductVisible)
        );
    }

    public void addProductsToShoppingCart(List<String> productNames) {

        productNames.replaceAll(String::trim);

        getInventoryProducts().stream()
                .filter(product -> productNames.contains(product.getItemName().trim()))
                .forEach(InventoryItemProduct::clickAddRemoveButton);
    }

    public void removeAllProductFromChartFromProductPage() {
        for (InventoryItemProduct product : getInventoryProducts()) {
            if (product.getAddRemoveButtonTitle().equals("Remove")) {
                product.clickAddRemoveButton();
            }
        }
    }

    public boolean checkTextOfAddRemoveButton(String addRemoveButtonText) {
        for (InventoryItemProduct product : getInventoryProducts()) {
            if (!product.getAddRemoveButtonTitle().equals(addRemoveButtonText)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkTextOfAddRemoveButton(List<String> productNames) {

        productNames.replaceAll(String::trim);

        return getInventoryProducts().stream()
                .filter(cartItem -> productNames.contains(cartItem.getItemName().trim()))
                .allMatch(pr -> pr.getAddRemoveButtonTitle().equals("Add to cart"));
    }
}