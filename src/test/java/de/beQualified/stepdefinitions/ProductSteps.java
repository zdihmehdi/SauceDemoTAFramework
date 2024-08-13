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
    public void remove_all_products_from_chart() {
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
    @Then("^the cart badge should show the number of chose products$")
    public void cart_badge_should_show_product_number() {
        assertEquals(productPage.getChartBadgeText(), "2", "Cart badge shows not the exact number of added products");
    }









}