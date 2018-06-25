package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.constant.CommonProps;

public class YandexPage extends CustomPage {
    public YandexPage(WebDriver driver) {
        super(driver);
        this.url = CommonProps.YANDEX_URL;
        this.locators.add(By.xpath("/html/body/div[1]/div[3]/div[2]/eflll/div[5]/div/div[2]/div/div[1]/div/a[1]"));
        this.locators.add(By.xpath("/html/body/div[1]/div[3]/div[2]/eflll/div[5]/div/div[2]/div/div[1]/div/a[2]"));
        this.locators.add(By.xpath("/html/body/div[1]/div[3]/div[2]/eflll/div[5]/div/div[2]/div/div[1]/div/a[3]"));
        this.locators.add(By.xpath("/html/body/div[1]/div[3]/div[2]/eflll/div[5]/div/div[2]/div/div[1]/div/a[4]"));
        this.locators.add(By.xpath("/html/body/div[1]/div[3]/div[2]/eflll/div[5]/div/div[2]/div/div[1]/div/a[5]"));
        this.locators.add(By.xpath("/html/body/div[1]/div[3]/div[2]/eflll/div[5]/div/div[2]/div/div[1]/div/a[6]"));
        this.locators.add(By.xpath("/html/body/div[1]/div[3]/div[2]/eflll/div[5]/div/div[2]/div/div[1]/div/a[7]"));
    }
}
