package basicTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.mailru.EMailPage;

public class FMailTest extends BasicMailTest {

    @Test
    public void testMailInFluentStyle() {
        mailRuPage
                .openUrl()
                .signInWithCredentials(username, password)
                .writeNewLetter()
                .writeLetter(getter, subject, text)
                .saveAsDraft()
                .sendLetterFromDrafts()
                .logOut();
        EMailPage eMailPage = new EMailPage(driver);
        Assert.assertTrue(eMailPage.isLogOutSuccessful());
    }

}
