package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ListProfilePage {
    public final WebDriver driver;
    @FindBy(xpath = "//input[@_ngcontent-c19 and @type='text' and @placeholder='Имя профиля']")
    private WebElement userNameField;
    @FindBy(xpath = "//div[text() = ' Имя профиля ']/p-sorticon/i")
    private WebElement sortByUserProfile;
    @FindBy(css=".ui-table-tbody > div")
    private List<WebElement> profiles_table;


    public ListProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@_ngcontent-c19 and @type='text' and @placeholder='Имя профиля']")));
    }
    public void setUserNameField(String group) throws InterruptedException {
        userNameField.sendKeys(group);
    }
    public void clickSortByUserProfile(){
        sortByUserProfile.click();
    }
    public int tableProfilesSize(){
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".ui-table-tbody > div")));
        return profiles_table.size();
    }
}
