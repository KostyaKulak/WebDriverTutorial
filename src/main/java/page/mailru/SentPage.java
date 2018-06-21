package page.mailru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.CustomPage;

public class SentPage extends CustomPage {

    public SentPage(WebDriver driver) {
        super(driver);
        this.url = "https://e.mail.ru/messages/sent/";
        PageFactory.initElements(this.driver, this);
    }
}
