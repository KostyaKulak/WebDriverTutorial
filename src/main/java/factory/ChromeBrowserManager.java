package factory;

import org.openqa.selenium.chrome.ChromeDriver;

import static util.logger.MyLogger.LOGGER;

public class ChromeBrowserManager extends BrowserManager {
    @Override
    public void createDriver() {
        driverThreadLocal.set(new ChromeDriver(CapabilityFactory.getCapabilities("CHROME")));
        LOGGER.info("ChromeDriver was created");
    }

}