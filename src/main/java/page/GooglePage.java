package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage extends CustomPage {
    public GooglePage(WebDriver driver) {
        super(driver);
        this.url = "https://www.google.by";
        this.locators.add(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]"));
        this.locators.add(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[2]/a"));
        this.locators.add(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[3]/a"));
        this.locators.add(By.xpath("//*[@id=\"gbw\"]/div/div/div[2]/div[4]/div[1]/a/span"));
        this.locators.add(By.xpath("//*[@id=\"fsr\"]/a[1]"));
        this.locators.add(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[2]"));
        this.locators.add(By.xpath("//*[@id=\"fsl\"]/a[1]"));
    }
}
