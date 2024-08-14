package de.beQualified.stepdefinitions;

import de.beQualified.pages.CartPage;
import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CartSteps {
    WebDriver driver;

    CartPage cartPage;

    @Step("The user removes all products from the shopping cart")
    @When("^the user removes all products from the shopping cart$")
    public void user_removes_all_products_from_cart_page() {
        cartPage.removeAllProductFromCartPage();
    }

    @Step("The checkout page should be visible")
    @Then("^the checkout page should be visible$")
    public void checkout_page_should_be_visible() {
        assertTrue(cartPage.isCartPageVisible(), "Checkout page is not visible");
    }

    @Step("Shopping cart is empty")
    @And("^shopping cart is empty$")
    public void shopping_card_is_empty() {
        assertTrue(cartPage.getInventoryItemCarts().isEmpty(), "Shopping cart contains no item");
    }

    @Step("The checkout button should be disabled")
    @And("^the checkout button should be disabled$")
    public void checkout_button_should_be_disabled() {
        assertFalse(cartPage.isCheckoutButtonEnabled(), "Checkout button should be disabled");
    }

    @Step("The checkout button should be enabled")
    @And("^the checkout button should be enabled$")
    public void checkout_button_should_be_enabled() {
        assertTrue(cartPage.isCheckoutButtonEnabled(), "Checkout button should be enabled");
    }

    @Step("The user click continue button")
    @And("^the user click continue button$")
    public void click_continue_button() {
        cartPage.clickCheckoutButton();
    }

    public CartSteps() throws MalformedURLException {
        this.driver = WebDriverFactory.getDriver();
        cartPage = new CartPage(driver);
    }

    @Step("The user delete {0} product from checkout page")
    @When("^the user delete ([^\"]*) product from checkout page$")
    public void user_delete_items_from_shopping_cart(String product) {
        cartPage.removeProductsFromShoppingCart(product);
    }

    @Step("The {0} product disappear from cart page")
    @And("^the ([^\"]*) product disappear from cart page$")
    public void products_disappear_from_shopping_cart(String products) {
        assertFalse(cartPage.isItemVisible(products), "The removed products still visible in shopping cart list");
    }

    @Step("The user clicks continue shopping")
    @When("^the user clicks continue shopping$")
    public void user_clicks_continue_button() {
        cartPage.clickContinueShoppingButton();
    }
}