package de.beQualified.stepdefinitions;

import de.beQualified.pages.LoginPage;
import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    public LoginSteps() throws MalformedURLException {
        this.driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Step("The user is on the login page")
    @Given("^the user is on the login page$")
    public void is_login_page_visible() {
        driver.get("https://www.saucedemo.com/");
        assertTrue(loginPage.isLoginPageVisible());
    }

    @Step("the user enters username {0} and password secret_sauce")
    @When("^the user enters username ([^\"]*) and password secret_sauce$")
    public void enter_username_and_password(String username) {
        loginPage.enterUsername(username);
        loginPage.enterPassword("secret_sauce");
    }

    @Step("the user clicks on login button")
    @And("^the user clicks on login button$")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Step("the user is logged in successfully")
    @Then("^the user is logged in successfully$")
    public void user_is_logged() {
        assertTrue(loginPage.isProductPageVisible());
    }

    @Step("the user enters locked username locked_out_user and password secret_sauce")
    @When("^the user enters locked username locked_out_user and password secret_sauce$")
    public void enter_username_locked_out_user_and_password() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
    }

    @Step("the user is not logged in and sees an error message indicating the account is locked")
    @Then("^the user is not logged in and sees an error message indicating the account is locked$")
    public void user_is_not_logged() {
        assertEquals(loginPage.getH3ErrorText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Step("the user enters non existing accounts credentials: username {0} and password {1}")
    @When("^the user enters non existing accounts credentials: username ([^\"]*) and password ([^\"]*)$")
    public void enter_non_existing_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Step("the user is not existing in the database")
    @Then("^the user is not existing in the database$")
    public void user_is_not_signed_up() {
        assertEquals(loginPage.getH3ErrorText(), "Epic sadface: Username and password do not match any user in this service");
    }


}
