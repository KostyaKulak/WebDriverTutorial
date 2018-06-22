package page.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.CustomPage;

public class NewLetterPage extends CustomPage {
    @FindBy(xpath = "//textarea[@data-original-name='To']")
    WebElement newLetterGetterField;

    @FindBy(xpath = "//input[@name='Subject']")
    WebElement newLetterTopicField;

    @FindBy(xpath = "//div[@data-group='save-more']")
    private WebElement saveMoreButton;

    boolean isLetterWritten = false;

    public NewLetterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public NewLetterPage writeLetter(String getter, String topic, String text) {
        Actions actions = new Actions(driver);
        actions
                .sendKeys(newLetterGetterField, getter)
                .sendKeys(newLetterTopicField, topic)
                .build()
                .perform();
        WebElement element = driver.findElement(By.xpath("//form[@action='/compose/']"));
        String idEditor = element.getAttribute("id").substring(8, 23);
        WebElement we = driver.findElement(By.xpath("//iframe[@id='toolkit-" + idEditor + "composeEditor_ifr']"));
        driver.switchTo().frame(we);
        driver.findElement(By.id("tinymce")).click();
        driver.findElement(By.id("tinymce")).sendKeys(text);
        driver.switchTo().parentFrame();
        isLetterWritten = true;
        return this;
    }

    public DraftsPage saveAsDraft() {
        saveMoreButton.click();
        driver.findElement(By.xpath("//*[@id=\"b-toolbar__right\"]/div/div/div[2]/div[2]/div/div[3]/div[2]/a[1]")).click();
        while (driver.findElement(By.xpath("//input[@name='draft_msg']")).getAttribute("value").equals("")) {
        }
        WebElement element = driver.findElement(By.xpath("//input[@name='draft_msg']"));
        DraftsPage.setId(element.getAttribute("value"));
        return new DraftsPage(driver).open();
    }


}
