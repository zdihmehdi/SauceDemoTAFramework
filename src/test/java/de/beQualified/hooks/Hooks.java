package de.beQualified.hooks;

import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Hooks {
    private WebDriver driver;

    /**
     * This hook runs before each scenario
     * It is used to initialize the WebDriver
     */
    @Before
    public void setUp() throws MalformedURLException {
        driver = WebDriverFactory.getDriver();
    }

    /**
     * This hook runs after each scenario
     * It is used to clean up after the scenarios
     */
    @After
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
