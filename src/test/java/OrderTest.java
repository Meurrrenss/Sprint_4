import pages.CookiesPage;
import pages.MainPage;
import pages.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class OrderTest {
    WebDriver driver;

    private String firstName;
    private String lastName;
    private String street;
    private String metro;
    private String phoneNumber;
    private String comment;
    private String orderButton;

    //конструктор для параметризованного теста
    public OrderTest(String firstName, String lastName, String street, String metro, String phoneNumber,
                     String comment, String orderButton) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.orderButton = orderButton;
    }
    //параметры для параметризованного теста
    @Parameterized.Parameters(name = "{index}: firstName={0}, lastName={1}, street={2}, metro={3}, phoneNumber={4}, comment={5}, orderingButton={6}")
    public static Object[][] testData() {
        return new Object[][] {
                {"Ян", "Юн", "Проспект Ленина", "Лубянка", "89109998877", "", "botOrderButton"},
                {"Константин", "Христорождественский", "улица Мира", "Сокольники", "89101112233", "Жду", "topOrderButton"},
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");
        //соглашаемся с куками
        CookiesPage objCookiesPage = new CookiesPage(driver);
        objCookiesPage.allowCookies();
    }


    @Test
    public void checkCreateOrder() {
        MainPage objMainPage = new MainPage(driver);
        OrderPage objOrderPage = new OrderPage(driver);

        if (orderButton.equals("topOrderButton")) {
            objMainPage.clickTopOrderButton();
        } else if (orderButton.equals("botOrderButton")) {
            objMainPage.clickBotOrderButton();
        }

        //проверка перехода на первый экран заполнения данных пользоавтеля
        objOrderPage.checkItemsDisplayed();
        //заполнение данных пользователя на первой странице
        objOrderPage.setFirstName(firstName);
        objOrderPage.setLastName(lastName);
        objOrderPage.setAddress(street);
        objOrderPage.chooseStation(metro);
        objOrderPage.setTelephone(phoneNumber);
        objOrderPage.clickNext();

        //заполнение данных пользователя на второй странице
        objOrderPage.chooseDate();
        objOrderPage.clickRentalPeriod();
        objOrderPage.clickDayPeriod();
        objOrderPage.setColor();
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderingButton();

        //клик по кнопке "Посмотреть статус"
        objOrderPage.clickStatusButton();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
