package page.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.CustomPage;

import static util.logger.MyLogger.LOGGER;

public class EMailPage extends CustomPage {
    @FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[1]")
    private WebElement inboxButton;
    @FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[2]")
    private WebElement sendButton;
    @FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[3]")
    private WebElement draftsButton;
    @FindBy(xpath = "//*[@id=\"PH_logoutLink\"]")
    private WebElement logoutButton;
    @FindBy(xpath = "//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']")
    private WebElement newLetterButton;

    public EMailPage(WebDriver driver) {
        super(driver);
        this.url = "https://e.mail.ru/messages/";
        PageFactory.initElements(this.driver, this);
    }

    public void pressInboxButton() {
        inboxButton.click();
    }

    public void pressSendButton() {
        sendButton.click();
    }

    public void pressDraftsButton() {
        boolean staleElement = true;
        while (staleElement) {
            try {
                draftsButton.click();
                staleElement= false;
            } catch (StaleElementReferenceException e) {
            }
        }
    }

    public void pressLogoutButton() {
        logoutButton.click();
    }

    public void pressNewLettterButton() {
        newLetterButton.click();
    }

    public NewLetterPage writeNewLetter() {
        pressNewLettterButton();
        return new NewLetterPage(driver);
    }

    public MailRuPage logOut() {
        pressLogoutButton();
        return new MailRuPage(driver);
    }

    public boolean isFooterOnPage() {
        LOGGER.info("Checking element in page footer");
        return driver.findElements(By.xpath("//*[@id=\"w-portal-footer\"]/table/tbody/tr/td[1]/div/a[1]/span")).size() > 0;
    }

    public boolean isLogOutSuccessful() {
        LOGGER.info("Checking is logout successful");
        return driver.getCurrentUrl().contains("https://mail.ru");
    }
}
