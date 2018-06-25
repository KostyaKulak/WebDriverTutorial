package page.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static util.logger.MyLogger.LOGGER;

public class InboxPage extends EMailPage {

    public InboxPage(WebDriver driver) {
        super(driver);
        this.url = "https://e.mail.ru/messages/inbox/";
        PageFactory.initElements(this.driver, this);
    }

    public boolean isItInboxPageTitle() {
        while (true) {
            if (driver.getCurrentUrl().contains(this.url)) break;
        }
        LOGGER.info("Checking inbox page title");
        return driver.getTitle().equals("Входящие - Почта Mail.Ru");
    }

    public boolean isLoginSuccessful() {
        while (true) {
            if (driver.getCurrentUrl().contains(this.url)) break;
        }
        LOGGER.info("Checking is login successful");
        return driver.findElements(By.xpath("//*[@id=\"mailbox:error\"]")).size() == 0;
    }


}
