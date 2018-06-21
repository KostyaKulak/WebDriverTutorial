package factory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static factory.CapabilityFactory.getCapabilities;

public class BrowserFactory {

    static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    static void createDriver(String name) {
        Capabilities capabilities = getCapabilities(name);
        switch (name) {
            case "CHROME":
                driver.set(new ChromeDriver((ChromeOptions) capabilities));
                break;
            case "FIREFOX":
                driver.set(new FirefoxDriver((FirefoxOptions) capabilities));
                break;
            case "SAFARI":
                driver.set(new SafariDriver((SafariOptions) capabilities));
                break;
            default:
                driver.set(new FirefoxDriver((FirefoxOptions) capabilities));
                break;
        }
    }

    public static void startDriver(String name) {
        if (driver.get() == null) {
            createDriver(name);
        }
        driver.get().manage().window().maximize();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.get().quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
