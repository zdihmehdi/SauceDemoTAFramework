package de.beQualified.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    public void enterFirstname(String firstname) {
        firstnameWebElement.sendKeys(firstname);
    }

    public void enterLastname(String lastname) {
        lastnameWebElement.sendKeys(lastname);
    }

    public void enterPostalCode(String zipCode) {
        postalCodeWebElement.sendKeys(zipCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
