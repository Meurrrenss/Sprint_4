package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends pages.BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    //верхняя кнопка "Заказать"
    private final By topOrderBottom = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    //нижняя кнопка "Заказать"
    private final By botOrderBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    //элементы аккордеона
    private String questionsLinc = "accordion__heading-%d";
    private String answersTextLinc = "accordion__panel-%d";

    //клик по верхней кнопке "Заказать"
    public void clickTopOrderButton() {
        driver.findElement(topOrderBottom).click();
    }
    //клик по нижней кнопке "Заказать"
    public void clickBotOrderButton() {
        driver.findElement(botOrderBottom).click();
    }

    public String checkAnswers(int index) {
        return driver.findElement(By.id(String.format(answersTextLinc, index))).getText();
    }

    public void clickQuestions(int index) {
        driver.findElement(By.id(String.format(questionsLinc, index))).click();
    }
}
