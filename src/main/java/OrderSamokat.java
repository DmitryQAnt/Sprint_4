import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSamokat {
    private WebDriver driver;
    //Поле "Имя"
    private By nameField = By.xpath(".//html/body/div/div/div[2]/div[2]/div[1]/input");
    //Поле "Фамилия"
    private By familyNameField = By.xpath(".//html/body/div/div/div[2]/div[2]/div[2]/input");
    //Поле "Адрес"
    private By adressField = By.xpath(".//html/body/div/div/div[2]/div[2]/div[3]/input");
    //Кнпка списка выбора станции метро
    private By metroField = By.className("select-search__input");
    //Кнопка выбора стацнии метро "Красные ворота"
    private By metroSet = By.xpath(".//html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[7]/button");
    //Поле "Телефон"
    private By telephoneField = By.xpath(".//html/body/div/div/div[2]/div[2]/div[5]/input");
    //Кнопка "Дальше"
    private By buttonNext = By.xpath(".//html/body/div/div/div[2]/div[3]/button");

    public OrderSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setFamilyName(String familyname) {
        driver.findElement(familyNameField).sendKeys(familyname);
    }
    public void setAdress(String adress) {
        driver.findElement(adressField).sendKeys(adress);
    }
    public void setMetroStation(){
        driver.findElement(metroField).click();
        driver.findElement(metroSet).click();
    }
    public void setTelephone(String telephone) {
        driver.findElement(telephoneField).sendKeys(telephone);
    }
    public void clickNextButton() {
        driver.findElement(buttonNext).click();
    }
    public void userDetails(String name, String familyname, String adress, String telephone) {
        setName(name);
        setFamilyName(familyname);
        setAdress(adress);
        setTelephone(telephone);

    }
}
