package de.beQualified.stepdefinitions;

import de.beQualified.pages.CheckoutCompletePage;
import de.beQualified.pages.CheckoutFirstStepPage;
import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class CheckoutCompleteSteps {

    WebDriver driver;
    CheckoutCompletePage checkoutCompletePage;

    public CheckoutCompleteSteps() throws MalformedURLException {
        this.driver = WebDriverFactory.getDriver();
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Step("The order should be successfully placed")
    @Then("^the order should be successfully placed$")
    public void successfully_placed_order_text() {
        assertTrue(checkoutCompletePage.completeTextWebElement().contains("Your order has been dispatched"), "An issue occurred, and the order could not be dispatched");
    }

    @Step("The user clicks the back home button")
    @When("^the user clicks the back home button$")
    public void click_back_button() {
        checkoutCompletePage.clickBackHomeButton();
    }
}