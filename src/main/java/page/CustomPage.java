package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.constant.CommonProps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static util.constant.CommonProps.IMPLICIT_WAIT;

public class CustomPage {
    protected WebDriver driver;
    protected String url;
    protected List<By> locators;

    public CustomPage(WebDriver driver) {
        this.driver = driver;
        this.url = CommonProps.CUSTOM_URL;
        this.locators = new ArrayList<>();
    }

    public CustomPage openUrl() {
        driver.navigate().to(url);
        return this;
    }

    public boolean checkPage() {
        boolean check = true;
        for (int i = 0; i < locators.size(); i++) {
            try {
                if (!checkElementInListByNumber(i)) {
                    check = false;
                    break;
                }
            }catch (NoSuchElementException e){

            }
        }
        return check;
    }

    public String getUrl() {
        return url;
    }

    private boolean isElementPresent(By element) {
        WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT);
        FluentWait fluentWait = new FluentWait<WebElement>(driver.findElement(element)).withTimeout(Duration.ofSeconds(IMPLICIT_WAIT)).pollingEvery(Duration.ofSeconds(1));
        return driver.findElements(element).size() > 0;
    }

    private boolean checkElementInListByNumber(int number) {
        return isElementPresent(locators.get(number));
    }
}
