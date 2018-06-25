package factory;

import org.openqa.selenium.firefox.FirefoxDriver;

import static util.logger.MyLogger.LOGGER;

public class FirefoxBrowserManager extends BrowserManager {
    @Override
    public void createDriver() {
        driverThreadLocal.set(new FirefoxDriver(CapabilityFactory.getCapabilities("FIREFOX")));
        LOGGER.debug("ChromeDriver was created");
    }

}
