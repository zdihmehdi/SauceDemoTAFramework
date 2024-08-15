package de.beQualified.stepdefinitions;

import de.beQualified.pages.CheckoutSecondStepPage;
import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

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
}