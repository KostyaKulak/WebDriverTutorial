package factory;


import org.openqa.selenium.WebDriver;

public abstract class BrowserManager {

    static ThreadLocal<WebDriver> driverThreadLocal;

    static {
        driverThreadLocal = new ThreadLocal<>();
    }

    public abstract void createDriver();

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }


}
