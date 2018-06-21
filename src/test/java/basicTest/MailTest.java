package basicTest;

import factory.BrowserFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.mailru.MailRuPage;

import static util.propertiesreader.PropertiesReader.getPropertyValue;

public class MailTest {
    MailRuPage mailRuPage;
    String username;
    String password;

    @BeforeClass
    public void setUp() {
        mailRuPage = new MailRuPage(BrowserFactory.getDriver());
        username = getPropertyValue("username");
        password = getPropertyValue("password");
    }

    @Test
    public void testSignIn() {
        mailRuPage
                .open()
                .signInWithCredentials(username, password)
                .writeNewLetter();
    }
}
