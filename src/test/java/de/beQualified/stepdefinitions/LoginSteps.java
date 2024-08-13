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

    @Step("User is on login page")
    @Given("^User is on login page$")
    public void is_login_page_visible() {
        driver.get("https://www.saucedemo.com/");
        assertTrue(loginPage.isLoginPageVisible());
    }

    @Step("User enters username {0} and password secret_sauce")
    @When("^User enters username ([^\"]*) and password secret_sauce$")
    public void enter_username_and_password(String username) {
        loginPage.enterUsername(username);
        loginPage.enterPassword("secret_sauce");
    }

    @Step("User clicks on login button")
    @And("^User clicks on login button$")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Step("User is logged")
    @Then("^User is logged$")
    public void user_is_logged() {
        assertTrue(loginPage.isAfterLoginPageVisible());
    }

    @Step("User enters locked username locked_out_user and password secret_sauce")
    @When("^User enters locked username locked_out_user and password secret_sauce$")
    public void enter_username_locked_out_user_and_password() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
    }

    @Step("User is not logged")
    @Then("^User is not logged$")
    public void user_is_not_logged() {
        assertEquals(loginPage.getH3ErrorText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Step("User enters non existing accounts credentials: username {0} and password {1}")
    @When("^User enters non existing accounts credentials: username ([^\"]*) and password ([^\"]*)$")
    public void enter_non_existing_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Step("User is not existing in the database")
    @Then("^User is not existing in the database$")
    public void user_is_not_signed_up() {
        assertEquals(loginPage.getH3ErrorText(), "Epic sadface: Username and password do not match any user in this service");
    }





}
