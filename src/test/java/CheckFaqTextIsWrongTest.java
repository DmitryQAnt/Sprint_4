import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions; // Import ChromeOptions class
import org.junit.runners.Parameterized;
import static Constances.Locators_Actual.*;
import static Constances.Locators_Unexpected.*;

@RunWith(Parameterized.class)
public class CheckFaqTextIsWrongTest {
    private WebDriver driver;
    private final By cookies = By.className("App_CookieButton__3cvqF");
    private final By click;
    private final By actual;
    private final String expected;
    private String message;
    public CheckFaqTextIsWrongTest(String message, String click, String actual, String expected) {
        this.message = message;
        this.click = By.id(click);
        this.actual = By.xpath(actual);
        this.expected = expected;
    }
    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Первый вопрос", CLICK_HEADER_1, TEXT_HEADER_1, TEXT_UNEXPECTED_1},
                {"Второй вопрос", CLICK_HEADER_2, TEXT_HEADER_2, TEXT_UNEXPECTED_2},
                {"Третий вопрос", CLICK_HEADER_3, TEXT_HEADER_3, TEXT_UNEXPECTED_3},
                {"Четвертый вопрос", CLICK_HEADER_4, TEXT_HEADER_4, TEXT_UNEXPECTED_4},
                {"Пятый вопрос", CLICK_HEADER_5, TEXT_HEADER_5, TEXT_UNEXPECTED_5},
                {"Шестой вопрос", CLICK_HEADER_6, TEXT_HEADER_6, TEXT_UNEXPECTED_6},
                {"Седьмой вопрос", CLICK_HEADER_7, TEXT_HEADER_7, TEXT_UNEXPECTED_7},
                {"Восьмой вопрос", CLICK_HEADER_8, TEXT_HEADER_8, TEXT_UNEXPECTED_8},
        };
    }
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(cookies).click();
    }
    @Test
    public void check_faq_text_is_right() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(click));
        driver.findElement(click).click();
        String actualText = driver.findElement(actual).getText();
        String expectedText = expected;
        MatcherAssert.assertThat(actualText, is(expectedText));
    }
    @After
    public void after_test() {
        driver.quit();
    }
}
