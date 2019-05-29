package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListProfilePage {
    public final WebDriver driver;
    @FindBy(xpath = "//input[@_ngcontent-c19 and @pinputtext and @placeholder='Имя профиля']")
    private WebElement userNameField;
    @FindBy(xpath = "//div[@_ngcontent-c19 and contains(@class,'p-col ui-sortable-column') and contains(text(),'Имя профиля')]")
    private WebElement sortByUserProfile;
    @FindBy(css=".ui-table-tbody > div")
    private List<WebElement> profiles_table;


    public ListProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void setUserNameField(String group) throws InterruptedException {
        userNameField.click();
        Thread.sleep(200);
        userNameField.sendKeys(group);
    }
    public void clickSortByUserProfile(){
        sortByUserProfile.click();
    }
    public int tableProfilesSize(){
        return profiles_table.size();
    }
}
