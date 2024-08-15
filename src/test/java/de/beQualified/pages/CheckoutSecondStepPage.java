package de.beQualified.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * This page represent the https://www.saucedemo.com/checkout-step-two.html page
 */
public class CheckoutSecondStepPage {
    WebDriver driver;

    public CheckoutSecondStepPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Form container
     * */
    @FindBy(id = "checkout_summary_container")
    private WebElement formContainer;

    /**
     * Product cards
     */
    @FindBy(css = "[data-test='inventory-item']")
    private List<WebElement> cartItems;

    /**
     * Product prices
     */
    @FindBy(css = "[data-test='inventory-item-price']")
    private List<WebElement> productPrices;

    /**
     * Finish button
     */
    @FindBy(id = "finish")
    private WebElement finishButton;

    /**
     * Total price (item total)
     */
    @FindBy(css = "[data-test='subtotal-label']")
    private WebElement subTotalPrice;

    /**
     * Please call this method to click finish button
     */
    public void clickFinishButton() {
        finishButton.click();
    }

    /**
     * Verifies if the checkout second step page is visible.
     *
     * @return true is the page is visible, otherwise false
     */
    public boolean isCheckoutSecondStepVisible() {
        return formContainer.isDisplayed();
    }

    /**
     * Please call this method to get the sum of all showed items
     *
     * @return double
     */
    public double totalShowedPrice() {
        return productPrices.stream()
                .map(price -> price.getText().replaceAll("[^\\d.]", ""))
                .mapToDouble(Double::parseDouble)
                .sum();
    }

    /**
     * Please call this method to get the item total
     */
    public double getSubTotalPrice() {
        return Double.parseDouble(subTotalPrice.getText().replaceAll("[^\\d.]", ""));
    }
}