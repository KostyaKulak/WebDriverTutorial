package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaPage extends CustomPage {
    public JavaPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.java.com";
        this.locators.add(By.xpath("/html/body/div[1]/a"));
        this.locators.add(By.xpath("/html/body/div[1]/p/a[1]"));
        this.locators.add(By.xpath("/html/body/div[1]/p/a[2]"));
        this.locators.add(By.xpath("//*[@id=\"jvc0v2\"]/div[1]/div/div/a/span"));
        this.locators.add(By.xpath("/html/body/div[3]/p/a[10]"));
        this.locators.add(By.xpath("/html/body/div[3]/p/a[9]"));
        this.locators.add(By.xpath("/html/body/div[3]/p/a[8]"));
    }
}
