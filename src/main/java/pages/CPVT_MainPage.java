package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CPVT_MainPage {

    public final WebDriver driver;

    @FindBy(xpath = "//p-accordiontab[@id='sidebar_menu_profiles']")
    private WebElement persoProfilesButton;

    @FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Создать персо-профиль']")
    private WebElement createPersoProfileButton;

    public CPVT_MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickPersoProfiles(){
        persoProfilesButton.click();
    }
    public CPVTCreatePersoProfile clickCreatePersoProfileButton(){
        createPersoProfileButton.click();
        return new CPVTCreatePersoProfile(driver);
    }
}
