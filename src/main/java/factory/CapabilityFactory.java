package factory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CapabilityFactory {
    public  static Capabilities getCapabilities(String name) {
        switch (name) {
            case "CHROME":
                return new ChromeOptions();
            case "FIREFOX":
                return new FirefoxOptions();
            default:
                return new FirefoxOptions();
        }
    }
}
