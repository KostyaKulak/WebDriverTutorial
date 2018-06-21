package factory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class CapabilityFactory {
    public  static Capabilities getCapabilities(String name) {
        switch (name) {
            case "CHROME":
                return new ChromeOptions();
            case "FIREFOX":
                return new FirefoxOptions();
            case "SAFARI":
                return new SafariOptions();
            default:
                return new FirefoxOptions();
        }
    }
}
