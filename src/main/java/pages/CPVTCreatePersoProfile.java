package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPVTCreatePersoProfile {

    public final WebDriver driver;
    @FindBy(xpath = "//span[@class='ui-steps-title' and text()='Подтверждение данных']")
    private WebElement dataConfirmButton;
    @FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Создать профиль']")
    private WebElement createProfileButton;
    @FindBy(id = "sidebar_menu_profiles_profiles")
    private WebElement profileListButton;

    public CPVTCreatePersoProfile(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void selector(String field, String value) throws InterruptedException {
        driver.findElement(By.xpath("//p[@class='panel-text topic mb16' and text()='"+field+"']/following-sibling::p-dropdown")).click();
        driver.findElement(By.xpath("//li[@role='option' and starts-with(@class,'ui-dropdown-item ui-corner-all') and @aria-label='"+value+"']")).click();
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div/ul/p-dropdownitem")));
    }
    public void clickDataConfirmButton(){
        dataConfirmButton.click();
    }
    public void clickCreateProfileButton(){
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createProfileButton));
        createProfileButton.click();
    }
    public ListProfilePage clickProfileListButton(){
        profileListButton.click();
        return new ListProfilePage(driver);
    }

}