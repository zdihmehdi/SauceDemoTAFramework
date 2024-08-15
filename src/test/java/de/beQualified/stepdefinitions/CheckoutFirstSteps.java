package de.beQualified.stepdefinitions;

import de.beQualified.pages.CheckoutFirstStepPage;
import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class CheckoutFirstSteps {
    WebDriver driver;
    CheckoutFirstStepPage checkoutFirstStepPage;

    public CheckoutFirstSteps() throws MalformedURLException {
        this.driver = WebDriverFactory.getDriver();
        checkoutFirstStepPage = new CheckoutFirstStepPage(driver);
    }

    @Step("The user enters his firstname {0}, lastname {1}, and zip code {2}")
    @And("^the user enters his firstname ([^\"]*), lastname ([^\"]*), and zip code ([^\"]*)$")
    public void enter_user_firstname_lastname_and_zipcode(String firstname, String lastname, String zipCode) {
        checkoutFirstStepPage.enterFirstname(firstname);
        checkoutFirstStepPage.enterLastname(lastname);
        checkoutFirstStepPage.enterPostalCode(zipCode);
    }

    @Step("The user clicks on continue button")
    @And("^the user clicks on continue button$")
    public void user_clicks_continue_button() {
        checkoutFirstStepPage.clickContinueButton();
    }
}