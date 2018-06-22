package page.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.CustomPage;

import static util.logger.MyLogger.LOGGER;

public class SentPage extends CustomPage {
    @FindBy(xpath = "//*[@id=\"mailbox:login\"]")
    WebElement usernameField;

    private String sentMail;
    private String sentSubject;
    private String sentMessage;
    static String id;

    public SentPage(WebDriver driver) {
        super(driver);
        this.url = "https://e.mail.ru/messages/sent/";
        PageFactory.initElements(this.driver, this);
    }

    public void getInfo() {
        WebElement element = driver.findElement(By.xpath("//div[@data-id='" + id + "']"));
        sentMail = element.findElement(By.xpath("//div[@class='b-datalist__item__addr']")).getText();
        sentSubject = element.findElement(By.xpath("//div[@class='b-datalist__item__subj']")).getText();
        sentMessage = element.findElement(By.xpath("//span[@class='b-datalist__item__subj__snippet']")).getText();
    }

    public boolean isLetterInSentFolder() {
        LOGGER.info("Checking is letter in sent folder");
        return driver.findElements(By.xpath("//div[@data-id='" + id + "']")).size() > 0;
    }

    public MailRuPage logOut() {
        driver.findElement(By.xpath("//*[@id=\"PH_logoutLink\"]")).click();
        usernameField.clear();
        return new MailRuPage(driver).open();
    }

    public String getSentGetter() {
        if (sentMail == null)
            getInfo();
        return sentMail;
    }

    public String getSentSubject() {
        if (sentSubject == null)
            getInfo();
        return sentSubject;
    }

    public String getSentMessage() {
        if (sentMessage == null)
            getInfo();
        return sentMessage;
    }

    @Override
    public SentPage open() {
        return (SentPage) super.open();
    }

    public boolean isLogOutSuccessful() {
        LOGGER.info("Checking is logout successful");
        return driver.getCurrentUrl().contains("https://mail.ru");
    }

    public static void setId(String id) {
        SentPage.id = id;
    }
}
