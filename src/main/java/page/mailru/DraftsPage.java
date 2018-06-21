package page.mailru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.CustomPage;

public class DraftsPage extends CustomPage {
    public DraftsPage(WebDriver driver) {
        super(driver);
        this.url = "https://e.mail.ru/messages/drafts/";
        PageFactory.initElements(this.driver, this);
    }
}
