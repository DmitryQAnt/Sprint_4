import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageSamokat {
    private WebDriver driver;
    // Кнопка "Заказать" (верхняя)
    private By orderButtonUp = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" (нижняя)
    private By orderButtonDown = By.className("Button_Middle__1CSJM");
    //Кнопка принять куки
    private By cookies = By.className("App_CookieButton__3cvqF");

    public MainPageSamokat(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoad() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(orderButtonDown));
    }
    public void clickOnAllowCookies(){
        driver.findElement(cookies).click();
    }
    public void clickOrderButton() {
        driver.findElement(orderButtonDown).click();
    }
}
