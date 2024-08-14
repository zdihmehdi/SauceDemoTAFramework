package de.beQualified.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test='complete-header']")
    private WebElement completeHeaderWebElement;

    @FindBy(css = "[data-test='complete-text']")
    private WebElement completeTextWebElement;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    public String getCompleteHeaderText() {
        return completeHeaderWebElement.getText();
    }

    public String completeTextWebElement() {
        return completeTextWebElement.getText();
    }

    public void clickBackHomeButton() {
        backHomeButton.click();
    }
}
