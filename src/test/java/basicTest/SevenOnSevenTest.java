package basicTest;

import factory.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.ApplePage;
import page.BingPage;
import page.CustomPage;
import page.GooglePage;
import page.JavaPage;
import page.YahooPage;
import page.YandexPage;
import page.mailru.MailRuPage;

public class SevenOnSevenTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = BrowserManager.getDriver();
    }

    @Test
    public void testApplePage() {
        CustomPage page = new ApplePage(driver).openUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.checkPage(), page.getUrl() + " has some mistakes");
        softAssert.assertAll();
    }

    @Test
    public void testBingPage() {
        CustomPage page = new BingPage(driver).openUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.checkPage(), page.getUrl() + " has some mistakes");
        softAssert.assertAll();
    }

    @Test
    public void testJavaPage() {
        CustomPage page = new JavaPage(driver).openUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.checkPage(), page.getUrl() + " has some mistakes");
        softAssert.assertAll();
    }

    @Test
    public void testGooglePage() {
        CustomPage page = new GooglePage(driver).openUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.checkPage(), page.getUrl() + " has some mistakes");
        softAssert.assertAll();
    }

    @Test
    public void testMailRuPage() {
        CustomPage page = new MailRuPage(driver).openUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.checkPage(), page.getUrl() + " has some mistakes");
        softAssert.assertAll();
    }

    @Test
    public void testYahooPage() {
        CustomPage page = new YahooPage(driver).openUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.checkPage(), page.getUrl() + " has some mistakes");
        softAssert.assertAll();
    }

    @Test
    public void testYandexPage() {
        CustomPage page = new YandexPage(driver).openUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.checkPage(), page.getUrl() + " has some mistakes");
        softAssert.assertAll();
    }

}
