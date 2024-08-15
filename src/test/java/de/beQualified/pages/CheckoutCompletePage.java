package de.beQualified.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This page represent the https://www.saucedemo.com/checkout-complete.html page
 */
public class CheckoutCompletePage {
    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Order Completion Header Message
     */
    @FindBy(css = "[data-test='complete-header']")
    private WebElement completeHeaderWebElement;

    /**
     * Order Completion body Message
     */
    @FindBy(css = "[data-test='complete-text']")
    private WebElement completeTextWebElement;

    /**
     * Back home button
     */
    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    /**
     * This method returns the header text (if the checkout was successful, it will show Thank you for your order!)
     *
     * @return String
     */
    public String getCompleteHeaderText() {
        return completeHeaderWebElement.getText();
    }

    /**
     * This method returns the body text (Your order has been dispatched, and will arrive just as fast as the pony can get there!)
     *
     * @return String
     */
    public String completeTextWebElement() {
        return completeTextWebElement.getText();
    }

    /**
     * This method clicks back home button
     */
    public void clickBackHomeButton() {
        backHomeButton.click();
    }
}
