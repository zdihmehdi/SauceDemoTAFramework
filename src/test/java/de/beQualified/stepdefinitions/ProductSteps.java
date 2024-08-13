package de.beQualified.stepdefinitions;

import de.beQualified.pages.ProductPage;
import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

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
}