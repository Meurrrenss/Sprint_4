package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage extends pages.BasePage {

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //строки на экране для проверки перехода на экран
    final By inputForm = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    public boolean checkItemsDisplayed() {
        return driver.findElements(inputForm).size() > 0;
    }

    //локаторы элементов 1 страницы заказа
    private final By firstName = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private final By lastName = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private final By address = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    private final By metro = By.xpath(".//input[contains(@placeholder, 'метро')]");
    private final By telephone = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    //локаторы элементов 2 страницы заказа
    private final By whenDelivery = By.xpath(".//input[contains(@placeholder, 'Когда')]");
    private final By rentalPeriodButton = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By dayPeriod = By.xpath(".//div[text()='сутки']");
    private final By blackColor = By.id("black");
    private final By comment = By.xpath(".//input[contains(@placeholder, 'Комментарий')]");
    private final By orderingButton =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By nextMonthButton = By.xpath(".//button[@aria-label='Next Month']");
    private final By calenderDate = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--017']");

    private final By viewStatusButton = By.xpath(".//button[text()='Посмотреть статус']");


    //ввести имя
    public void setFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    //ввести фамилию
    public void setLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    //ввести адрес
    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }

    //выбор станции метро
    public void chooseStation(String metro) {
        WebElement element = driver.findElement(this.metro);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='select-search__select']")));
        driver.findElement(By.xpath(".//div[text()='" + metro + "']")).click();
    }

    //ввести номер телефона
    public void setTelephone(String telephone) {
        driver.findElement(this.telephone).sendKeys(telephone);
    }

    //переход на следующую страницу
    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    public void chooseDate() {
        driver.findElement(whenDelivery).click();
        driver.findElement(nextMonthButton).click();
        driver.findElement(calenderDate).click();
    }

    //клик по полю период аренды
    public void clickRentalPeriod() {
        driver.findElement(rentalPeriodButton).click();
    }

    //выбор периода аренды
    public void clickDayPeriod() {
        driver.findElement(dayPeriod).click();
    }

    //выбор черного самоката
    public void setColor(){
        driver.findElement(blackColor).click();
    }

    //написать комментарий
    public void setComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }

    //кликнуть заказать
    public void clickOrderingButton() {
        driver.findElement(orderingButton).click();
    }

    //клик на кнопку "Посмотреть статус"
    public void clickStatusButton() {
        driver.findElement(viewStatusButton).click();
    }
}
