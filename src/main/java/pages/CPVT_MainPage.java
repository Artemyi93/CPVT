package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPVT_MainPage {

    public final WebDriver driver;

    @FindBy(xpath = "//p-accordiontab[@id='sidebar_menu_profiles']")
    private WebElement persoProfilesButton;

    @FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Создать персо-профиль']")
    private WebElement createPersoProfileButton;

    public CPVT_MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p-accordiontab")));
    }

    public void clickPersoProfiles(){
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(persoProfilesButton));
        persoProfilesButton.click();
    }
    public CPVTCreatePersoProfile clickCreatePersoProfileButton(){
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createPersoProfileButton));
        createPersoProfileButton.click();
        return new CPVTCreatePersoProfile(driver);
    }
}
