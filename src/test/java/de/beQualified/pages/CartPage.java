package de.beQualified.pages;

import de.beQualified.pages.Elements.InventoryItemCart;
import de.beQualified.pages.Elements.InventoryItemProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CartPage {

    WebDriver driver;

    @FindBy(id = "cart_contents_container")
    private WebElement cartContentsContainer;

    @FindBy(css = "[data-test='inventory-item']")
    private List<WebElement> cartItems;

    private List<InventoryItemCart> inventoryItemCarts;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    public boolean isCartPageVisible() {
        return cartContentsContainer.isDisplayed();
    }

    public boolean isCheckoutButtonEnabled() {
        return checkoutButton.isEnabled();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void removeAllProductFromChartPage() {
        for (InventoryItemCart cartItem : getInventoryItemCarts()) {
            if (!cartItems.isEmpty()) {
                cartItem.clickRemoveButton();
            }
        }
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void initializeInventoryProducts() {
        inventoryItemCarts = cartItems.stream()
                .map(InventoryItemCart::new)
                .toList();
    }

    public List<InventoryItemCart> getInventoryItemCarts() {
        if (inventoryItemCarts == null) {
            initializeInventoryProducts();
        }
        return inventoryItemCarts;
    }

    public boolean isItemVisible(String productNames) {
        List<String> productList = Arrays.asList(productNames.split(","));
        productList.replaceAll(String::trim);
        return getInventoryItemCarts().stream()
                .allMatch(cartItem -> productList.contains(cartItem.getCartItemName().trim()));
    }

    public void removeProductsFromShoppingCart(String productName) {
        List<String> productList = Arrays.asList(productName.split(","));
        productList.replaceAll(String::trim);

        getInventoryItemCarts().stream()
                .filter(cartItem -> productList.contains(cartItem.getCartItemName().trim()))
                .forEach(InventoryItemCart::clickRemoveButton);
    }
}
