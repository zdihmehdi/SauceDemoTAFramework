package de.beQualified.pages;

import de.beQualified.pages.Elements.InventoryItemProduct;
import de.beQualified.utilities.HelperMethods;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    /**
     * Product cards container
     */
    @FindBy(css = "[data-test='inventory-list']")
    private WebElement inventoryContainer;

    /**
     * Product prices
     */
    @FindBy(css = "[data-test='inventory-item-price']")
    private List<WebElement> prices;

    /**
     * Product names
     */
    @FindBy(css = "[data-test='inventory-item-name']")
    private List<WebElement> names;

    /**
     * Filter dropdown
     */
    @FindBy(css = "[data-test='product-sort-container']")
    private WebElement filterDropdownElement;

    /**
     * Shopping cart icon
     */
    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement shoppingCart;

    /**
     * Shopping cart badge (where the number of items is shown)
     */
    @FindBy(css = "[data-test='shopping-cart-badge']")
    private WebElement shoppingCartBadge;

    /**
     * Product cards
     */
    @FindBy(css = "[data-test='inventory-item']")
    private List<WebElement> productItems;

    /**
     * Burger menu web element
     */
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    /**
     * Burger menu container web element
     */
    @FindBy(className = "bm-menu-wrap")
    private WebElement burgerMenuContainer;

    /**
     * Logout link
     */
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    /**
     * Product cards representing a list of InventoryItemProduct, with each card corresponding to an individual product.
     */
    private List<InventoryItemProduct> inventoryProducts;


    /**
     * This method verifies the visibility of the product page by checking the visibility of the cards container.
     *
     * @return boolean
     */
    public boolean isProductPageVisible() {
        return inventoryContainer.isDisplayed();
    }

    /**
     * This method selects a filter option by its visible text (e.g., "az", "za").
     *
     * @param value the visible text of the filter option to select
     */
    public void chooseFilterDropDownByValue(String value) {
        Select filterDropdown = new Select(filterDropdownElement);
        filterDropdown.selectByValue(value);
    }

    /**
     * This method selects a filter option by index.
     *
     * @param index index of the option
     */
    public void chooseFilterDropDownByIndex(int index) {
        Select filterDropdown = new Select(filterDropdownElement);
        filterDropdown.selectByIndex(index);
    }

    /**
     * Click filter dropdown
     */
    public void clickFilterDropdown() {
        filterDropdownElement.click();
    }

    /**
     * Click shopping cart
     */
    public void clickShoppingCart() {
        shoppingCart.click();
    }

    /**
     * Verify the visibility of the cart badge
     *
     * @return boolean
     */
    public boolean isChartBadgeVisible() {
        try {
            return shoppingCartBadge.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Retrieve the cart badge text.
     *
     * @return String
     */
    public String getChartBadgeText() {
        return shoppingCartBadge.getText();
    }

    /**
     * Verifies if the prices are in ascending order.
     *
     * @return true if the prices are in ascending order, false otherwise
     */
    public boolean arePricesAscending() {
        return HelperMethods.isAscendingOrder(HelperMethods.getSortedListOfPrices(prices).get("ascending"));
    }

    /**
     * Verifies if the prices are in descending order.
     *
     * @return true if the prices are in descending order, false otherwise
     */
    public boolean arePricesDescending() {
        return HelperMethods.isDescendingOrder(HelperMethods.getSortedListOfPrices(prices).get("descending"));
    }

    /**
     * Verifies if the names are in ascending order.
     *
     * @return true if the names are in ascending order, false otherwise
     */
    public boolean areNamesAscending() {
        return HelperMethods.isAscendingOrder(HelperMethods.getSortedListOfNames(names).get("ascending"));
    }

    /**
     * Verifies if the names are in descending order.
     *
     * @return true if the names are in descending order, false otherwise
     */
    public boolean areNamesDescending() {
        return HelperMethods.isDescendingOrder(HelperMethods.getSortedListOfNames(names).get("descending"));
    }

    /**
     * Verifies if at least one product is available to buy.
     *
     * @return true if there is a product available to buy, false otherwise
     */
    public boolean areTheyProductsToBuy() {
        return getInventoryProducts().isEmpty();
    }

    /**
     * Adds a product to the shopping cart using the specified index.
     *
     * @param i the index of the product in the products list
     */
    public void addTheIthProductToChart(int i) {
        getInventoryProducts().get(i).clickAddRemoveButton();
    }

    /**
     * Removes a product from the shopping cart using the specified index.
     *
     * @param i the index of the product in the products list
     */
    public void removeTheIthProductFromChart(int i) {
        getInventoryProducts().get(i).clickAddRemoveButton();
    }

    /**
     * Get Burger menu web element
     *
     * @return WebElement the burger menu web element
     */
    public WebElement getBurgerMenu() {
        return burgerMenu;
    }

    /**
     * Get logout button web element
     *
     * @return WebElement the logout button
     */
    public WebElement getLogoutButton() {
        return logoutLink;
    }

    /**
     * Click Burger menu web element
     */
    public void clickBurgerMenu() {
        burgerMenu.click();
    }

    /**
     * Click logout
     */
    public void clickLogout() {
        logoutLink.click();
    }

    /**
     * Initializes the list of product cards (InventoryItemProduct).
     */
    private void initializeInventoryProducts() {
        inventoryProducts = productItems.stream()
                .map(InventoryItemProduct::new)
                .toList();
    }

    /**
     * Initializes the list of product cards (InventoryItemProduct).
     *
     * Note: This method has been commented out because it may cause a
     * StaleElementReferenceException if the DOM is updated. The references
     * to WebElement objects need to be re-initialized to remain valid.
     */
    /*public List<InventoryItemProduct> getInventoryProducts() {
        if (inventoryProducts == null) {
            initializeInventoryProducts();
        }
        return inventoryProducts;
    }*/

    /**
     * Retrieves the list of product cards (InventoryItemProduct).
     *
     * @return List<InventoryItemProduct> A list of product cards, where each InventoryItemProduct
     * contains all the information about the product, such as price, name, and more.
     */
    public List<InventoryItemProduct> getInventoryProducts() {
        initializeInventoryProducts();
        return inventoryProducts;
    }

    /**
     * Verify if a list of products are available.
     *
     * @return true if the products are available, false otherwise
     */
    public boolean productsAreAvailable(List<String> productNames) {
        return productNames.stream().allMatch(
                productName ->
                        getInventoryProducts().stream()
                                .filter(pr -> pr.getItemName().equals(productName))
                                .allMatch(InventoryItemProduct::isProductVisible)
        );
    }

    /**
     * Adds a list of products to the shopping cart.
     *
     * @param productNames the list of product names to be added to the shopping cart
     */
    public void addProductsToShoppingCart(List<String> productNames) {

        productNames.replaceAll(String::trim);

        getInventoryProducts().stream()
                .filter(product -> productNames.contains(product.getItemName().trim()))
                .forEach(InventoryItemProduct::clickAddRemoveButton);
    }

    /**
     * Remove all products from shopping cart.
     */
    public void removeAllProductFromChartFromProductPage() {
        for (InventoryItemProduct product : getInventoryProducts()) {
            if (product.getAddRemoveButtonText().equals("Remove")) {
                product.clickAddRemoveButton();
            }
        }
    }

    /**
     * Verifies the text of the add/remove button (could be "Remove" or "Add to cart").
     *
     * @param addRemoveButtonText the expected text of the product's add/remove button
     * @return true if the product's add/remove button has the specified text, false otherwise
     */
    public boolean checkTextOfAddRemoveButton(String addRemoveButtonText) {
        for (InventoryItemProduct product : getInventoryProducts()) {
            if (!product.getAddRemoveButtonText().equals(addRemoveButtonText)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifies the text of the add/remove button for a list of products.
     *
     * @param productNames        the list of product names to check
     * @param addRemoveButtonText the expected text of each product's add/remove button
     * @return true if all products' add/remove buttons have the specified text, false otherwise
     */
    public boolean checkTextOfAddRemoveButton(List<String> productNames, String addRemoveButtonText) {
        productNames.replaceAll(String::trim);

        return getInventoryProducts().stream()
                .filter(cartItem -> productNames.contains(cartItem.getItemName().trim()))
                .allMatch(pr -> pr.getAddRemoveButtonText().equals(addRemoveButtonText));
    }

    /**
     * Verifies if burger menu is visible
     *
     * @return true if burger menu is visible, false otherwise
     */
    public boolean isBurgerMenuVisible() {
        return burgerMenuContainer.isDisplayed();
    }
}