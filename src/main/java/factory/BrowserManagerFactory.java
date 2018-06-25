package factory;


public class BrowserManagerFactory {

    public static BrowserManager getManager(String name) {
        BrowserManager browserManager = null;
        switch (name) {
            case "CHROME":
                browserManager = new ChromeBrowserManager();
                break;
            case "FIREFOX":
                browserManager = new FirefoxBrowserManager();
                break;
            default:
                browserManager = new ChromeBrowserManager();
                break;
        }
        return browserManager;
    }

}
