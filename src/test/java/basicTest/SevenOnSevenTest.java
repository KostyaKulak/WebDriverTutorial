package basicTest;

import factory.BrowserFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;
import page.mailru.MailRuPage;

public class SevenOnSevenTest {
    CustomPage page;

    @Test
    public void testPage1() {
        page = new ApplePage(BrowserFactory.getDriver()).open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.checkElement(1), true);
        softAssert.assertEquals(page.checkElement(2), true);
        softAssert.assertEquals(page.checkElement(3), true);
        softAssert.assertEquals(page.checkElement(4), true);
        softAssert.assertEquals(page.checkElement(5), true);
        softAssert.assertEquals(page.checkElement(6), true);
        softAssert.assertEquals(page.checkElement(7), true);
        softAssert.assertAll();
    }

    @Test
    public void testPage2() {
        page = new BingPage(BrowserFactory.getDriver()).open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.checkElement(1), true);
        softAssert.assertEquals(page.checkElement(2), true);
        softAssert.assertEquals(page.checkElement(3), true);
        softAssert.assertEquals(page.checkElement(4), true);
        softAssert.assertEquals(page.checkElement(5), true);
        softAssert.assertEquals(page.checkElement(6), true);
        softAssert.assertEquals(page.checkElement(7), true);
        softAssert.assertAll();
    }

    @Test
    public void testPage3() {
        page = new JavaPage(BrowserFactory.getDriver()).open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.checkElement(1), true);
        softAssert.assertEquals(page.checkElement(2), true);
        softAssert.assertEquals(page.checkElement(3), true);
        softAssert.assertEquals(page.checkElement(4), true);
        softAssert.assertEquals(page.checkElement(5), true);
        softAssert.assertEquals(page.checkElement(6), true);
        softAssert.assertEquals(page.checkElement(7), true);
        softAssert.assertAll();
    }

    @Test
    public void testPage4() {
        page = new GooglePage(BrowserFactory.getDriver()).open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.checkElement(1), true);
        softAssert.assertEquals(page.checkElement(2), true);
        softAssert.assertEquals(page.checkElement(3), true);
        softAssert.assertEquals(page.checkElement(4), true);
        softAssert.assertEquals(page.checkElement(5), true);
        softAssert.assertEquals(page.checkElement(6), true);
        softAssert.assertEquals(page.checkElement(7), true);
        softAssert.assertAll();
    }

    @Test
    public void testPage5() {
        page = new MailRuPage(BrowserFactory.getDriver()).open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.checkElement(1), true);
        softAssert.assertEquals(page.checkElement(2), true);
        softAssert.assertEquals(page.checkElement(3), true);
        softAssert.assertEquals(page.checkElement(4), true);
        softAssert.assertEquals(page.checkElement(5), true);
        softAssert.assertEquals(page.checkElement(6), true);
        softAssert.assertEquals(page.checkElement(7), true);
        softAssert.assertAll();
    }

    @Test
    public void testPage6() {
        page = new YahooPage(BrowserFactory.getDriver()).open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.checkElement(1), true);
        softAssert.assertEquals(page.checkElement(2), true);
        softAssert.assertEquals(page.checkElement(3), true);
        softAssert.assertEquals(page.checkElement(4), true);
        softAssert.assertEquals(page.checkElement(5), true);
        softAssert.assertEquals(page.checkElement(6), true);
        softAssert.assertEquals(page.checkElement(7), true);
        softAssert.assertAll();
    }

    @Test
    public void testPage7() {
        page = new YandexPage(BrowserFactory.getDriver()).open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.checkElement(1), true);
        softAssert.assertEquals(page.checkElement(2), true);
        softAssert.assertEquals(page.checkElement(3), true);
        softAssert.assertEquals(page.checkElement(4), true);
        softAssert.assertEquals(page.checkElement(5), true);
        softAssert.assertEquals(page.checkElement(6), true);
        softAssert.assertEquals(page.checkElement(7), true);
        softAssert.assertAll();
    }

}
