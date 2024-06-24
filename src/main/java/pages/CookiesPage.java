package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesPage extends pages.BasePage {

    public CookiesPage(WebDriver driver) {
        super(driver);
    }


    final By cookieButton = By.xpath(".//button[@class = 'App_CookieButton__3cvqF']");


    public void allowCookies() {
        driver.findElement(cookieButton).click();
    }
}


