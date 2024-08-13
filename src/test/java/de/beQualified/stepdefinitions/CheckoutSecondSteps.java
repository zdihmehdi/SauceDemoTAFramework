package de.beQualified.stepdefinitions;

import de.beQualified.pages.CheckoutFirstStepPage;
import de.beQualified.pages.CheckoutSecondStepPage;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;

public class CheckoutSecondSteps {
    CheckoutSecondStepPage checkoutSecondStepPage;

    @Step("The user clicks on finish button")
    @And("^the user clicks on finish button")
    public void user_clicks_continue_button() {
        checkoutSecondStepPage.clickFinishButton();
    }
}