package basicTest;

import factory.BrowserFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.mailru.*;

import static util.propertiesreader.PropertiesReader.getPropertyValue;

public class FMailTest {
    MailRuPage mailRuPage;
    String username;
    String password;
    String getter;
    String subject;
    String text;

    @BeforeClass
    public void setUp() {
        mailRuPage = new MailRuPage(BrowserFactory.getDriver());
        username = getPropertyValue("username");
        password = getPropertyValue("password");
        getter = getPropertyValue("getter");
        subject = getPropertyValue("subject");
        text = getPropertyValue("text");
    }

    @Test
    public void testMailInFluentStyle() {
        mailRuPage
                .open()
                .signInWithCredentials(username, password)
                .writeNewLetter()
                .writeLetter(getter, subject, text)
                .saveAsDraft()
                .sendLetterFromDrafts()
                .logOut();
    }

}
