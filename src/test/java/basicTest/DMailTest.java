package basicTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.mailru.DraftsPage;
import page.mailru.InboxPage;
import page.mailru.NewLetterPage;
import page.mailru.SentPage;

public class DMailTest extends BasicMailTest {
    private InboxPage inboxPage;
    private NewLetterPage newLetterPage;
    private DraftsPage draftsPage;
    private SentPage sentPage;

    @Test
    public void testMailInDeclarativeStyle() {
        SoftAssert softAssert = new SoftAssert();
        mailRuPage.openUrl();
        inboxPage = mailRuPage.signInWithCredentials(username, password);
        softAssert.assertTrue(inboxPage.isLoginSuccessful());
        softAssert.assertTrue(inboxPage.isItInboxPageTitle());
        softAssert.assertTrue(inboxPage.isFooterOnPage());
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
