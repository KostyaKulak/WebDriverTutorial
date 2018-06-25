package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.constant.CommonProps;

public class YahooPage extends CustomPage {
    public YahooPage(WebDriver driver) {
        super(driver);
        this.url = CommonProps.YAHOO_URL;
        this.locators.add(By.xpath("//*[@id=\"yui_3_18_0_3_1529589107884_1074\"]"));
        this.locators.add(By.xpath("//*[@id=\"yui_3_18_0_3_1529589107884_1189\"]"));
        this.locators.add(By.xpath("//*[@id=\"yui_3_18_0_3_1529589107884_1195\"]"));
        this.locators.add(By.xpath("//*[@id=\"yui_3_18_0_3_1529589107884_1191\"]"));
        this.locators.add(By.xpath("//*[@id=\"yui_3_18_0_3_1529589107884_1201\"]"));
        this.locators.add(By.xpath("//*[@id=\"yui_3_18_0_3_1529589107884_1205\"]"));
        this.locators.add(By.xpath("//*[@id=\"yui_3_18_0_3_1529589107884_1216\"]"));
    }
}
