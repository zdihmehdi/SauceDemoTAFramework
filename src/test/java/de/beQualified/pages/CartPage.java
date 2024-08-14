package de.beQualified.pages;

import de.beQualified.pages.Elements.InventoryItemCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

/**
 * This page represent the https://www.saucedemo.com/cart.html page
 */
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

    /**
     * This method checks if the page is visible, by checking
     * if the container is displayed
     *
     * @return boolean
     */
    public boolean isCartPageVisible() {
        return cartContentsContainer.isDisplayed();
    }

    /**
     * This method checks if the button checkout is enabled.
     * Checkout button should be enabled if the cart is not empty
     *
     * @return boolean
     */
    public boolean isCheckoutButtonEnabled() {
        return checkoutButton.isEnabled();
    }

    /**
     * This method is used to click checkout button
     */
    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    /**
     * This method is used to click shopping button
     */
    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    /**
     * This method removes all the products from the shopping cart.
     * This means that the cart badge will not be visible anymore
     */
    public void removeAllProductFromCartPage() {
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

    /**
     * This method is used to initialise the inventoryItemCarts
     */
    private void initializeInventoryProducts() {
        inventoryItemCarts = cartItems.stream()
                .map(InventoryItemCart::new)
                .toList();
    }

    /**
     * This method returns the list of InventoryItemCart
     * which they present the UI component of each item
     *
     * @return List<InventoryItemCart>
     */
    public List<InventoryItemCart> getInventoryItemCarts() {
        if (inventoryItemCarts == null) {
            initializeInventoryProducts();
        }
        return inventoryItemCarts;
    }

    /**
     * This method checks if a product/products are visible the list of InventoryItemCart
     *
     * @param productNames A comma-separated string of product names to be checked for visibility
     * @return boolean
     */
    public boolean isItemVisible(String productNames) {
        List<String> productList = Arrays.asList(productNames.split(","));
        productList.replaceAll(String::trim);
        return getInventoryItemCarts().stream()
                .allMatch(cartItem -> productList.contains(cartItem.getCartItemName().trim()));
    }

    /**
     * This method removes a product/products from the shopping cart
     *
     * @param productNames A comma-separated string of product names to be removed from shopping cart
     */
    public void removeProductsFromShoppingCart(String productNames) {
        List<String> productList = Arrays.asList(productNames.split(","));
        productList.replaceAll(String::trim);

        getInventoryItemCarts().stream()
                .filter(cartItem -> productList.contains(cartItem.getCartItemName().trim()))
                .forEach(InventoryItemCart::clickRemoveButton);
    }
}