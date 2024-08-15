package de.beQualified.stepdefinitions;

import de.beQualified.pages.CheckoutSecondStepPage;
import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class CheckoutSecondSteps {
    WebDriver driver;
    CheckoutSecondStepPage checkoutSecondStepPage;

    public CheckoutSecondSteps() throws MalformedURLException {
        this.driver = WebDriverFactory.getDriver();
        checkoutSecondStepPage = new CheckoutSecondStepPage(driver);
    }

    @Step("The user clicks on finish button")
    @And("^the user clicks on finish button")
    public void user_clicks_continue_button() {
        checkoutSecondStepPage.clickFinishButton();
    }

    @Step("The checkout second step page is visible")
    @Then("^the checkout second step page is visible")
    public void verify_if_checkout_second_step_page_is_visible() {
        assertTrue(checkoutSecondStepPage.isCheckoutSecondStepVisible(), "Checkout second page is not visible");
    }
}