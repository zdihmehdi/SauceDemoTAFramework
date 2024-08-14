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

    @FindBy(css = "[data-test='inventory-item']")
    private List<WebElement> cartItems;

    @FindBy(css = "[data-test='inventory-item-price']")
    private List<WebElement> productPrices;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(css = "[data-test='subtotal-label']")
    private WebElement subTotalPrice;

    /**
     * Please call this method to click finish button
     */
    public void clickFinishButton() {
        finishButton.click();
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