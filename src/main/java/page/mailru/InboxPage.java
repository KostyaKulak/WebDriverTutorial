package page.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.CustomPage;

import static util.logger.MyLogger.LOGGER;

public class InboxPage extends CustomPage {
    @FindBy(xpath = "//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']")
    private WebElement newLetterButton;

    public InboxPage(WebDriver driver) {
        super(driver);
        this.url = "https://e.mail.ru/messages/inbox/";
        PageFactory.initElements(this.driver, this);
    }

    public NewLetterPage writeNewLetter() {
        newLetterButton.click();
        return new NewLetterPage(driver);
    }

    public boolean isItInboxPage() {
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
