package de.beQualified.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This page represent the https://www.saucedemo.com/ page
 */
public class LoginPage {
    WebDriver driver;

    /**
     * Username text input
     */
    @FindBy(id = "user-name")
    private WebElement usernameField;

    /**
     * Password text input
     */
    @FindBy(id = "password")
    private WebElement passwordField;

    /**
     * Login button
     */
    @FindBy(id = "login-button")
    private WebElement loginButton;

    /**
     * Form container
     */
    @FindBy(id = "login_button_container")
    private WebElement loginElementsContainer;

    /**
     * The container element that holds the content of the product page
     */
    @FindBy(id = "contents_wrapper")
    private WebElement contentsWrapper;

    /**
     * Error message container
     */
    @FindBy(css = "[data-test='error']")
    private WebElement errorH3;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Please call this method to write the login
     */
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    /**
     * Please call this method to write the password
     */
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    /**
     * Please call this method to click login button
     */
    public void clickLoginButton() {
        loginButton.click();
    }

    /**
     * This method verify if the login page is visible, by verifying if the
     * login UI container is visible
     *
     * @return boolean
     */
    public boolean isLoginPageVisible() {
        return loginElementsContainer.isDisplayed();
    }

    /**
     * This method verify if the product page is visible, by verifying if the
     * UI container is visible
     *
     * @return boolean
     */
    public boolean isProductPageVisible() {
        return contentsWrapper.isDisplayed();
    }

    /**
     * This method returns the login error message
     *
     * @return String
     */
    public String getH3ErrorText() {
        return errorH3.getText();
    }

    /**
     * This method could be used in Chrome browser to accept changing password popup
     */
    public void acceptChangingPassword() {
        driver.switchTo().alert().accept();
    }
}
