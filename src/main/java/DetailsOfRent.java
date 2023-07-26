import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsOfRent {
    private WebDriver driver;
    //Кнопка выпадающего списка календаря
    private By dateField = By.xpath(".//html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //Выбор даты 23 июля 2023
    private By dateChoose = By.xpath(".//html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[7]");
    //Кнопка выпадающего списка выбора длительности аренды
    private By durationOfRentField = By.xpath(".//html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    //Выбор срока аренды сутки
    private By durationOfRentChoose = By.xpath(".//html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    //Кнопка "Заказать"
    private By orderButton = By.xpath(".//html/body/div/div/div[2]/div[3]/button[2]");
    //Кнопка подтверждения заказа "Да"
    private By confirmationOrderButton = By.xpath(".//html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    //Окно с подтвержденным заказаом и фразой "Заказ оформлен"
    private By windowWithConfirmationOrder = By.xpath(".//html/body/div/div/div[2]/div[5]/div[1][text()='Заказ оформлен']");


    public DetailsOfRent(WebDriver driver) {
        this.driver = driver;
    }
    public void setDateOfRent(){
        driver.findElement(dateField).click();
        driver.findElement(dateChoose).click();
    }
    public void setDurationOfRent(){
        driver.findElement(durationOfRentField).click();
        driver.findElement(durationOfRentChoose).click();
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickConfirmationOrderButton() {
        driver.findElement(confirmationOrderButton).click();
    }
    public void waitForStatusOfOrder() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(windowWithConfirmationOrder));
    }
    public String textInConfirmationWindow(){
        return driver.findElement(windowWithConfirmationOrder).getText();
    }

}
