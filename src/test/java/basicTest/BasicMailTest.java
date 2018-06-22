package basicTest;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import page.mailru.MailRuPage;

import java.util.concurrent.TimeUnit;

import static util.constant.CommonProps.IMPLICIT_WAIT;
import static util.propertiesreader.PropertiesReader.getPropertyValue;

public class BasicMailTest {
    MailRuPage mailRuPage;
    String username;
    String password;
    String getter;
    String subject;
    String text;
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        mailRuPage = new MailRuPage(driver);
        username = getPropertyValue("username");
        password = getPropertyValue("password");
        getter = getPropertyValue("getter");
        subject = getPropertyValue("subject");
        text = getPropertyValue("text");
    }
}
