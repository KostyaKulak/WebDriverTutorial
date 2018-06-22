package page.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CustomPage;

import static util.logger.MyLogger.LOGGER;

public class DraftsPage extends CustomPage {

    private String draftGetter;
    private String draftSubject;
    private String draftMessage;
    private String xpathOnOurLetter;
    private static String id;

    public DraftsPage(WebDriver driver) {
        super(driver);
        this.url = "https://e.mail.ru/messages/drafts/";
        PageFactory.initElements(this.driver, this);
    }

    public void getLetterInfoInDrafts() {
        xpathOnOurLetter = "//div[@data-id='" + id + "']";
        WebElement element = driver.findElement(By.xpath(xpathOnOurLetter));
        draftGetter = element.findElement(By.xpath("//div[@class='b-datalist__item__addr']")).getText();
        draftSubject = element.findElement(By.xpath("//div[@class='b-datalist__item__subj']")).getText();
        draftMessage = element.findElement(By.xpath("//span[@class='b-datalist__item__subj__snippet']")).getText();
    }

    public SentPage sendLetterFromDrafts() {
        if (xpathOnOurLetter == null)
            getLetterInfoInDrafts();
        driver.findElement(By.xpath(xpathOnOurLetter)).click();
        By locator = By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div");
        WebDriverWait wait = new WebDriverWait(driver, 100, 10);
        wait.until(driver -> driver.findElement(locator));
        boolean staleElement = true;
        while (staleElement) {
            try {
                driver.findElement(locator).click();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                LOGGER.error(e.getMessage());
            }
        }
        SentPage.setId(getIdOfSentLetter());
        return new SentPage(driver).open();
    }

    public boolean isLetterInDrafts() {
        LOGGER.info("Checking is letter in drafts folder");
        return driver.findElements(By.xpath("//div[@data-id='" + id + "']")).size() > 0;
    }

    private String getIdOfSentLetter() {
        By locator = By.xpath("//a[text()='письмо']");
        new WebDriverWait(driver, 100, 10).until(driver -> driver.findElement(locator));
        driver.findElement(locator).click();
        By secondLocator = By.xpath("//*[@id=\"b-letter\"]/div[2]");
        return driver.findElement(secondLocator).getAttribute("data-letter-id");
    }

    public static void setId(String newId) {
        id = newId;
    }

    public String getDraftGetter() {
        if (draftGetter == null)
            getLetterInfoInDrafts();
        return draftGetter;
    }

    public String getDraftSubject() {
        if (draftSubject == null)
            getLetterInfoInDrafts();
        return draftSubject;
    }

    public String getDraftMessage() {
        if (draftMessage == null)
            getLetterInfoInDrafts();
        return draftMessage;
    }

    @Override
    public DraftsPage open() {
        return (DraftsPage) super.open();
    }
}
