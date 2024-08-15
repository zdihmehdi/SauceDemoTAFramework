package de.beQualified.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.function.Function;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setupDriver() throws MalformedURLException {
        ConfigReader configReader = new ConfigReader();
        if (driver.get() == null) {

            switch (configReader.getBrowser()) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    ChromeDriver chromeDriver = new ChromeDriver(options);
                    driver.set(chromeDriver);
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--start-maximized");
                    EdgeDriver edgeDriver = new EdgeDriver(options);
                    driver.set(edgeDriver);
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--start-maximized");
                    FirefoxDriver firefoxDriver = new FirefoxDriver(options);
                    driver.set(firefoxDriver);
                }
                case "remote" -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--start-maximized");
                    driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
                }
            }
        }
    }

    public static WebDriver getDriver() throws MalformedURLException {
        setupDriver();
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static <T> T waitForCondition(Function<WebDriver, T> condition, int timeoutInSeconds) throws MalformedURLException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(condition);
    }
}