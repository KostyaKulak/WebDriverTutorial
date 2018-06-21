package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static util.constant.CommonProps.IMPLICIT_WAIT;

public class CustomPage {
    protected WebDriver driver;
    protected String url;
   protected List<By> locators;

    public CustomPage(WebDriver driver) {
        this.driver = driver;
        this.url = "https://www.epam.by";
        this.locators = new ArrayList<>();
    }

    public CustomPage open() {
        driver.navigate().to(url);
        return this;
    }

    private boolean isElementPresent(By element) {
        WebDriverWait wait = new WebDriverWait(driver, IMPLICIT_WAIT);
        wait.until(driver -> driver.findElements(element));
        return driver.findElements(element).size() > 0;
    }

    public boolean checkElement(int number) {
        return isElementPresent(locators.get(number - 1));
    }
}
