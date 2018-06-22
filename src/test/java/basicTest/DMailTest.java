package basicTest;

import factory.BrowserFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.mailru.*;

import static util.propertiesreader.PropertiesReader.getPropertyValue;

public class DMailTest {
    MailRuPage mailRuPage;
    DraftsPage draftsPage;
    SentPage sentPage;
    InboxPage inboxPage;
    NewLetterPage newLetterPage;
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
    public void testMailInDeclarativeStyle() {
        SoftAssert softAssert = new SoftAssert();
        mailRuPage.open();
        inboxPage = mailRuPage.signInWithCredentials(username, password);
        softAssert.assertTrue(inboxPage.isLoginSuccessful());
        softAssert.assertTrue(inboxPage.isItInboxPage());
        softAssert.assertAll();
        newLetterPage = inboxPage.writeNewLetter();
        newLetterPage.writeLetter(getter, subject, text);
        draftsPage = newLetterPage.saveAsDraft();
        softAssert.assertTrue(draftsPage.isLetterInDrafts());
        softAssert.assertEquals(draftsPage.getDraftGetter(), getter);
        softAssert.assertTrue(draftsPage.getDraftSubject().contains(subject));
        softAssert.assertTrue(draftsPage.getDraftMessage().contains(text));
        softAssert.assertAll();
        sentPage = draftsPage.sendLetterFromDrafts();
        softAssert.assertTrue(sentPage.isLetterInSentFolder());
        softAssert.assertEquals(sentPage.getSentGetter(), getter);
        softAssert.assertTrue(sentPage.getSentSubject().contains(subject));
        softAssert.assertTrue(sentPage.getSentMessage().contains(text));
        softAssert.assertAll();
        sentPage.logOut();
        softAssert.assertTrue(sentPage.isLogOutSuccessful());
        softAssert.assertAll();
    }
}
