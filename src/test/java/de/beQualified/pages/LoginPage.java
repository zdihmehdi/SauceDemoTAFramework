package de.beQualified.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(id = "login_button_container")
    WebElement loginElementsContainer;

    @FindBy(id = "contents_wrapper")
    WebElement contentsWrapper;

    @FindBy(css = "[data-test='error']")
    WebElement errorH3;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isLoginPageVisible() {
        return loginElementsContainer.isDisplayed();
    }

    public boolean isAfterLoginPageVisible() {
        return contentsWrapper.isDisplayed();
    }

    public String getH3ErrorText() {
        return errorH3.getText();
    }

    public void acceptChangingPassword() {
        driver.switchTo().alert().accept();
    }
}
