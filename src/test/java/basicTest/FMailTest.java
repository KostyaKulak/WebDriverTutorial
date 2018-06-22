package basicTest;

import org.testng.annotations.Test;

public class FMailTest extends BasicMailTest {

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
