import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;


public class OrderSamokatInChromeBrowserTest {
    private WebDriver driver;
    @Before
    public void startUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void check_order_is_right() {
        MainPageSamokat objFirstPage = new MainPageSamokat(driver);
        objFirstPage.waitForLoad();
        objFirstPage.clickOnAllowCookies();
        objFirstPage.clickOrderButton();
        OrderSamokat objOrderPage = new OrderSamokat(driver);
        objOrderPage.setMetroStation();
        objOrderPage.userDetails("Митя", "Мурашев", "Зеленоград", "12345678977"); //Поля формы заполнены корректно
        objOrderPage.clickNextButton();
        DetailsOfRent objDetailsOfRent = new DetailsOfRent(driver);
        objDetailsOfRent.setDateOfRent();
        objDetailsOfRent.setDurationOfRent();
        objDetailsOfRent.clickOrderButton();
        objDetailsOfRent.clickConfirmationOrderButton();
        objDetailsOfRent.waitForStatusOfOrder();

        String actualText = objDetailsOfRent.textInConfirmationWindow();
        String expectedText = "Заказ оформлен";
        assertThat(actualText, startsWith(expectedText));


    }


    @After
    public void after_test() {
        driver.quit();
    }
}
