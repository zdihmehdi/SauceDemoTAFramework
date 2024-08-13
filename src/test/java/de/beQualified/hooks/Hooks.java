package de.beQualified.hooks;

import de.beQualified.utilities.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = WebDriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
