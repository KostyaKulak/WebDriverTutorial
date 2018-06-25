package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.constant.CommonProps;

public class BingPage extends CustomPage {
    public BingPage(WebDriver driver) {
        super(driver);
        this.url = CommonProps.BING_URL;
        this.locators.add(By.xpath("//*[@id=\"scpl0\"]"));
        this.locators.add(By.xpath("//*[@id=\"scpl1\"]"));
        this.locators.add(By.xpath("//*[@id=\"scpl2\"]"));
        this.locators.add(By.xpath("//*[@id=\"scpl3\"]"));
        this.locators.add(By.xpath("//*[@id=\"id_sc\"]"));
        this.locators.add(By.xpath("//li[@id=\"office\"]/a"));
        this.locators.add(By.xpath("//li[@id=\"outlook\"]/a"));
    }
}
