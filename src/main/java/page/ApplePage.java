package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplePage extends CustomPage {
    public ApplePage(WebDriver driver) {
        super(driver);
        this.url = "https://www.apple.com";
        this.locators.add(By.xpath("//*[@id=\"ac-gn-firstfocus\"]"));
        this.locators.add(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[2]/a"));
        this.locators.add(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[3]/a"));
        this.locators.add(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[4]/a"));
        this.locators.add(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[5]/a"));
        this.locators.add(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[6]/a"));
        this.locators.add(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[8]/a"));
    }
}
