package page.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.CustomPage;

public class InboxPage extends CustomPage {
    @FindBy(xpath = "//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span")
    WebElement newLetterButton;

    @FindBy(xpath = "//*[@id=\"toolkit-152959478668541composeForm\"]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div")
    WebElement newLetterGetter;

    @FindBy(xpath = "//*[@id=\"toolkit-152959478668541composeForm\"]/div[1]/div/div[3]/div[4]/div/div/div[2]/div/input")
    WebElement newLetterTopic;

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
        return driver.getTitle().equals("Входящие - Почта Mail.Ru");
    }

    public boolean isLoginSuccessful() {
        return driver.findElements(By.xpath("//*[@id=\"mailbox:error\"]")).size() == 0;
    }


}
