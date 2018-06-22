package page.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.CustomPage;

public class MailRuPage extends CustomPage {
    @FindBy(xpath = "//*[@id=\"mailbox:login\"]")
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"mailbox:password\"]")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"mailbox:submit\"]/input")
    WebElement enterButton;

    public MailRuPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.mail.ru";
        this.locators.add(By.xpath("//*[@id=\"portal-headline\"]/table/tbody/tr/td[1]/a[1]"));
        this.locators.add(By.xpath("//*[@id=\"portal-headline\"]/table/tbody/tr/td[1]/a[2]"));
        this.locators.add(By.xpath("//*[@id=\"portal-headline\"]/table/tbody/tr/td[1]/a[3]"));
        this.locators.add(By.xpath("//*[@id=\"portal-headline\"]/table/tbody/tr/td[1]/a[4]"));
        this.locators.add(By.xpath("//*[@id=\"portal-headline\"]/table/tbody/tr/td[1]/a[5]"));
        this.locators.add(By.xpath("//*[@id=\"portal-headline\"]/table/tbody/tr/td[1]/a[6]"));
        this.locators.add(By.xpath("//*[@id=\"portal-headline\"]/table/tbody/tr/td[1]/a[7]"));
        PageFactory.initElements(this.driver, this);
    }

    public InboxPage signInWithCredentials(String username, String password) {
        Actions actions = new Actions(driver);
        actions
                .sendKeys(usernameField, username)
                .sendKeys(passwordField, password)
                .click(enterButton)
                .build()
                .perform();
        return new InboxPage(driver);
    }

    @Override
    public MailRuPage open() {
        return (MailRuPage) super.open();
    }

}
