package de.beQualified.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This page represent the https://www.saucedemo.com/checkout-step-one.html page
 */
public class CheckoutFirstStepPage {
    WebDriver driver;

    public CheckoutFirstStepPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout_info_container")
    private WebElement checkoutContainer;

    @FindBy(id = "first-name")
    private WebElement firstnameWebElement;

    @FindBy(id = "last-name")
    private WebElement lastnameWebElement;

    @FindBy(id = "postal-code")
    private WebElement postalCodeWebElement;

    @FindBy(id = "continue")
    private WebElement continueButton;

    /**
     * Please call this method to write the firstname
     */
    public void enterFirstname(String firstname) {
        firstnameWebElement.sendKeys(firstname);
    }

    /**
     * Please call this method to write the lastname
     */
    public void enterLastname(String lastname) {
        lastnameWebElement.sendKeys(lastname);
    }

    /**
     * Please call this method to write the postal code
     */
    public void enterPostalCode(String zipCode) {
        postalCodeWebElement.sendKeys(zipCode);
    }

    /**
     * Please call this method to click continue button
     */
    public void clickContinueButton() {
        continueButton.click();
    }
}