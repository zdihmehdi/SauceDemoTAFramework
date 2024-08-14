package de.beQualified.stepdefinitions;

import de.beQualified.pages.ProductPage;
import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ProductSteps {
    WebDriver driver;
    ProductPage productPage;

    public ProductSteps() throws MalformedURLException {
        this.driver = WebDriverFactory.getDriver();
        productPage = new ProductPage(driver);
    }

    @Step("The user clicks on the filter dropdown")
    @Given("^the list of products is visible$")
    public void the_list_of_products_is_visible() {
        assertTrue(productPage.isProductPageVisible(), "Product list is not visible!");
    }

    @Step("The user chooses the ascending name filter")
    @When("^the user chooses the ([^\"]*) name filter ([^\"]*)$")
    public void user_choose_a_name_filter(String meaning, String value) {
        productPage.clickFilterDropdown();
        productPage.chooseFilterDropDownByValue(value);
    }

    @Step("The user chooses the ascending price filter")
    @When("^the user chooses the ([^\"]*) price filter ([^\"]*)$")
    public void user_choose_a_price_filter(String meaning, String value) {
        productPage.clickFilterDropdown();
        productPage.chooseFilterDropDownByValue(value);
    }

    @Step("The names of the products are ordered in {0} order")
    @Then("^the names of the products are ordered in ([^\"]*) order$")
    public void names_of_the_products_are_ordered(String meaning) {
        assertTrue(meaning.equals("ascending") ? productPage.areNamesAscending() : productPage.areNamesDescending(), "Product names are not ordered as desired");
    }

    @Step("The prices of the products are ordered in {0} order")
    @Then("^the prices of the products are ordered in ([^\"]*) order$")
    public void prices_of_the_products_are_ordered(String meaning) {
        assertTrue(meaning.equals("ascending") ? productPage.arePricesAscending() : productPage.arePricesDescending(), "Product prices are not ordered as desired");
    }

    @Step("The user removes all products from the shopping cart in product page")
    @When("^the user removes all products from the shopping cart in product page$")
    public void remove_all_products_from_chart() throws MalformedURLException {
        productPage.removeAllProductFromChartFromProductPage();
    }

    @Step("Products are available")
    @And("^products are available$")
    public void products_are_available_to_be_bought() {
        assertFalse(productPage.areTheyProductsToBuy(), "No product is available to be bought");
    }

    @Step("The cart badge should not be visible")
    @Then("^the cart badge should not be visible$")
    public void cart_badge_should_not_be_visible() {
        assertFalse(productPage.isChartBadgeVisible(), "Shopping cart badge should not be visible");
    }

    @Step("The user clicks on the cart icon")
    @When("^the user clicks on the cart icon$")
    public void click_on_cart_icon() {
        productPage.clickShoppingCart();
    }

    @Step("The user adds some products to the shopping cart")
    @When("^the user adds some products to the shopping cart$")
    public void user_adds_some_products_to_shopping_card() {
        productPage.addTheIthProductToChart(0);
        productPage.addTheIthProductToChart(1);
    }

    @Step("The cart badge should be visible")
    @Then("^the cart badge should be visible$")
    public void cart_badge_should_be_visible() {
        assertTrue(productPage.isChartBadgeVisible(), "Shopping cart badge should be visible");
    }

    @Step("The cart badge should show the number of chose products")
    @And("^the cart badge should show the number of chose products$")
    public void cart_badge_should_show_product_number() {
        assertEquals(productPage.getChartBadgeText(), "2", "Cart badge shows not the exact number of added products");
    }

    @Step("The cart badge should show {0}")
    @And("^the cart badge shows ([^\"]*)$")
    public void cart_badge_should_show_the_number_of_added_items(int numberOfItems) {
        assertEquals(Integer.parseInt(productPage.getChartBadgeText()), numberOfItems, "Cart badge shows not the exact number of added products");
    }

    @Step("The cart badge shows {0} remaining products")
    @Then("^([^\"]*) remaining products are showed$")
    public void cart_badge_should_show_the_number_of_remaining_items(int numberOfRemainingItems) {
        assertEquals(Integer.parseInt(productPage.getChartBadgeText()), numberOfRemainingItems, "Cart badge do not shows the exact number of remaining items");
    }

    @Step("All add/remove buttons should have the text Add to cart")
    @And("^all add/remove buttons should have the text Add to cart$")
    public void all_add_remove_buttons_should_have_add_to_cart_text() {
        assertTrue(productPage.checkTextOfAddRemoveButton("Add to cart"), "All add/remove buttons do not have the text Add to cart");
    }

    @Step("The products: {0} are available")
    @When("^the products: ([^\"]*) are available$")
    public void add_products_to_shopping_cart(String products) {
        List<String> itemList = Arrays.asList(products.split(","));
        assertTrue(productPage.productsAreAvailable(itemList), "The products: {0} are not available".formatted(products));
    }

    @Step("the user adds {0} items to the shopping cart")
    @Then("^the user adds ([^\"]*) items to the shopping cart$")
    public void user_adds_products_to_shopping_cart(String products) {
        List<String> itemList = Arrays.asList(products.split(","));
        productPage.addProductsToShoppingCart(itemList);
    }

    @Step("The removed product/products {0} add/remove button shows Add to cart text")
    @Then("^the removed product/products ([^\"]*) add/remove button shows Add to cart text$")
    public void removed_items_show_add_to_cart_text_button(String products) {
        List<String> itemList = Arrays.asList(products.split(","));
        assertTrue(productPage.checkTextOfAddRemoveButton(itemList), "the removed product/products: {0} add/remove button do not shows Add to cart text".formatted(products));
    }
}